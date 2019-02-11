package com.jong.open.board;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Board {
	private int no; // 순번 
	private String bname; // 작성자 
	private String bpassword; // 비번
	private String bcontent; // 내용
}
