package com.tuyano.springboot.util;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;

public class MailUtil {

    public static void send(MailSender mailSender, String sendToAddr, String content) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(sendToAddr);
        msg.setSubject("WebAdressbook登録確認");
        msg.setText("＜URL＞\n" + content);
        mailSender.send(msg);
    }
}
