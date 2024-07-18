package edu.pnu;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testFindByTitle() {
		
		List<Board> list=boardRepo.findByTitle("title10");
		System.out.println("--> testByTitle");
		for(Board b : list)
			System.out.println(b);
	}
	@Test
	public void testByContaining() {
		List<Board> boardList = boardRepo.findByContentContaining("5");
		System.out.println("검색결과");
		for(Board b : boardList)
			System.out.println(b);
	}
	@Test
	public void testFindByTitleContaingOrContentContaining() {
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("5", "7");
		System.out.println("검색결과");
		for(Board b : boardList)
			System.out.println(b);
	}
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(0,5);
		List<Board>boardList = boardRepo.findByTitleContaining("title", paging);
		System.out.println("검색결과");
		for(Board b : boardList)
			System.out.println(b);
	}
//	@Test
//	public void testQueryAnnotationTest1() {
//		List<Board> boardList = boardRepo.queryAnnotationTest1("title10");
//		System.out.println("검색결과");
//		for(Board b : boardList)
//			System.out.println("---->" + b.toString());
//	}
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Object[]>boardList = boardRepo.queryAnnotationTest2("title10");
//		System.out.println("검색결과");
//		for(Object[] row: boardList)
//			System.out.println("---->" + Arrays.toString(row));
//	}
}




























