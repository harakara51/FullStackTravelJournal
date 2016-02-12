package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.User;

public class LoginDAO {
	
	public User getUser(String userName, String password){ 
		System.out.println("in main");
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Travel");
		System.out.println("after Factory");
		EntityManager em = emf.createEntityManager();
		System.out.println("after EM");
		
		User Temp =(User)em.createNamedQuery("User.getUserByName")
        .setParameter("name", userName).setParameter("password", password).getSingleResult();
		
		return Temp;
	}

}
