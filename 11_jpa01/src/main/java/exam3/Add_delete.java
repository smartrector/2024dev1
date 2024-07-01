package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Add_delete {

	public static void main(String[] args) {
		  EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("JpaEx01");
	        EntityManager entityManager = emf.createEntityManager();
	        EntityTransaction transaction = entityManager.getTransaction();
	        
	        try {
	            transaction.begin();
	            
	            Member3 user = entityManager.find(Member3.class, "test@test.com");
	            
	            if(user == null) {
	            	System.out.println("존재하지 않음");
	            	transaction.rollback();
	            	return;
	            }
	            entityManager.remove(user);
	            
	            transaction.commit();
	            System.out.println("탈퇴처리되었습니다.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            transaction.rollback();
	        } finally {
	        	entityManager.close();
	        }

	        emf.close();
	}

}
