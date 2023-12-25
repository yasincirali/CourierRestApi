package com.example.demo.service.Interface;

import java.util.List;

import com.example.demo.dto.request.Courier;
import com.example.demo.dto.request.LogCourierRequest;
import com.example.demo.dto.response.BaseResponse;


public interface CourierService {
	BaseResponse<String> logCourrier(LogCourierRequest courrier);
	BaseResponse<List<com.example.demo.entity.Courier>> getAllCouriers();
	void saveCourrier(Courier courrier);
	BaseResponse<Double> getTotalDisatance(long courierId);
}
