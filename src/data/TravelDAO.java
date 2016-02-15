package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import Entities.Trip;
import Entities.User;
import controller.LoginController;

@Transactional
public class TravelDAO {
	@PersistenceContext
	private EntityManager em;
	
	LoginDAO loginDAO = new LoginDAO();
	
	public void creatNewUser (String username, String password, String email)
	{
		
		User newUser = new User(username,password, email);
		System.out.println(newUser.getEmail());
		em.persist(newUser);
	
	}
	
	public void creatNewTrip ()
	{
		User User_ID = loginDAO.getUserByUsername(LoginController.USERNAME);
			
		Trip newTrip = new Trip(User_ID);
		User_ID.setTrips(newTrip);	
		System.out.println(newTrip.getId());
		em.persist(newTrip);
	
	}
	
	public void creatNewLocation (String username, String password, String email)
	{
		
		User newUser = new User(username,password, email);
		System.out.println(newUser.getEmail());
		em.persist(newUser);
	
	}
	

}
