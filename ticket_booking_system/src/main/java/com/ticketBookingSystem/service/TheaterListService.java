package com.ticketBookingSystem.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ticketBookingSystem.entity.TheaterListEntity;

public interface TheaterListService {
	List<TheaterListEntity> getAllTheaterList();
	
	public void saveTheater(MultipartFile file,String theaterName, String theaterType, String city, String address);
	
	void deleteTheater(int id);
	
	TheaterListEntity getTheater(int id);
	
	public void updateTheater(int id,MultipartFile file,String theaterName, String theaterType, String city, String address);
	
}
