package com.jong.open.mail;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void mailSend(String to, String authCode) {

		MimeMessage message = javaMailSender.createMimeMessage();

		try {

			// 제목설정
			message.setSubject("인증 메일 입니다.", "utf-8");

			// 받는 이메일 설정
			message.addRecipient(
					RecipientType.TO, 
					new InternetAddress(to));

			// 내용 설정
			
			// String HtmlMsg ="<h1>제발 들어가줘 ㅠ </h1> <a href=\"http://localhost/login/login/\">로그인하기</a>";
			// message.setText(HtmlMsg,"utf-8","html");
		
			String HtmlMsg = "<h1>회원가입을 환영합니다.</h1> <a href=\"http://localhost/open/mail/"+authCode+"?id="+to+"\">인증하러 가기</a>";
			message.setText(HtmlMsg, "utf-8", "html");


			javaMailSender.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}