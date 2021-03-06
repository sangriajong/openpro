package com.jong.open.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jong.open.mapper.MemberMapper;
import com.jong.open.member.Member;

public class MemberDAO {
	
	@Autowired
	private MemberMapper mapper;
	
	public boolean login(String id, String password) {
		String pw = "";
		
		Member member = mapper.selectById(id);
		
		if(member != null) pw = member.getPassword();
		
		return pw.equals(password); 
	}
	
	public Member selectById(String id) {
		Member member = mapper.selectById(id);
		
		return member;
	}
	
	public boolean signup(Member member) {
		
		try {
			mapper.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Member> getList() {
		List<Member> list = new ArrayList<>();
		mapper.getList().forEach(member -> list.add(member));
		
		return list;
	}

		

	public static void updateAuthkey(Member member) {
		// TODO Auto-generated method stub
		
	}
	
}