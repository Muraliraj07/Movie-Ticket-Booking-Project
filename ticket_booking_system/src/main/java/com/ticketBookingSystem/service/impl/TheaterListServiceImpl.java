package com.ticketBookingSystem.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ticketBookingSystem.entity.TheaterListEntity;
import com.ticketBookingSystem.repository.TheaterListRepository;
import com.ticketBookingSystem.service.TheaterListService;

@Service
public class TheaterListServiceImpl implements TheaterListService{
	
	private TheaterListRepository theaterListRepository;
	
	public TheaterListServiceImpl(TheaterListRepository theaterListRepository) {
		super();
		this.theaterListRepository = theaterListRepository;
	}
// List
	@Override
	public List<TheaterListEntity> getAllTheaterList() {
		return theaterListRepository.findAll();
	}
// Save to database
	@Override
	public void saveTheater(MultipartFile file, String theaterName, String theaterType, String city,
			String address) {
		TheaterListEntity theater = new TheaterListEntity();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			theater.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		theater.setTheaterName(theaterName);
		theater.setTheaterType(theaterType);
		theater.setCity(city);
		theater.setAddress(address);
        
		theaterListRepository.save(theater);
		}

// delete	
		@Override
		public void deleteTheater(int id) {
			theaterListRepository.deleteById(id);
		}

// get to update		
		@Override
		public TheaterListEntity getTheater(int id) {
			return theaterListRepository.findById(id).get();
		}

// update		
		@Override
		public void updateTheater(int id, MultipartFile file, String theaterName, String theaterType, String city, String address) {
		    TheaterListEntity theater = theaterListRepository.findById(id).orElseThrow(() -> new RuntimeException("Theater not found with id " + id));
		    theater.setTheaterName(theaterName);
		    theater.setTheaterType(theaterType);
		    theater.setCity(city);
		    theater.setAddress(address);
		    
		    if (file != null && !file.isEmpty()) {
		        try {
		            byte[] imageBytes = file.getBytes();
		            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		            theater.setImage(base64Image);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    
		    theaterListRepository.save(theater);
		}

}

