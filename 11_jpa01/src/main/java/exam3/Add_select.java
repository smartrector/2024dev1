package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Add_select {

	public static void main(String[] args) {
		EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("JpaEx01");
        EntityManager entityManager = emf.createEntityManager();
        
        Member3 user = entityManager.find(Member3.class, "test@test.com" ); 
        
        if(user != null) {
        	System.out.println("이름 : " + user.getName());
        	System.out.printf("생성 :  %tY - %<tm - %<td\n",user.getCreateDate());
        }else {
        	System.out.println("데이타없음!!!!");
        }
        
        
        
        
        entityManager.close();
        emf.close();
	}

}
