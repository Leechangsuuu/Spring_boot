package com.rubypaper.Chapter04;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.Chapter04.domain.Board;

public class JPAClientPersist {
	public static void main(String[]args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
//		try {
//			tx.begin();
//			em.persist(Board.builder()
//					.title
//					);
		
		try {
			tx.begin();
			Board board = new Board();
			board.setTitle("JPA제목");
			board.setWriter("관리자");
			board.setContent("JPA글 등록 잘되네");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			
			em.persist(board);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
			emf.close();
		}
	}
}
