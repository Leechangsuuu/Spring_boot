package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

@RestController
public class BoardController {
	@GetMapping("/hello")
	public String hello(String name) {
		
	}
	@GetMapping("/getBoard")
	public BoardVO Writer(BoardVO board) {
		BoardVO board = new BoardVO();
		return board;																																													
	}
}
