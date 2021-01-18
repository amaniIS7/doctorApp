package com.ga.doctorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.doctorapp.dao.AppointmentDao;
import com.ga.doctorapp.dao.DoctorDao;
import com.ga.doctorapp.model.Appointment;

@Controller
public class AppointmentController {

	@Autowired
	private Environment env;
	@Autowired
	private DoctorDao doctordao;
	
	@GetMapping("/appointment/add")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("appointment/add");
		
		var it = doctordao.findAll();
		mv.addObject("doctors", it);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		return mv;
	}
	@Autowired
	private AppointmentDao dao;
	@PostMapping("/appointment/add")
	public String add(Appointment appointment) {
		dao.save(appointment);
		return "redirect:/appointment/index";
	}
	@GetMapping("/appointment/index")
	public ModelAndView index() {
		var it = dao.findAll();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("appointment/index");
		mv.addObject("appointments", it);

		HomeController hc = new HomeController();
		hc.setAppName(mv, env);

		return mv;
	}
	

	@GetMapping("/appointment/delete")
	public String delete(@RequestParam int id) {
		dao.deleteById(id);
		return "redirect:/appointment/index";
		
	}
}