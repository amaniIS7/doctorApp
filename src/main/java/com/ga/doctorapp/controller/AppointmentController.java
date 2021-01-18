package com.ga.doctorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ga.doctorapp.dao.AppointmentDao;
import com.ga.doctorapp.dao.DoctorDao;
import com.ga.doctorapp.model.Appointment;

@Controller
public class AppointmentController {


	@Autowired 
	private Environment env;
	
	@Autowired
	private DoctorDao dcdao;
	
	
	@GetMapping("/appointment/add")
	
	public ModelAndView addAppointment() {
		System.out.println("work");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("appointment/add");
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		var it = dcdao.findAll();
		mv.addObject("Doctors", it);
		
		return mv;
	}
	
	@Autowired
	private AppointmentDao apointmentdao;
	
	
	@PostMapping("/appointment/add")
	public String addAppointment(Appointment Appointment) {
		apointmentdao.save(Appointment);
		
		return "redirect:/appointment/index";
	}
	
	// HTTP GET REQUEST - Article Index
	@GetMapping("/appointment/index")
	public ModelAndView getAppointment() {
		var it = apointmentdao.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("appointment/index");
		mv.addObject("appointments", it);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	
	
}
