package com.jong.open.mapper;

import java.util.List;

import com.jong.open.board.Board;
import com.jong.open.board.Criteria;

public interface BoardMapper {

	public void insertContent(Board board); // 게시판 컨텐츠 넣기

	public Board readContent(int no); // 읽긔

	public List<Board> getList();// 리스트 

	public List<Board> getListWithPaging(Criteria cri); // 페이징 처리 

	public int countList(); //페이징 처리

	public void delete(int no); // 삭제 

	public String getPW(int no); // 비번 
}