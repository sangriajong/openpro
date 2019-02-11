package com.jong.open.board;

import lombok.Data;

@Data
public class Criteria {
// 게시판 조회 도우미 클래스 Criteria
// https://blog.hanumoka.net/2018/08/10/spring-20180810-spring-board-paging/
	
	private int pageNum; // 페ㅔ이지 번호  
	private int amount;  // 양 
	private int startNum;  //시작
	private int endNum; // 끝 

	public Criteria() {
		this(1, 3); // 1페이지당 3개씩만 보여주긔 
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

	public void calcStartNum() {
		startNum = (pageNum - 1) * amount;
	}
}