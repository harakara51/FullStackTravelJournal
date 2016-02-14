package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import Data.LoginDAO;
import Entities.User;


@Controller
@SessionAttributes({ "username","password"})
public class LoginController{
	@Autowired
	private LoginDAO loginDAO;


	
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
	
	
	@RequestMapping(path = "GetUserTravel.do", params = "username", method = RequestMethod.POST)
	public ModelAndView getByName(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		ModelAndView mv = new ModelAndView();

	   User user =loginDAO.getUserByUsername(username);
	   User userPW =loginDAO.getUserByPassword(password);
	  
	   if((user != null) && (userPW !=null))
	   { 
		mv.setViewName("dashboard.jsp");
		mv.addObject("user",user );
		System.out.println("in user login controller");

		return mv;
	   }
	   else if (user == null)
	   {
		   System.out.println("In null ");
		   mv.setViewName("index.jsp"); 
		   String userNotFound ="Username or Password is incorrect";
		   mv.addObject("user",userNotFound );
		   return mv;
	   }
	   else if (userPW ==null)
	   {
		   mv.setViewName("index.jsp"); 
		   String wrongPW ="Username or Password is incorrect";
		   mv.addObject("user",wrongPW );
		   return mv;
		   
	   }
	   
	   return mv;
	   
	  
	}

	
	@RequestMapping(path = "CreateUserTravel.do",  method = RequestMethod.POST)
	public ModelAndView createUser()
	{
		
		System.out.println("inside creating new user method");
	
		ModelAndView mv = new ModelAndView();
		
		// System.out.println("In controller and size of array is" +
		// NovelDAO.getNovelByLanguage(language).size());
		mv.setViewName("newUser.jsp");
		return mv;
	}
	
	@RequestMapping(path = "CreateUserDB.do",  method = RequestMethod.POST)
	public ModelAndView createUserinDB(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email)
	{
		
		System.out.println("inside method to submit data to database");
		System.out.println("username :" + username + " password " + password + " " + email);
		Boolean newUser =true;
		
		ModelAndView mv = new ModelAndView();
		
		

		 loginDAO.creatNewUser(username, password, email);
		// System.out.println("In controller and size of array is" +
		// NovelDAO.getNovelByLanguage(language).size());
		mv.setViewName("index.jsp");
		return mv;
	}
	

}
