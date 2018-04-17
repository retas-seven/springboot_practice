package com.tuyano.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/mail.properties")
public class MailUtil {
	private static final Logger log = LoggerFactory.getLogger(MailUtil.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Async
    public void send(String sendToAddr, String content) {
		log.info("メール送信処理：開始");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(sendToAddr);
        msg.setSubject("WebAdressbook登録確認");
        msg.setText("＜URL＞\n" + content);
        mailSender.send(msg);
		log.info("メール送信処理：終了");
    }
}
