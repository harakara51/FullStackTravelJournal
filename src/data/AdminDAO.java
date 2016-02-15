package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import Entities.Trip;
import Entities.User;
import controller.LoginController;

@Transactional
public class AdminDAO
{

	@PersistenceContext
	private EntityManager em;
	
	LoginDAO loginDAO = new LoginDAO();
	
	public List<User> getALLUser ()
	{
		
		List<User> allusers = new ArrayList<>(); 
		allusers = em.createNamedQuery("User.getUserByName").getResultList();
		return null;
	
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
