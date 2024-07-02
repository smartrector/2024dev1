package exam4;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Test01_insert {
	
	public static void main(String[] args) {
		 EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("JpaEx01");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction transaction = em.getTransaction();
	        
	        try {
	            transaction.begin();
	            
	            Member4 user;
	            
	            user = new Member4("test1@test.com", "이순신", LocalDate.now());
	            em.persist(user);
	            user = new Member4("test2@test.com", "강감찬", LocalDate.now());
	            em.persist(user);
	            user = new Member4("test3@test.com", "을지문덕", LocalDate.now());
	            em.persist(user);
	            user = new Member4("test4@test.com", "계백", LocalDate.now());
	            em.persist(user);
	            user = new Member4("test5@test.com", "김유신", LocalDate.now());
	            em.persist(user);
	            user = new Member4("test6@test.com", "연개소문", LocalDate.now());
	            em.persist(user);
	            user = new Member4("test7@test.com", "양만춘", LocalDate.now());
	            em.persist(user);
	            user = new Member4("test8@test.com", "김종서", LocalDate.now());
	            em.persist(user);
	            user = new Member4("test9@test.com", "최영", LocalDate.now());
	            em.persist(user);
	            
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	            transaction.rollback();
	        } finally {
	        	em.close();
	        }

	        emf.close();
	}

}
