package controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Entities.Audio;
import Entities.Image;
import Entities.Location;
import Entities.Text;
import Entities.Trip;
import Entities.User;
import Entities.Video;
import data.AdminDAO;
import data.LoginDAO;
import data.TravelDAO;

@Controller
@SessionAttributes(
{ "user" })
public class AdminController
{

	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private TravelDAO travelDAO;
	@Autowired
	private AdminDAO adminDAO;
	public static String USERNAME;

	@RequestMapping(path = "editAccount.do", method = RequestMethod.POST)
	public ModelAndView createTrip(@RequestParam("username") String username)
	{
		System.out.println("inside creating new trip method");
		ModelAndView mv = new ModelAndView();
		User user = loginDAO.getUserByUsername(username);
		mv.addObject("user", user);
		mv.setViewName("editUser.jsp");
		
		return mv;
	}

	

}
