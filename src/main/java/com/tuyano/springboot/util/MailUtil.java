package com.tuyano.springboot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/mail.properties")
public class MailUtil {
	
	@Autowired
	private MailSender mailSender;
	
    public void send(String sendToAddr, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(sendToAddr);
        msg.setSubject("WebAdressbook登録確認");
        msg.setText("＜URL＞\n" + content);
        mailSender.send(msg);
    }
}
