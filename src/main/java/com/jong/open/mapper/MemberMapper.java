package com.jong.open.mapper;

import java.util.List;

import com.jong.open.member.Member;

public interface MemberMapper {
	
	
public Member selectById(String id); // 멤버 아디 
	


public void insertMember(Member member); // 주입

public List<Member> getList(); // 멤버 list 

public int delete(int idx); // 삭제 

public int update(Member member); // 업뎃 

public int statusOK(String authKey, String id);  // 암호화를 통한 인증 상태 체크 
}

