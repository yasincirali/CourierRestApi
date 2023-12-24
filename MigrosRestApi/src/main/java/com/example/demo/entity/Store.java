package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="store")
public class Store {
	@Id
	@SequenceGenerator(name="store_seq", sequenceName="store_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="insertdate")
  	private LocalDateTime InsertDate;

	@Column(name="name")
	private String name;

	@Column(name="latitude")
    private double lat;

	public Store(LocalDateTime insertDate, String name, double lat, double lng) {
		super();
		InsertDate = insertDate;
		this.name = name;
		this.lat = lat;
		this.lng = lng;
	}

	@Column(name="longtitude")
    private double lng;
}
