package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import data.LoginDAO;




@Controller
@SessionAttributes({ "username","password"})
public class LoginController{
public LoginDAO loginDAO = new LoginDAO();


	
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
		
		
		System.out.println("in user login controller");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dashboard.jsp");
		mv.addObject("user", loginDAO.getUser(username,password));
		

		return mv;
	}

	
	@RequestMapping(path = "CreateUserTravel.do",  method = RequestMethod.POST)
	public ModelAndView createUser()
	{
		
		System.out.println("inside creating new user method");
		Boolean newUser =true;
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userNew", newUser);
		// System.out.println("In controller and size of array is" +
		// NovelDAO.getNovelByLanguage(language).size());
		mv.setViewName("newUser.jsp");
		
		

		
		

		return mv;
	}
	
	

}
