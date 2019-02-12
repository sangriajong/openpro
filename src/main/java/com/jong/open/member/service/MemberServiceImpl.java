package com.jong.open.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jong.open.mapper.MemberMapper;
import com.jong.open.member.Member;
import com.jong.open.member.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper; // 주입 매퍼

	public boolean login(String id, String password) {
		String pw = "";

		Member member = mapper.selectById(id);

		if (member != null)
			pw = member.getPassword();

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

	@Override
	public boolean delete(int idx) {
		boolean result;

		result = mapper.delete(idx) == 1 ? true : false;

		return result;
	}

	@Override
	public boolean modify(Member member) {

		int rowCnt = 0;

		try {
			rowCnt = mapper.update(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCnt == 1 ? true : false;
	}

	@Autowired
	private JavaMailSender mailSender;	
	@Override
	@Transactional
	public void create(Member member) throws Exception {
		MemberDAO.create(member);
		
		// 임의의 authkey 생성
		String authkey = new TempKey().getKey(50, false);

	
		member.setAuthkey(authkey);
		MemberDAO.updateAuthkey(member);
	
	
	
	
	
	
	
	
	
	
}