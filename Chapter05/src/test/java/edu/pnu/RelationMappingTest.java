package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;
@SpringBootTest
public class RelationMappingTest {
	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private MemberRepository memberRepo;
	
	@Test
	public void testTwoWaymapping() {
		Member member1 = Member.builder()
				.id("member1")
				.password("member111")
				.name("둘리")
				.role("User").build();
//		memberRepo.save(member1);
		
		Member member2 = Member.builder()
				.id("member2")
				.password("member222")
				.name("도우너")
				.role("Admin").build();
//		memberRepo.save(member2);
		
		for(int i = 1;i<=3; i++) {
			Board.builder()
				.title("title"+i)
				.content("content"+i)
				.createDate(new Date())
				.cnt((long)(Math.random()*100))
				.member(member1)
				.build();
//			boardRepo.save(board);
		}
		memberRepo.save(member1);
		
		for(int i = 1;i<=3; i++) {
			Board.builder()
				.title("title"+i)
				.content("content"+i)
				.createDate(new Date())
				.cnt((long)(Math.random()*100))
				.member(member2)
				.build();
//		boardRepo.save(board);
		}
		memberRepo.save(member2);
		
		
//		Member member = memberRepo.findById("member1").get();
//		
//		System.out.println("=====================");
//		System.out.println(member.getName()+"가 저장한 게시글 목록");
//		System.out.println("=====================");
//		List<Board>list=member.getBoardList();
//		for(Board board : list) {
//			System.out.println(board.toString());
//		}
//		@Test
//		public void testCascadeDelete() {
//			memberRepo.deleteById("member2");
//		}
	}

}
