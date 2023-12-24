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
@Table(name="courier")
public class Courier {
	  


		public Courier(LocalDateTime now, String name2, String surname2) {
		// TODO Auto-generated constructor stub
			this.InsertDate=now;
			this.Name=name2;
			this.Surname=surname2;
	}

		@Id
		@SequenceGenerator(name="courier_seq", sequenceName="courier_seq", allocationSize=1)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id; 
	    
		@Column(name="insertdate")
	  	private LocalDateTime InsertDate;
	    
		@Column(name="name")
	    private String Name;
	    
	    @Column(name="surname")
	    private String Surname;


}
