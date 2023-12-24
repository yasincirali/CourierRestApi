package com.example.demo.service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.Interface.StoreService;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreRepository storeRepository;
	@Override
	public void uploadStores() {
		JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/store.json"));
            JSONArray storeList = (JSONArray) obj;

            Iterator<JSONObject> iterator = storeList.iterator();
            while (iterator.hasNext()) {

            	Gson gson = new Gson();
            	Store address=gson.fromJson(iterator.next().toJSONString(), Store.class);
            	com.example.demo.entity.Store store = new com.example.demo.entity.Store (java.time.LocalDateTime.now(),address.getName(), address.getLat(),address.getLng());
            	
            	if(storeRepository.findByName(store.getName())==null)
            		storeRepository.save(store)	;
            	//save(store);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	@Override
    @Cacheable(value = "store")
	public List<com.example.demo.entity.Store> fetchStores() {
		List<com.example.demo.entity.Store> stores = storeRepository.findAll();
		return stores;
	}

}
