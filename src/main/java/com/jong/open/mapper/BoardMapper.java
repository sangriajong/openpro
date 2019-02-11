package com.jong.open.mapper;

import java.util.List;

import com.jong.open.board.Board;
import com.jong.open.board.Criteria;

public interface BoardMapper {

	public void insertContent(Board board);

	public Board readContent(int no);

	public List<Board> getList();

	public List<Board> getListWithPaging(Criteria cri);

	public int countList();

	public void delete(int no);

	public String getPW(int no);
}