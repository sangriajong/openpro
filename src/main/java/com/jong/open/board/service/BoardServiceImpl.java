package com.jong.open.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jong.open.board.Board;
import com.jong.open.board.Criteria;
import com.jong.open.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	public boolean insertContent(Board board) {
		boolean result = true;
		
		try {
			mapper.insertContent(board);
		} catch(Exception e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}

	public Board readContent(int no) {
		
		return mapper.readContent(no);
	}
	
	public List<Board> getList(){
		
		List<Board> list = new ArrayList<>();
		mapper.getList().forEach(board -> list.add(board));
		
		return list;
	}
	
	public int countList() {
		return mapper.countList();
	}

	@Override
	public List<Board> getList(Criteria cri) {
		List<Board> list = new ArrayList<>();
		mapper.getListWithPaging(cri).forEach(book -> list.add(book));
		
		return list;
	}

	@Override
	public boolean delete(int no) {
		boolean result = true;
		
		try {
			mapper.delete(no);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public boolean checkPW(int no, String bpassword) {
		
		String pw = mapper.getPW(no);
		
		return bpassword.equals(pw);
	}

}