package com.ticketBookingSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ticketBookingSystem.entity.MoviesEntity;

import com.ticketBookingSystem.service.MoviesEntityService;

@Controller
public class MoviesEntityContoller {
	private MoviesEntityService moviesEntityService;

	public MoviesEntityContoller(MoviesEntityService moviesEntityService) {
		super();
		this.moviesEntityService = moviesEntityService;
	}
	
	@GetMapping("/movies1")
	public String listMovies(Model model) {
		model.addAttribute("movie", moviesEntityService.getAllMoviesList());
		return "Movies";
	}
	
	@GetMapping("/movies/addmovies")
	public String addMovies(Model model) {
		MoviesEntity moviesEntity= new MoviesEntity();  //object to hold the form data
		
		model.addAttribute("movie", moviesEntity);
		return "AddMovie";
	}
	
	@PostMapping("/movies")
	public String saveProduct(@RequestParam("file") MultipartFile file,
	        @RequestParam("theaterName") String theaterName, @RequestParam("movieName") String movieName,
	        @RequestParam("movieDirector") String movieDirector, @RequestParam("movieHero") String movieHero,
	        @RequestParam("movieScreen") String movieScreen, @RequestParam("movieLanguage") String movieLanguage,
	        @RequestParam("ticket_Price") String ticket_Price) {
	    moviesEntityService.saveMovie(file, theaterName, movieName, movieDirector, movieHero, movieScreen, movieLanguage, ticket_Price);
	    return "redirect:/movies1";
	}

    
    
}
