package edu.pnu;


import java.util.Date;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
//서버 구동시 자동 실행 인터페이스
public class DataInit implements ApplicationRunner  {
	private final BoardRepository boardRepo;
	
	@Override
	public void run(ApplicationArguments args)throws Exception{
		for(int i =1; i<=5; i++) {
			boardRepo.save(Board.builder()
					.title("title1" + i)
					.writer("member1")
					.content("content1"+i)
					.createDate(new Date())
					.cnt((long)(Math.random()*100))
					.build()
				);
		}
		
		for(int i =1; i<=5; i++) {
			boardRepo.save(Board.builder()
					.title("title2" + i)
					.writer("member2")
					.content("content2"+i)
					.createDate(new Date())
					.cnt((long)(Math.random()*100))
					.build()
				);
		}
	}
}