package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entities.User;

public class test
{
	public static void main(String[] args)
	{
		System.out.println("in main");
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Travel");
		System.out.println("after Factory");
		EntityManager em = emf.createEntityManager();
		System.out.println("after EM");
		
		User Travis = new User("Travos","dsfalf@fladsjf.com","123334");
//		Travis.setUsername("TRAVIS");
		
		em.getTransaction().begin();
		em.persist(Travis);
		em.getTransaction().commit();


		
		
	}

}
