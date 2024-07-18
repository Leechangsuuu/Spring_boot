package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {
	private final BoardRepository boardRepo;
//	private Connection con;
	
	@GetMapping("/board")
	public List<Board>getBoards(){
		return boardRepo.findAll();
	}
//	
	@GetMapping("/board/{seq}")
	public Board getBoard(@PathVariable Long seq) {
		return boardRepo.findById(seq).get();
	}
	
	@PostMapping("/board")//add
	public Board postBoard(@RequestBody Board board) {
		return boardRepo.save(board);
	}

	@PutMapping("/board")//수정
	public Board putBoard(@RequestBody Board board) {
		Board b = boardRepo.findById(board.getSeq()).orElseThrow();
		if(board.getTitle() != null) b.setTitle(board.getTitle());
		if(board.getContent() != null) b.setContent(board.getContent());
		return boardRepo.save(b);
	}
	
	@DeleteMapping("/board/{seq}")
	public Board deleteBoard(@PathVariable Long seq) {
		Board b = boardRepo.findById(seq).orElseThrow();
		boardRepo.deleteById(seq);
		return boardRepo.save(b);
	}
}
