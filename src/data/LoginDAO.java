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
	
	public User getUserByUsername(String userName){ 
		
		User Temp;
		
		
		try {
			
			System.out.println("in method to get user based on username and the username is " + userName);	
		Temp =(User)em.createNamedQuery("User.getUserByName")
        .setParameter("name", userName).getSingleResult();
		System.out.println("username is not nul " + Temp.getUsername());
		}
		catch (Exception e)
		{
			System.out.println("In catch");
			Temp =null;	
		}
		finally {
			System.out.println("In finally");
			
		}	
		return Temp;

	}
	
	public User getUserByPassword(String password){ 
		
		User Temp;
		System.out.println("in method to get user based on password");
		
		try {
			Temp =(User)em.createNamedQuery("User.getUserByPassword")
			        .setParameter("password", password).getSingleResult();
			System.out.println("password is not null " + Temp.getPassword());
		}
		catch (Exception e)
		{
			System.out.println("In catch");
			Temp =null;	
		}
		finally {
			System.out.println("In finally");
			
		}	
		return Temp;
	
	}

}
