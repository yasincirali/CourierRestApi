package com.example.demo.service.ServiceImpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.LogCourierRequest;
import com.example.demo.dto.response.BaseResponse;
import com.example.demo.entity.AttendanceLog;
import com.example.demo.entity.Courier;
import com.example.demo.model.ClosestStore;
import com.example.demo.repository.AttendanceLogRepository;
import com.example.demo.repository.CourrierRepository;
import com.example.demo.service.Interface.CourierService;
import com.example.demo.util.Util.LogUtil;

import jakarta.persistence.Column;


@Service
public class CourierServiceImpl implements CourierService{

	@Autowired
	private CourrierRepository courrierRepository;
	@Autowired 
	private  AttendanceLogRepository attendanceLogRepository;
	@Autowired
	private LogUtil logUtil;
	
	@Column(name="insertdate")
	private LocalDateTime InsertDate;
	
	@Column(name="courierid")
	private Long CourierId;
	
	@Column(name="storeid")
	private Long StoreId;
	
	@Column(name="latitude")
	private float Latitude;
	
	@Column(name="longtitude")
	private float Longtitude;
	@Override
	public BaseResponse<String> logCourrier(LogCourierRequest request) {	
		Courier courier= courrierRepository.findByNameAndSurname(request.getName(),request.getSurname());
		//check user is already saved
    	if(courier==null) {
    		Courier courierToSave = new Courier(java.time.LocalDateTime.now(),request.getName(), request.getSurname());
    		courrierRepository.save(courierToSave);
        	return new BaseResponse<String> (true,"Success","Successfully saved");
    	}
    	else {    		
    		ClosestStore closestStore = logUtil.getClosestStoreId(request.getLat(), request.getLng());
    		AttendanceLog log = attendanceLogRepository.getRecordByCourierIdAndStoreId(courier.getId(),closestStore.getId());
    		if(log!=null) {
        		long minutes = ChronoUnit.MINUTES.between(log.getInsertDate(),java.time.LocalDateTime.now() );
        		if(minutes>=1 && closestStore.getDistance()<100) {
        			attendanceLogRepository.save(new AttendanceLog(
        	    			java.time.LocalDateTime.now(),
        	    			courier.getId(),
        	    			closestStore.getId(),
        	    			request.getLat(),
        	    			request.getLng()
        	    			));
                	return new BaseResponse<String> (true,"Success","Successfully saved");
        		}
        		else 
        			return new BaseResponse<String> (false,"Error","Enterance could not be saved because the closest store is not in 100m or already saved in 1 minute!");
    		}
    		else if(closestStore.getDistance()<100) {
    	    	attendanceLogRepository.save(new AttendanceLog(
    	    			java.time.LocalDateTime.now(),
    	    			courier.getId(),
    	    			closestStore.getId(),
    	    			request.getLat(),
    	    			request.getLng()
    	    			));
            	return new BaseResponse<String> (true,"Success","Successfully saved");
    	    }
    		else 
    			return new BaseResponse<String> (false,"Error","Enterance could not be saved because the closest store is not in 100m!");
    	
    	}
	}
	@Override
	public BaseResponse<List<Courier>> getAllCouriers() {
		// TODO Auto-generated method stub
		List<Courier> couriers = courrierRepository.findAll();
		return  new BaseResponse<>(true,"Success",couriers);
	}

	public void saveCourrier(com.example.demo.dto.request.Courier courier) {
		//if courier has same name and surname is there in database we do not save itto keep uniqueness
		Courier courierToSave = new Courier(java.time.LocalDateTime.now(),courier.getName(), courier.getSurname());
    	if(courrierRepository.findByNameAndSurname(courier.getName(),courier.getSurname())==null)
			courrierRepository.save(courierToSave);			
	}
	@Override
	public BaseResponse<Double> getTotalDisatance(long courierId) {
		// TODO Auto-generated method stub
		List<AttendanceLog> logs = attendanceLogRepository.getLogsByCourierId(courierId);		
		double totalDistance = logUtil.getTotalDistanceOfCourier(logs);
		return new BaseResponse<Double>(true,"Success",totalDistance);
	}


}


