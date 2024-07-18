package edu.pnu.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

@Controller
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/getBoardList",method = {RequestMethod.GET,RequestMethod.POST} )
	public String getBoardList(Model model, Board board) {
		List<Board>boardList = boardService.getBoardList(board);
		
		model.addAttribute("boardList",boardList);
		return "getBoardList";
	}
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board",boardService.getBoard(board));
		return "getBoard";
	}
}	
