package com.tuyano.springboot.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.tuyano.springboot.exceptioon.SystemException;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
@PropertySource("classpath:/mail.properties")
public class MailUtil {
	private static final Logger log = LoggerFactory.getLogger(MailUtil.class);
	
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private Configuration freemarkerConfig;
    
    @Async
    public void send(String sendToAddr, String url) {
    	try {
	        MimeMessage message = emailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(
	        		message
	                , MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED
	                , StandardCharsets.UTF_8.name());
	
	        Map<String, String> model = new HashMap<>();
	        model.put("url", url);
	        
	        Template t = freemarkerConfig.getTemplate("mail/regist_address.ftl");
	        String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
	
	        helper.setTo(sendToAddr);
	        helper.setText(html, true);
	        helper.setSubject("Web Adressbook 登録受付確認");
	        helper.setFrom("no-reply@webaddressbook.com");
	
	        emailSender.send(message);
    	} catch (MessagingException | IOException | TemplateException e) {
    		throw new SystemException(e);
    	}
    }
}
