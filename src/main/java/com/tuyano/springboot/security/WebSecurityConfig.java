package com.tuyano.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserInfoService userDetailsService;
	
    @Override
    public void configure(WebSecurity web) throws Exception {
        // セキュリティ設定を無視するリクエスト設定
        // 静的リソース(images、css、javascript)に対するアクセスはセキュリティ設定を無視する
        web.ignoring().antMatchers(
                            "/img/**",
                            "/css/**",
                            "/js/**"
                            );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 認可の設定
        http.authorizeRequests()
            .antMatchers("/").permitAll() // indexは全ユーザーアクセス許可
//            .antMatchers("/**").hasRole("USER")
            .anyRequest().authenticated() // それ以外は全て認証無しの場合アクセス不許可
            .and()
            .csrf().disable();
            ;
		
        // ログイン設定
        http.formLogin()
            .loginProcessingUrl("/exec_login") // 認証処理のパス
            .loginPage("/") // ログインフォームのパス
//          .failureUrl("/?error") // 認証失敗時に呼ばれるハンドラクラス
            .failureHandler(new GeneralAuthenticationFailureHandler())
            .defaultSuccessUrl("/menu", true) // 認証成功時の遷移先
            .usernameParameter("email")
            .passwordParameter("password") // ユーザー名、パスワードのパラメータ名
            ;

        // ログアウト設定
        http.logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウト処理のパス
            .logoutSuccessUrl("/login") // ログアウト完了時のパス
            ;
    }

    @Configuration
    static class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {
 
        @Autowired
        private UserInfoService userDetailsService;
 
        @Bean //パスワードの暗号化方式を設定
        public PasswordEncoder passwordEncoder() {
//        	BCryptPasswordEncoder ret = new BCryptPasswordEncoder();
//        	System.out.println("aaa is [" + ret.encode("aaa") + "]");
//            return ret; 
        	return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
        }
 
        @Override
        public void init(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
            ;
        }
     }
}
