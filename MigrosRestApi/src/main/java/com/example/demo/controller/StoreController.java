package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Store;
import com.example.demo.service.Interface.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreController {


	@Autowired
	private StoreService storeService;
	
	
	@PostMapping("/upload")
	public void uploadStores() {
		//call service
		storeService.uploadStores();		
	}
	@GetMapping("/list")
	public List<Store> getStores() {
		//call service
		return storeService.fetchStores();		
	}
}
