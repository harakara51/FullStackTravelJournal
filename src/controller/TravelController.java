package controller;

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
@SessionAttributes({ "username","password"})
public class TravelController{
	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private TravelDAO travelDAO;
public static String USERNAME;

@ModelAttribute("username")
public String createUserName()
{
	String username="";
	return username;
}

@ModelAttribute("password")
public String createPassword()
{
	String password="";
	return password;
}
	
@RequestMapping(path = "addtrip.do", method = RequestMethod.POST)
public ModelAndView createTrip()
{

	System.out.println("inside creating new trip method");

	ModelAndView mv = new ModelAndView();

	// System.out.println("In controller and size of array is" +
	// NovelDAO.getNovelByLanguage(language).size());
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
	// System.out.println("In controller and size of array is" +
	// NovelDAO.getNovelByLanguage(language).size());
	mv.setViewName("dashboard.jsp");
	return mv;
}
	
	

}
