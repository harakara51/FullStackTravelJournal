package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



import data.AdminDAO;
import data.LoginDAO;
import data.TravelDAO;

import Entities.User;

@Controller
@SessionAttributes({ "username"})
public class LoginController
{
	@Autowired
	private LoginDAO loginDAO;
	private TravelDAO travelDAO;
	public static String USERNAME;

	@ModelAttribute("user")
	public User createUserName()
	{
		User user = new User();
		return user;
	}
	

	@RequestMapping(path = "GetUserTravel.do", params = "username", method = RequestMethod.POST)
	public ModelAndView getByName(@RequestParam("username") String username, @RequestParam("password") String password)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", username);
		
		User user = loginDAO.getUserByUsername(username);
		User userPW = loginDAO.getUserByPassword(password);


		if ((user != null) && (userPW != null))
		{
			if (user.getIs_admin())
			{
				AdminDAO Admin = new AdminDAO();
				List<User> alluser =Admin.getALLUser();
				mv.setViewName("adminView.jsp");
				mv.addObject("allusers", alluser);
				mv.addObject("user", user);
				System.out.println("in user login controller");

				return mv;

			} else
			{
				mv.setViewName("dashboard.jsp");
				TravelDAO.setLoggedin(user); 
				mv.addObject("user", user);
			
				System.out.println("in user login controller");

				return mv;
			}
		} else if (user == null)
		{
			System.out.println("In null ");
			mv.setViewName("index.jsp");
			String userNotFound = "Username is incorrect";
			mv.addObject("userNotFound", userNotFound);
			return mv;
		} else if (userPW == null)
		{
			mv.setViewName("index.jsp");
			String wrongPW = "Password is incorrect";
			mv.addObject("userNotFound", wrongPW);
			return mv;

		}

		return mv;

	}

	@RequestMapping(path = "CreateUserTravel.do", method = RequestMethod.POST)
	public ModelAndView createUser()
	{

		System.out.println("inside creating new user method");

		ModelAndView mv = new ModelAndView();

		// System.out.println("In controller and size of array is" +
		// NovelDAO.getNovelByLanguage(language).size());
		mv.setViewName("newUser.jsp");
		return mv;
	}

	@RequestMapping(path = "CreateUserDB.do", method = RequestMethod.POST)
	public ModelAndView createUserinDB(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("email") String email)
	{

		System.out.println("inside method to submit data to database");
		System.out.println("username :" + username + " password " + password + " " + email);

		ModelAndView mv = new ModelAndView();

		String userExist = loginDAO.creatNewUser(username, password, email);

		if (userExist == null)
		{
			mv.setViewName("index.jsp");
			return mv;
		} else
		{
			mv.addObject("userExist", userExist);
			mv.setViewName("newUser.jsp");
			return mv;

		}

	}

}
