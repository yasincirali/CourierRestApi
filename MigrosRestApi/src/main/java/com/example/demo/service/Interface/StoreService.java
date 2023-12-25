package com.example.demo.service.Interface;

import java.util.List;

import com.example.demo.dto.response.BaseResponse;
import com.example.demo.entity.Store;

public interface StoreService {
	void uploadStores();
	BaseResponse<List<Store>> fetchStores();
}
