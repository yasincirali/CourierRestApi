package com.example.demo.util.UtilImpl;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AttendanceLog;
import com.example.demo.entity.Store;
import com.example.demo.model.ClosestStore;
import com.example.demo.model.Location;
import com.example.demo.service.Interface.StoreService;
import com.example.demo.util.Util.LogUtil;
import com.google.common.util.concurrent.AtomicDouble;

@Service
public class LogUtilImpl implements LogUtil{

	@Autowired
	private StoreService storeService;
	@Override
	public ClosestStore getClosestStoreId(float lat, float lng) {
		
		List<Store> stores= storeService.fetchStores().getData();
		Store nearestStore = stores.stream()
    .min(Comparator.comparingDouble(store ->
        calculateDistance(lat, lng, store.getLat(), store.getLng())))
    .orElse(null);
		
		return new ClosestStore(nearestStore.getId(),calculateDistance(lat,lng,nearestStore.getLat(),nearestStore.getLng()));
	}

	//Method to calculate distance using Haversine formula
	private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		 double R = 6371; // Earth radius in kilometers
	
		 double latDistance = Math.toRadians(lat2 - lat1);
		 double lonDistance = Math.toRadians(lon2 - lon1);
	
		 double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
		         + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
		         * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	
		 double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	
		 return R * c * 1000; // Distance in meters
	}

	@Override
	public double getTotalDistanceOfCourier(List<AttendanceLog> logs) {
        AtomicDouble totalDistance = new AtomicDouble(0.0);
        Location prevLocation= new Location(0.0f,0.0f);

        logs.forEach(log -> {
            totalDistance.addAndGet( calculateDistance(
                    prevLocation.getLat(), prevLocation.getLng(),
                    log.getLatitude(), log.getLongtitude()));
            
            prevLocation.setLat(log.getLatitude());
            prevLocation.setLng(log.getLongtitude());
        });

        return totalDistance.get();
	}
}

