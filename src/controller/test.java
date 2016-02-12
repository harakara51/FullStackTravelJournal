package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
		
		User Travis = new User("Travis","dsfalf@fladsjf.com","1234");
		
		
	//	TypedQuery<User> query = em.createQuery 
//                ("select U from User U where U.username = ",
//                 User.class);
		
		String query = "select U from User U where U.username = ";
//      TypedQuery<Job> tq = em.createQuery(query, Job.class);
//      List<Job> jobs = tq.getResultList();
      
	
//		String query = "SELECT U FROM User U where e.username =";
//		TypedQuery test = em.createQuery(query, User.class);
//      List<Job> jobs = tq.getResultList();
		
		
	//	System.out.println(temp.getPassword());
//		Travis.setUsername("TRAVIS");
		
		em.getTransaction().begin();
		em.persist(Travis);
		em.getTransaction().commit();


		
		
	}

}
