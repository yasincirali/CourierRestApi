package com.example.demo.service.Interface;

import java.util.List;

import com.example.demo.dto.request.Courier;
import com.example.demo.dto.request.LogCourierRequest;


public interface CourierService {
	Double getTotalDistance();
	//Courier getCourrier(Long id);
	String logCourrier(LogCourierRequest courrier);
	List<com.example.demo.entity.Courier> getAllCouriers();
	void saveCourrier(Courier courrier);
	double getTotalDisatance(long courierId);
}
