package com.ticketBookingSystem.service.impl;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ticketBookingSystem.entity.MoviesEntity;
import com.ticketBookingSystem.repository.MoviesEntityRepository;
import com.ticketBookingSystem.service.MoviesEntityService;

@Service
public class MoviesEntityServiceImpl implements MoviesEntityService {
	
	private MoviesEntityRepository moviesEntityRepository;
	
	
	
	public MoviesEntityServiceImpl(MoviesEntityRepository moviesEntityRepository) {
		super();
		this.moviesEntityRepository = moviesEntityRepository;
	}

	
// To get all movies list 	
	@Override
	public List<MoviesEntity> getAllMoviesList() {
		return moviesEntityRepository.findAll();
	}

	
// To save created movie to database	
	@Override
	public void saveMovie(MultipartFile file, String theaterName,  String movieName, String movieDirector,
		String movieHero, String movieScreen,String movieLanguage, String ticket_Price) {
		
		MoviesEntity movie = new MoviesEntity();
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			movie.setmovieImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		movie.setTheaterName(theaterName);
		movie.setMovieName(movieName);
		
		movie.setMovieDirector(movieDirector);
		movie.setMovieHero(movieHero);
		movie.setMovieScreen(movieScreen);
		movie.setMovieLanguage(movieLanguage);
		movie.setTicket_Price(ticket_Price);
		
		moviesEntityRepository.save(movie);
		
	}
	

}
