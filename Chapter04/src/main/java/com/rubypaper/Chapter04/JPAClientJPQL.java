package com.rubypaper.Chapter04;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.rubypaper.Chapter04.domain.Board;

public class JPAClientJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		try {
			String jpql = "select b from Board b where b.seq < 11 order by b.seq asc";
			TypedQuery<Board> tq = em.createQuery(jpql,Board.class);
			List<Board>list = tq.getResultList();
			for(Board b : list) 
				System.out.println(b);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
