package com.example.demo.service.Interface;

import java.util.List;

import com.example.demo.dto.request.Courier;


public interface ICourrierService {
	Double getTotalDistance();
	//Courier getCourrier(Long id);
	void logCourrier(Courier courrier);
	List<com.example.demo.entity.Courier> getAllCouriers();
}
