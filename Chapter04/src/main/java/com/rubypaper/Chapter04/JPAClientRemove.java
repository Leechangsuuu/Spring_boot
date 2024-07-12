package com.rubypaper.Chapter04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.Chapter04.domain.Board;

public class JPAClientRemove {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Board board = em.find(Board.class, 6L);
//			board.setSeq(1L);
//			
//			board.setSeq(5L);
			em.remove(board);
//		     if (board != null) {
//	                em.remove(board);
//	            } else {
//	                System.out.println("삭제할 엔티티가 없습니다.");
//	            }
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
