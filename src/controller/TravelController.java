package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Entities.User;
import data.LoginDAO;


@Controller
@SessionAttributes({ "username","password"})
public class TravelController{
	@Autowired
	private LoginDAO loginDAO;
public static String USERNAME;

	
	
	
	
	
	

}
