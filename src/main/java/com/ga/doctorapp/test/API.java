package com.ga.doctorapp.test;

	
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RestController;
	@RestController
	
	  public class API {
	  @GetMapping ("/hello")
	  public String hello() {
		 
		  return "doctor app work ";
		  }
			
	 }

