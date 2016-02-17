package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Entities.Location;
import Entities.Trip;
import Entities.User;
import data.TravelDAO;



@Controller
@SessionAttributes({ "user"})
public class TravelController{

	@Autowired
	private TravelDAO travelDAO;

	
@RequestMapping(path = "addtrip.do", method = RequestMethod.POST)
public ModelAndView createTrip()
{
	System.out.println("inside creating new trip method");
	ModelAndView mv = new ModelAndView();
	mv.setViewName("newTrip.jsp");
	return mv;
}

@RequestMapping(path = "CreateTripDB.do", method = RequestMethod.POST)
public ModelAndView createTripDB(@RequestParam("trip_name") String tripname,
		@RequestParam("date_started") String dateStarted, @RequestParam("date_ended") String dateEnded, @ModelAttribute ("user") User user)
{
	System.out.println("inside creating trip to db method");
	ModelAndView mv = new ModelAndView();
	travelDAO.createNewTrip(user, tripname,dateStarted,dateEnded);
	user = travelDAO.refreshUser(user);
	mv.addObject("user", user);
	mv.setViewName("dashboard.jsp");
	return mv;
}

	
@RequestMapping(path = "addlocation.do", method = RequestMethod.POST)
public ModelAndView addLocation(@RequestParam("trip_id") int tripId)
{
	System.out.println("inside creating new location method");
//	System.out.println(tripId);
	ModelAndView mv = new ModelAndView();
	
	
	
	mv.setViewName("newLocation.jsp");
	mv.addObject("trip_id", tripId);
	return mv;
}

@RequestMapping(path = "CreateLocationDB.do", method = RequestMethod.POST)
public ModelAndView createLocationDB(@RequestParam("trip_id") int tripId, @RequestParam("location_name") String locationName, @RequestParam("city") String city, @RequestParam("country") String country,
		@RequestParam("date_started") String dateStarted, @RequestParam("date_ended") String dateEnded, 
		@RequestParam("audio_src") String audioSrc, @RequestParam("audio_text") String audioText,@RequestParam("video_src") String videoSrc,
		@RequestParam("video_txt") String videoText,@RequestParam("img_src") String imgSrc,@RequestParam("img_txt") String imgText,
		@RequestParam("text_body") String textBody, @ModelAttribute ("user") User user
		
		
		
		)
{
	
	
	System.out.println("inside creating location to db method");
	Trip tempTrip = travelDAO.findTripById(tripId);
	
	ModelAndView mv = new ModelAndView();
	
	Location loc =travelDAO.creatNewLocation(tempTrip, locationName,city, country, dateStarted,dateEnded);
	
	
	travelDAO.creatNewAudio(loc, audioSrc, audioText);
	
	travelDAO.creatNewImage(loc, imgSrc, imgText);
	travelDAO.creatNewVideo(loc, videoSrc, videoText);
	travelDAO.creatNewText(loc, textBody);
	user = travelDAO.refreshUser(user);
	mv.addObject("user", user);
	mv.setViewName("dashboard.jsp");
	return mv;
}
	

@RequestMapping(path = "loadDashboard.do", method = RequestMethod.GET)
public ModelAndView loadDashboard()
{

	System.out.println("inside creating trip to db method");
	
	ModelAndView mv = new ModelAndView();
	mv.addObject("user");
	mv.setViewName("dashboard.jsp");
	return mv;
}

@RequestMapping(path = "deletelocation.do", method = RequestMethod.POST)
public ModelAndView deleteLocation(@RequestParam("location_id") int locationId,@RequestParam("trip_id") int tripId,@ModelAttribute ("user") User user)
{
	
	System.out.println("inside method to delete location");
	Trip trip = travelDAO.findTripById(tripId);
	Location loc = travelDAO.findLocationById(locationId);
	
	travelDAO.deleteLocationById(trip, locationId);
	ModelAndView mv = new ModelAndView();
	user = travelDAO.refreshUser(user);
	mv.addObject("user", user);
	
	mv.setViewName("dashboard.jsp");
	return mv;
}

@RequestMapping(path = "editlocation.do", method = RequestMethod.POST)
public ModelAndView editLocation(@RequestParam("location_id") int locationId,@ModelAttribute ("user") User user)
{
	System.out.println("inside creating trip to db method");
	
	ModelAndView mv = new ModelAndView();
	user = travelDAO.refreshUser(user);
	mv.addObject("user", user);
	mv.setViewName("dashboard.jsp");
	return mv;
}


@RequestMapping(path = "deleteTrip.do", method = RequestMethod.POST)
public ModelAndView deleteTrip(@RequestParam("trip_id") int tripId,@ModelAttribute ("user") User user)
{
	
	System.out.println("inside method to delete location");
	travelDAO.deleteTripById(user,tripId);
	ModelAndView mv = new ModelAndView();
	user = travelDAO.refreshUser(user);
	mv.addObject("user", user);
	mv.setViewName("dashboard.jsp");
	return mv;
}


}
