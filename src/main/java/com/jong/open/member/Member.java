package com.jong.open.member;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Member {
	//Membr DTO
	private int idx; // 순서 시퀀스 넣기
	private String id; // 아디
	private String password; // 비번
	private String name; // 이름
	private String photo; // 사진
	private Date regDate; // 등록일
	private String authKey; // 암호화 등록 키 ?
	private int status; // 상태 0 , 1 

}
