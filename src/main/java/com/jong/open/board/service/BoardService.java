package com.jong.open.board.service;

import java.util.List;

import com.jong.open.board.Board;
import com.jong.open.board.Criteria;

public interface BoardService {
	public boolean insertContent(Board board);

	public Board readContent(int no);

	public List<Board> getList();

	public List<Board> getList(Criteria cri);

	public int countList();

	public boolean delete(int no);

	public boolean checkPW(int no, String gpassword);
}