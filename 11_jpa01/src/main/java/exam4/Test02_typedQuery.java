package exam4;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class Test02_typedQuery {

	public static void main(String[] args) {
		 EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("JpaEx01");
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction transaction = em.getTransaction();
	        
	        try {
	            transaction.begin();
	            
	            TypedQuery<Member4> query = em.createQuery(
	            		"select m from Member4 m order by m.name",
	            		Member4.class);
	            List<Member4> result = query.getResultList();

	            transaction.commit();
	            
	            if(result.isEmpty()) {
	            	System.out.println("사용자가 없습니다.");
	            }else {
	            	result.forEach( user ->
	            		System.out.printf("| %s | %s | %tY - %<tm - %<td | \n", 
	            				user.getEmail(),user.getName(),user.getCreateDate()));
	            }
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            transaction.rollback();
	        } finally {
	        	em.close();
	        }

	        emf.close();
	}

}
