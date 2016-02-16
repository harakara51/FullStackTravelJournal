package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import data.LoginDAO;

import data.TravelDAO;

import Entities.User;



@Controller

public class TravelController{
	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private TravelDAO travelDAO;
	private static User Username = new User();




	
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
		@RequestParam("date_started") String dateStarted, @RequestParam("date_ended") String dateEnded)
{
	System.out.println("inside creating trip to db method");
	ModelAndView mv = new ModelAndView();;
	travelDAO.createNewTrip(tripname,dateStarted,dateEnded);
	mv.setViewName("dashboard.jsp");
	return mv;
}

	
@RequestMapping(path = "addlocation.do", method = RequestMethod.POST)
public ModelAndView addLocation()
{
	System.out.println("inside creating new trip method");
	ModelAndView mv = new ModelAndView();
	mv.setViewName("newLocation.jsp");
	return mv;
}

@RequestMapping(path = "CreateLocationDB.do", method = RequestMethod.POST)
public ModelAndView createLocationDB(@RequestParam("location_name") String locationName,
		@RequestParam("date_started") String dateStarted, @RequestParam("date_ended") String dateEnded)
{
	System.out.println("inside creating trip to db method");
	
	ModelAndView mv = new ModelAndView();
	travelDAO.creatNewLocation(locationName,dateStarted,dateEnded);
	mv.setViewName("dashboard.jsp");
	return mv;
}
	

}
