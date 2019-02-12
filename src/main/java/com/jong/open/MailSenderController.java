package com.jong.open;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jong.open.mail.MailSendService;
import com.jong.open.member.Member;

@Controller
public class MailSenderController {
	@Inject // 주입
	private MailSendService mailService;

	// 매핑
	@RequestMapping("/simplemailsend")
	public String simpleMailSend(HttpServletRequest request) {

		Member m = (Member) request.getSession().getAttribute("login");
		System.out.println(m);
		String email = m.getId();
		String authKey = m.getAuthKey() + "";
		mailService.mailSend(email, authKey);

		return "mail/sendmailOK";
	}

}