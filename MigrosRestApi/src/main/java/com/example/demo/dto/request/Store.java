package com.example.demo.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Store {

	@Column(name="name")
	private String name;

	@Column(name="latitude")
    private double lat;

	@Column(name="longtitude")
    private double lng;
}
