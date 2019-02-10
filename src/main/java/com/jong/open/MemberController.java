package com.jong.open;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jong.open.member.Member;
import com.jong.open.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	// 자동 주입 + member 매핑 
	@Autowired
	private MemberService service;
	
	// mypage 매핑 
	@RequestMapping("/mypage")
	public String mypage() {
		return "/member/mypage";
	}
	
	// 멤버 리스트 매핑
	@RequestMapping("/memberList")
	public String memberList(Model model) {
		
		List<Member> list = service.getList();
		model.addAttribute("list", list);
		
		return "/member/memList";
	}
}