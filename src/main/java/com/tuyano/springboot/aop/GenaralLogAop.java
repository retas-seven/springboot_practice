package com.tuyano.springboot.aop;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.tuyano.springboot.constant.ApConst;
import com.tuyano.springboot.dao.UserInfoDao;
import com.tuyano.springboot.exceptioon.ApplicationException;
import com.tuyano.springboot.exceptioon.SystemException;

@Aspect
@Component
public class GenaralLogAop {
	private static final Logger log = LoggerFactory.getLogger(GenaralLogAop.class);
	
	@Autowired
	private UserInfoDao userInfoDao;
	
//    @Around("execution(* com.tuyano.springboot.controller..*.*(..)) || execution(* com.tuyano.springboot.security..*.*(..))")
    @Around("execution(* com.tuyano.springboot.controller..*.*(..))")
    public Object invoke(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object ret = null;
        try {
            log.info(String.format("[START] %s#%s",
                    proceedingJoinPoint.getTarget().getClass(),
                    proceedingJoinPoint.getSignature().getName()));

            // 業務処理で使用するシステム日付を取得する
            LocalDateTime dt = userInfoDao.getDateTime();
            HttpServletRequest request = 
            		((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
            request.setAttribute(ApConst.REQUEST_KEY_SYSDATE, dt);
            
            // 業務処理実行
            ret = proceedingJoinPoint.proceed();

        // 例外発生時は内容をログに出力する。例外のハンドリングは例外ハンドラクラスで行うため、再スローする。
        } catch (ApplicationException e) {
            log.warn("アプリケーションエラー発生：" + e.getErrMsg());
            throw e;
            
        } catch (SystemException e) {
            log.error("システムエラー発生：" + e.getMessage());
            throw e;
            
        } catch (Exception e) {
            log.error("例外発生：" + e.getCause());
            e.printStackTrace();
            throw new SystemException(e);
            
        } finally {
            log.info(String.format("[END  ] %s#%s",
                    proceedingJoinPoint.getTarget().getClass(),
                    proceedingJoinPoint.getSignature().getName()));
        }
        
        return ret;
    }
    
    @Around("execution(* com.tuyano.springboot.service..*.*(..))")
    public Object invokeService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object ret = null;
        
        log.info(String.format("[START] %s#%s",
                proceedingJoinPoint.getTarget().getClass(),
                proceedingJoinPoint.getSignature().getName()));

        // 業務処理実行
        ret = proceedingJoinPoint.proceed();

        log.info(String.format("[END  ] %s#%s",
                proceedingJoinPoint.getTarget().getClass(),
                proceedingJoinPoint.getSignature().getName()));

        return ret;
    }
}