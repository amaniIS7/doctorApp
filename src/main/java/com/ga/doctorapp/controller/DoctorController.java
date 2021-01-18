package com.ga.doctorapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ga.doctorapp.dao.DoctorDao;
import com.ga.doctorapp.model.Doctor;

@Controller
public class DoctorController {

	
	//add
	// delete
	
	
	
	
	
	
	@Autowired 
	private Environment env;
	@GetMapping("/doctor/add")
	public ModelAndView addDoctor(){
		System.out.println("working");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doctor/add");
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
	
		return mv;
	}

	@Autowired
	private DoctorDao dao;
	
	
	@PostMapping("/doctor/add")
	public String addDoctor(Doctor doctor) {
		dao.save(doctor);
		return "redirect:/doctor/index";
	}
	
	@GetMapping("/doctor/index")
	public ModelAndView geDoctor() {
		var it = dao.findAll();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doctor/index");
		mv.addObject("doctors", it);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
	}
	@GetMapping("/doctor/details")
	public ModelAndView doctorDetails(@RequestParam int id) {
		System.out.println(id);
		
		Doctor doctor = dao.findById(id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("doctor/details");
		mv.addObject("doctor", doctor);
		
		HomeController hc = new HomeController();
		hc.setAppName(mv, env);
		
		return mv;
		
	}
	
	@GetMapping("/doctor/delete")
	public String deleteDoctor(@RequestParam int id) {
		dao.deleteById(id);
		return "redirect:/doctor/index";
	}
}
