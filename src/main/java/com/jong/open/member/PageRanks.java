package com.jong.open.member;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PageRanks {
	//페이징 처리 DTO
	private int rank;
	private String page;


}
