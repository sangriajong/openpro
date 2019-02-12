package com.jong.open;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jong.open.member.Member;
import com.jong.open.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class DownloadController {
	
	@Autowired
	private MemberService memberService;
	

	//pdf
	@RequestMapping("/pdf")
	public ModelAndView getMemberPdf() throws Exception {
		List<Member> result = memberService.getList();
		
		return new ModelAndView("memberPdf", "result", result);
	}
	
	

}
