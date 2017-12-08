package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class AttendanceController {
	private AttendanceRepository attRepo;


	public AttendanceController(AttendanceRepository attRepo) {
		super();
		this.attRepo = attRepo;
	}

	 @GetMapping("/attendance")
	    public List<com.example.demo.attendance> getAll(){
	    	
			List<com.example.demo.attendance> att =  this.attRepo.findAll();

	        return att;
	    }
	    
	  
	   @GetMapping("/{dateFrom}")
	   public List<com.example.demo.attendance> getRange(@PathVariable("dateFrom") Date dateFrom){ 
		   List<com.example.demo.attendance> att =  this.attRepo.findDateBetween(dateFrom);
		   
		   return att;
	    }
	 
	 
}