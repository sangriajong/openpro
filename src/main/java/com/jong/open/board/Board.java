package com.jong.open.board;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Board {
	private int no;
	private String bname;
	private String bpassword;
	private String bcontent;
}
