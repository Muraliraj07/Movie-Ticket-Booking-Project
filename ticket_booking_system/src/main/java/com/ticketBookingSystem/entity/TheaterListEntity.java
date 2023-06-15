package com.ticketBookingSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="Theater_List")
public class TheaterListEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="theater_name")
	private String theaterName;
	
	@Column(name="theater_type")
	private String theaterType;
	
	@Column(name="city")
	private String city;
	
	@Column(name="address")
	private String address;
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	
	
	
	public TheaterListEntity() {
		
	}
	
	public TheaterListEntity(String theaterName, String theaterType, String city, String address, String image) {
		super();
		this.theaterName = theaterName;
		this.theaterType = theaterType;
		this.city = city;
		this.address = address;
		
		
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterType() {
		return theaterType;
	}

	public void setTheaterType(String theaterType) {
		this.theaterType = theaterType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}	
