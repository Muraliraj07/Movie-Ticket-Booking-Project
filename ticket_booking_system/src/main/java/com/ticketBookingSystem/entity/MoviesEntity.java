package com.ticketBookingSystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="Movies_List")
public class MoviesEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	
	@Column(name="theater_name")
	private String theaterName;
	
	@Column(name="movie_name")
	private String movieName;
	
	
	@Column(name="movie_director")
	private String movieDirector;
	
	@Column(name="movie_hero")
	private String movieHero;
	
	@Column(name="movie_screen")
	private String movieScreen;
	
	@Column(name="movie_language")
	private String movieLanguage;
	
	@Column(name="ticket_price")
	private String ticket_Price;
	
	@Lob
	@Column(name="movie_image", columnDefinition = "MEDIUMBLOB")
	private String movieImage;
	
	public MoviesEntity() {
		
	}
	
	public MoviesEntity(String theaterName, String movieName, String movieDirector, String movieHero,
			String movieScreen, String movieLanguage, String ticket_Price, String movieImage) {
		super();
		this.theaterName = theaterName;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieHero = movieHero;
		this.movieScreen = movieScreen;
		this.movieLanguage = movieLanguage;
		this.ticket_Price = ticket_Price;
		this.movieImage=movieImage;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieHero() {
		return movieHero;
	}

	public void setMovieHero(String movieHero) {
		this.movieHero = movieHero;
	}
	
	
	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getMovieScreen() {
		return movieScreen;
	}

	public void setMovieScreen(String movieScreen) {
		this.movieScreen = movieScreen;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getTicket_Price() {
		return ticket_Price;
	}

	public void setTicket_Price(String ticket_Price) {
		this.ticket_Price = ticket_Price;
	}

	public String getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

	public String getmovieImage() {
		return movieImage;
	}

	public void setmovieImage(String movieImage) {
		this.movieImage = movieImage;
	}

}
