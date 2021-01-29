package com.ga.doctorapp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ga.doctorapp.dao.UserDao;
import com.ga.doctorapp.model.User;

@Controller
public class UserController {
	@Autowired
	private Environment env;
	@Autowired
	private UserDao dao;
	@Autowired
	HttpServletRequest request;
	// Routes
	// to load the registration form
	@GetMapping("/user/registration")
	public ModelAndView registration() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/registration");
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		return mv;
	}
	// to post the registration form
	@PostMapping("/user/registration")
	public ModelAndView registration(User user) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		// Check if the user is already registered or not
		var it = dao.findAll();
		for (User dbUser : it) {
			if (dbUser.getEmailAddress().equals(user.getEmailAddress())) {
				mv.addObject("message", "User already exists");
				return mv;
			}
		}
		// password Encryption
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		String newPassword = bCrypt.encode(user.getPassword());
		user.setPassword(newPassword);
		dao.save(user);
		mv.addObject("message", "User registered successfully");
		return mv;
	}
//	///////////////////////////////////////////////////////////////////
	// to load the login form
	@GetMapping("/user/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user/login");
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		return mv;
	}
	// to post the login form
	@PostMapping("/user/login")
	public String login(User user) {
		HttpSession session = request.getSession();
		BCryptPasswordEncoder bCryt = new BCryptPasswordEncoder();
		String emailAddress = user.getEmailAddress();
		String password = user.getPassword();
		User matchedUser = dao.findByEmailAddress(emailAddress);
		if(matchedUser != null) {
			if(bCryt.matches(password, matchedUser.getPassword())) {
				// Session
				session.setAttribute("user", matchedUser);
				session.setAttribute("userRole", matchedUser.getUserRole());
				session.setAttribute("message", "You are logged in successfully");
				session.setAttribute("messageType", "success");
				return "redirect:/";
			}
		}
		session.setAttribute("message", "Username or password is incorrect");
		session.setAttribute("messageType", "danger");
		return "redirect:/user/login";
	}
	// to invalidate the current user session
	@GetMapping("/user/logout")
	public String logout() {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/user/login";
	}
	// to check the user is logged in or not
	public boolean isUserLoggedIn() {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			return false;
		}
		else {
			return true;
		}
	}
}