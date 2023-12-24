package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Courier;
import com.example.demo.service.Interface.ICourrierService;



@RestController
@RequestMapping("/api/courrier")
public class CourrierController {
	
	@Autowired
	private ICourrierService courrierService;
	
	@GetMapping("/totalDistance")
	public Double getTotalTravelDistance() {
		//call service
		double response = 1.00;
		return response;
		
	}
	/*
	@GetMapping("/info/{courrierId}")
	public Courier getCourrier(@PathVariable Long courrierId) {
		//call service
		
		return courrierService.getCourrier(courrierId);
		
	}*/
	@PostMapping("/log")
	public void logCourrier(@RequestBody com.example.demo.dto.request.Courier courrier) {
		//call service
		courrierService.logCourrier(courrier);		
	}
	@GetMapping("/list")
	public List<Courier> getAllCourriers() {
		List<Courier> couriers = courrierService.getAllCouriers();
		return couriers;
	}
	

	
}
