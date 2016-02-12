package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import Entities.User;


//	@NamedQuery(name = "User.getUserByName", query =
//			"select u.username from User u where u.username= :name")

public class test
{
	
	public static void main(String[] args)
	{
		System.out.println("in main");
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Travel");
		System.out.println("after Factory");
		EntityManager em = emf.createEntityManager();
		System.out.println("after EM");
		String test ="Travis";
		String password ="1234";
		
//		User Travis = new User("Travis","dsfalf@fladsjf.com","1234");
//		
		User Temp =(User)em.createNamedQuery("User.getUserByName")
        .setParameter("name", test).setParameter("password", password).getSingleResult();
		
		
		
		
		
	
		System.out.println(Temp.getPassword());
//		Travis.setUsername("TRAVIS");
//		
//		em.getTransaction().begin();
//		
//		em.getTransaction().commit();


		
		
	}

}
