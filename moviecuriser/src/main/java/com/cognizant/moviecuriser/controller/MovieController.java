package com.cognizant.moviecuriser.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.moviecuriser.MoviecuriserApplication;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.service.MovieService;
import com.cognizant.moviecuriser.service.exception.MovieNotFoundException;

/**
 * 
 * @author Danish
 *
 */
@Controller
public class MovieController {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecuriserApplication.class);

	/**
	 * movie service interacts with repositories
	 */
	@Autowired
	MovieService movieService;

	/**
	 * Gets movie list for admin
	 * 
	 * @param map
	 * @return movie list for admin and add it to model map
	 */
	@GetMapping("/movie-list-admin")
	public String showAdminPage(ModelMap map) {

		LOGGER.info("Start");
		map.addAttribute("movieslist", movieService.getMoviesListAdmin());
		LOGGER.info("End");
		return "movie-list-admin";
	}

	/**
	 * Displays edit page for admin
	 * 
	 * @param id
	 * @param movie
	 * @param map
	 * @return edit movie for admin and add the current movie to model map
	 */
	@GetMapping("/movieDetails")
	public String showEditMovie(@RequestParam("id") Integer id, @ModelAttribute("movie") Movie movie, ModelMap map) {
		LOGGER.info("Start");
		map.addAttribute("movie", movieService.getByMovieId(id));
		LOGGER.info("End");
		return "edit-movie";
	}

	/**
	 * Updates movie
	 * 
	 * @param movie
	 * @return success status if movie is updated else display save page
	 */
	@PostMapping("/update")
	public String editMovie(@ModelAttribute("movie") Movie movie) {
		LOGGER.info("Start");
		if (movieService.save(movie)) {
			LOGGER.info("End");
			return "edit-movie-status";
		} else {
			LOGGER.info("End");
			return "edit-movie";
		}
	}

	/**
	 * Gets movie list for customers
	 * 
	 * @param map
	 * @return movie list for customers
	 */
	@GetMapping("/movie-list-customer")
	public String showCustomerPage(ModelMap map) {
		LOGGER.info("Start");
		map.addAttribute("movieslist", movieService.getMoviesListCustomer());
		LOGGER.info("End");
		return "movie-list-customer";
	}

	/**
	 * Gets faviorate movie list for customer
	 * 
	 * @param userId
	 * @param map
	 * @return faviorate movie list for customer
	 * @throws MovieNotFoundException if no movie is in list
	 */
	@GetMapping("/favoritiesMovies")
	public String showFav(@RequestParam("id") Integer userId, ModelMap map) throws MovieNotFoundException {

		LOGGER.info("Start");
		try {
			map.addAttribute("movieslist", movieService.getFaviorateMovies(1));

			LOGGER.info("End");
			return "favorites";

		} catch (MovieNotFoundException movieNotFoundException) {
			// TODO: handle exception
			LOGGER.info("End");
			return "favorites-empty";

		}
	}

	/**
	 * Adds the movie to list
	 * 
	 * @param movie_id
	 * @param modelMap
	 * @return success status if movie does not exist else display movie already
	 *         exist
	 */
	@GetMapping("/addToFavorities")
	public String addFaviorateMovie(@RequestParam("id") Integer movie_id, ModelMap modelMap) {
		LOGGER.info("Start");
		String url = "";
		modelMap.addAttribute("movieslist", movieService.getMoviesListCustomer());
		try {
			if (movieService.getFaviorateMovies(1).contains(movieService.getByMovieId(movie_id))) {

				url = "movie-list-customer-already-present";
			} else {
				movieService.saveToFaviorate(movieService.getByMovieId(movie_id));
				url = "movie-list-customer-notification";
			}

		} catch (MovieNotFoundException e) {
			// TODO: handle exception
			movieService.saveToFaviorate(movieService.getByMovieId(movie_id));
			url = "movie-list-customer-notification";

		}

		LOGGER.info("End");
		return url;
	}

	/**
	 * Deletes from faviorates
	 * 
	 * @param movie_id
	 * @param map
	 * @return success status if movie is deleted else empty page
	 */
	@GetMapping("/deleteFromFavorities")
	public String deleteFromFaviorates(@RequestParam("id") Integer movie_id, ModelMap map) {
		LOGGER.info("Start");
		movieService.deleteFaviorate(movie_id);
		try {
			map.addAttribute("movieslist", movieService.getFaviorateMovies(1));
			LOGGER.info("End");
			return "favorites-notification";

		} catch (MovieNotFoundException e) {
			// TODO: handle exception
			LOGGER.info("End");
			return "favorites-empty";

		}

	}

}
