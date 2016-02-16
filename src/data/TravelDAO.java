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
	public static User loggedin;
	
	LoginDAO loginDAO = new LoginDAO();
	
	public static void setLoggedin(User l) {
		loggedin = l;
	}
	
	

	
	public void createNewTrip (String tripName, String dateStarted, String dateEnded)
	{
		
		
			System.out.println("In method to create trip");

			
			Trip newTrip = new Trip(loggedin, tripName,dateStarted, dateEnded);
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
