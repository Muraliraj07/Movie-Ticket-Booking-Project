package com.ticketBookingSystem.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ticketBookingSystem.entity.MoviesEntity;

public interface MoviesEntityService {
	
	List<MoviesEntity> getAllMoviesList();

	
	public void saveMovie(MultipartFile file, String theaterName,  String movieName, String movieDirector,
			String movieHero, String movieScreen,String movieLanguage, String ticket_Price);

}
