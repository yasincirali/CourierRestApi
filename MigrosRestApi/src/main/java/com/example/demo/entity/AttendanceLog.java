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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="attendance_log")
public class AttendanceLog {

	public AttendanceLog(LocalDateTime date, Long id2, long id3, float lat, float lng) {
		this.InsertDate = date;
	    this.CourierId = id2;
	    this.StoreId = id3;
	    this.Latitude = lat;
	    this.Longtitude = lng;
	}

	@Id
	@SequenceGenerator(name="attendance_log_seq", sequenceName="attendance_log_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	
}
