package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Courier;

@Repository
public interface CourrierRepository extends JpaRepository<Courier, Long>  {
	// Courier findById(String id);
	 //List<Courier> findAll(); 
	 //void deleteById(int id); 
    //@Query("SELECT TOP 1 * FROM courier c WHERE c.id = ?1")
	//Courier findCourierCountById(Long id);
}
