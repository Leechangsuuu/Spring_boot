package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController//데이터를 리턴
public class BoardController {
	public BoardController(){
		System.out.println("===> BoardController생성");
		log.error("error");
		
	}
	@GetMapping("/hello")
	public String hello(String name) {// localhost:8080/hello?name=이창수
		return "Hello : " + name;
	}
	@PostMapping("/hello")
	public String helloPost(String name) {// localhost:8080/hello?name=이창수
		return "Hello Post: " + name;
	}
	@GetMapping("/getBoard")//localhost:8080/getBoard
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 제목...");
		board.setWriter("테스터");
		board.setContent("테스트 내용입니다..............");
		board.setCreateDate(new Date());
		board.setCnt(0);
		return board;
	}
	@GetMapping("/getBoardList")//localhost:8080/getBoardList
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i); 
			board.setTitle("제목"+i);
			board.setWriter("테스터");
			board.setContent(i + "번 내용입니다.");
			board.setCreateDate(new Date());
			board.setCnt(0);
			boardList.add(board);
		}
		return boardList;
	}
}






















