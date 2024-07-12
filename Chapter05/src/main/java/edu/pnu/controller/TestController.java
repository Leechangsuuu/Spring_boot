package edu.pnu.controller;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Date;
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
//		String query = "select * from BOARD";
//		try {
//			PreparedStatement psmt = con.prepareStatement(query);
//			ResultSet rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				Board board = new Board();
//				board.setSeq(rs.getLong("seq"));
//				board.setTitle(rs.getString("title"));
//				board.setWriter(rs.getString("writer"));
//				board.setContent(rs.getString("content"));
//				board.setCreateDate(rs.getDate("createDate"));
//				board.setCnt(rs.getLong("cnt"));
//				list.add(board);
//				
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
	}
//	
	@GetMapping("/board/(seq)")
	public Board getBoard(@PathVariable Long seq) {
		return boardRepo.findById(seq).get();
		
		
//		String query = "select * from BOARD where seq=?";
//		try {
//			PreparedStatement psmt = con.prepareStatement(query);
//			psmt.setLong(1, seq);
//			ResultSet rs = psmt.executeQuery();
//			
//			if(rs.next()) {
//				board.setSeq(rs.getLong("seq"));
//				board.setTitle(rs.getString("title"));
//				board.setWriter(rs.getString("writer"));
//				board.setContent(rs.getString("content"));
//				board.setCreateDate(rs.getDate("createDate"));
//				board.setCnt(rs.getLong("cnt"));
//			}
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return board;
	}
	@PostMapping("/board")//add
	public Board postBoard(@RequestBody Board board) {
//		Board board = new Board();
//		board.setTitle(board.getTitle());
//		board.setWriter(board.getWriter());
//		board.setContent(board.getContent());
//		board.setCreateDate(board.getCreateDate());
//		board.setCnt(board.getCnt());
		return boardRepo.save(board);
		
	}
//		String query = "insert into BOARD (title, writer)"
//					+ " value (?,?)";
//		try {
//			PreparedStatement psmt = con.prepareStatement(query);
//			psmt.setString(1,board.getTitle());
//			psmt.setString(2, board.getWriter());
//			psmt.executeUpdate();
//			
//			boardRepo.save(board);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return board;
	@PutMapping("/board")//수정
	public Board putBoard(@RequestBody Board board) {
		Board b = boardRepo.findById(board.getSeq()).orElseThrow();
		
		if(board.getTitle() != null) b.setTitle(board.getTitle());
		if(board.getContent() != null) b.setContent(board.getContent());
		return boardRepo.save(b);
//		Board board = boardRepo.findById(1L).get();
//		String query = "update BOARD set"
//					+ " title = ? , writer = ? "
//					+ " where "
	}
	@DeleteMapping("/board/(seq)")
	public Board deleteBoard(@PathVariable Long seq) {
		Board b = boardRepo.findById(seq).orElseThrow();
		boardRepo.deleteById(seq);
		return boardRepo.save(b);
	}
}
