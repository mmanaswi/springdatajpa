package com.cognizant.moviecuriser.service;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.moviecuriser.MoviecuriserApplication;
import com.cognizant.moviecuriser.model.Favorities;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.repository.FaviorateRepository;
import com.cognizant.moviecuriser.repository.MovieRepository;
import com.cognizant.moviecuriser.repository.UserRepository;
import com.cognizant.moviecuriser.service.exception.MovieNotFoundException;

/**
 * 
 * @author Danish
 *
 */
@Service
public class MovieService {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecuriserApplication.class);
	
	
	/**
	 * All repositories autowired
	 */
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FaviorateRepository faviorateRepository;
	
	
	/**
	 * Gets the list of movies for admin
	 * @return
	 */
	public List<Movie> getMoviesListAdmin(){
		LOGGER.info("Start");
		return movieRepository.findAll();
	}
	
	public Movie getByMovieId(int id) {
		LOGGER.info("Start");
		return movieRepository.getOne(id);
	}
	
	@Transactional
	public boolean save(Movie movie) {
		LOGGER.info("Start");
		if(movieRepository.save(movie)==null) {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean saveToFaviorate(Movie movie)
	{
		
		LOGGER.info("Start");
		Favorities favorities = new Favorities();
		favorities.setMovie(movie);
		favorities.setUser(userRepository.getOne(1));
		LOGGER.info("End");
		if(faviorateRepository.save(favorities)==null)
			return false;
		return true;
	}
	public List<Movie> getMoviesListCustomer() {
		
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		return movieRepository.findCustomerMovies();
	}
	
	public List<Movie> getFaviorateMovies(int userId) throws MovieNotFoundException {
		LOGGER.info("Start");
		List<Movie> movies = new ArrayList<>();
		faviorateRepository.getFaviorateMovies(userId).stream().forEach(id -> movies.add(movieRepository.getOne(id)));
		LOGGER.info("End");
		if(movies.isEmpty())
			throw new MovieNotFoundException();
		return movies;
	}
	
	@Transactional
	public void deleteFaviorate(Integer movie_id)
	{
		
		faviorateRepository.deleteFromFaviorate(1, movie_id);
		
	}
	
}
