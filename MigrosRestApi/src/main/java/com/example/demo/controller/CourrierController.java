package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.LogCourierRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.entity.Courier;
import com.example.demo.service.Interface.CourierService;



@RestController
@RequestMapping("/api/courier")
public class CourrierController {
	
	@Autowired
	private CourierService courierService;
	
	@PostMapping("/log")
	public BaseResponse<String> logCourrier(@RequestBody LogCourierRequest requestMessage) {
		//call service
		return courierService.logCourrier(requestMessage);		
	}
	@PostMapping("/save")
	public void saveCourrier(@RequestBody com.example.demo.dto.request.Courier courrier) {
		//call service
		courierService.saveCourrier(courrier);		
	}
	@GetMapping("/list")
	public BaseResponse<List<Courier>> getAllCourriers() {
		BaseResponse<List<Courier>> couriers = courierService.getAllCouriers();
		return couriers;
	}
	@GetMapping("/totalDistance/{courierId}")
	public BaseResponse<Double> getTotalDisatance(@PathVariable long courierId) {
		BaseResponse<Double> totalDistance = courierService.getTotalDisatance(courierId);
		return totalDistance;
	}

	
}
