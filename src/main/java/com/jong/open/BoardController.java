package com.jong.open;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jong.open.board.Board;
import com.jong.open.board.Criteria;
import com.jong.open.board.Page;
import com.jong.open.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/board")
	public String list(Criteria cri, Model model) {
		cri.calcStartNum();
		model.addAttribute("board", service.getList(cri));
		model.addAttribute("page", new Page(cri, service.countList()));
		return "/board/board";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "/board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(Model model, Board board, Criteria cri) {
		boolean result = service.insertContent(board);
		
		if(!result) {
			model.addAttribute("msg", "작성 실패");
			return "/board/write";
		} else {
			return list(cri, model);
		}
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam("no") int no, Model model) {
		model.addAttribute("no", no);
		
		return "/board/delete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(Model model, @RequestParam("no") int no, @RequestParam("bpassword") String bpassword, Criteria cri) {
		
		
		boolean result = service.checkPW(no, bpassword);
		String msg = "삭제 실패";
		
		if(result) {
			boolean result2 = service.delete(no);
			if(result2) msg = "삭제 성공";
		}
		
		model.addAttribute("msg", msg);
		
		return list(cri, model);
	}
}