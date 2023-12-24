package com.example.demo.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Courier;
import com.example.demo.repository.CourrierRepository;
import com.example.demo.service.Interface.ICourrierService;


@Service
public class CourrierService implements ICourrierService{

	@Autowired
	private CourrierRepository courrierRepository;
	
	@Override
	public void logCourrier(com.example.demo.dto.request.Courier courier) {	
		Courier courierToSave = new Courier(java.time.LocalDateTime.now(),courier.getName(), courier.getSurname());
		courrierRepository.save(courierToSave);		
	}
	
	@Override
	public Double getTotalDistance() {
		return 1.00;
	}
	/*@Override
	public Courier getCourrier(Long id) {
		
		  
		Courier courier =  courrierRepository.findCourierCountById(id);
		if(courier==null)
			return null;
		return courier;
	}*/
	@Override
	public List<Courier> getAllCouriers() {
		// TODO Auto-generated method stub
		List<Courier> couriers = courrierRepository.findAll();
		return couriers;
	}

}


