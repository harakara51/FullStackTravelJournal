package data;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import Entities.Location;
import Entities.Trip;
import Entities.User;
import controller.LoginController;

@Transactional
public class TravelDAO
{
	@PersistenceContext
	private EntityManager em;
	public static User loggedin;

	LoginDAO loginDAO = new LoginDAO();

	public static void setLoggedin(User l)
	{
		loggedin = l;
	}

	public void createNewTrip(User user, String tripName, String dateStarted, String dateEnded)
	{

		System.out.println("In method to create trip");
		Trip newTrip = new Trip(loggedin, tripName, dateStarted, dateEnded);
		System.out.println(newTrip.getId());
		user.addTrip(newTrip);
		em.persist(newTrip);

	}

	public Trip findTripById(int tripID)
	{

		System.out.println("In method to find trip by iD");
		Trip newTrip = (Trip) em.createNamedQuery("Trip.getTripById").setParameter("id", tripID).getSingleResult();
		System.out.println(newTrip.getId());

		return newTrip;

	}

	public Location findLocationById(int locationID)
	{

		System.out.println("In method to find Location by ID");
		Location newLocation = (Location) em.createNamedQuery("Location.getLocationById").setParameter("id", locationID)
				.getSingleResult();
		System.out.println(newLocation.getId());

		return newLocation;

	}

	public void deleteLocationById(Trip trip, int locationID)
	{

		System.out.println("In method to delete Location by ID");

		Location loc = em.find(Location.class, locationID);
		
		trip.removeLocation(loc);
		em.remove(loc);
		
		// em.createNamedQuery("Location.deleteLocationById")
		// .setParameter("id", locationID).executeUpdate();

		//em.refresh(trip);
		
		//System.out.println(trip.getLocations());
		// trip.setLocations(locations);

	}
	
	
	
	public void deleteTripById(User user, int tripID)
	{

		
		System.out.println("In method to delete Location by ID");

		Trip trip = em.find(Trip.class, tripID);
		user.removeTrip(trip);
		em.remove(trip);
	
	}
	

	public void creatNewLocation(Trip tripId, String locationName, String city, String country, String dateStarted,
			String dateEnded)
	{

		System.out.println("In method to create location");

		// Location loc = new Location (locationName,dateStarted, dateEnded);
		Location loc = new Location(tripId, locationName, city, country, dateStarted, dateEnded);
		
		tripId.addLocation(loc);
		// System.out.println(loc.getId());
	//	Collection<Location> locations = tripId.getLocations();
//		locations.add(loc);
//		loc.setTrip_id(tripId);
//		tripId.setLocations(locations);
		em.persist(loc);

	}
	

	
	
	public User refreshUser (User user)
	{
		System.out.println("refereshig users");
	user = em.merge(user);
	em.refresh(user);
		return user;
	}

}
