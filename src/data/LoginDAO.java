package Data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import Entities.User;

@Transactional
public class LoginDAO {
	@PersistenceContext
	private EntityManager em;
	
	public User getUser(String userName, String password){ 
		
		
		System.out.println("in method to get user based on username and password");
		
		System.out.println("after Factory");
	
		System.out.println("after EM");
		
		User Temp =(User)em.createNamedQuery("User.getUserByName")
        .setParameter("name", userName).setParameter("password", password).getSingleResult();
		
		return Temp;
	}

}
