package com.redhat.pilot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.redhat.pilot.jms.producer.JMSProducer;
import com.redhat.pilot.model.Api;
import com.redhat.pilot.model.Movie;
import com.redhat.pilot.model.vo.MovieVO;

@Service
public class ListOfMovieService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3338648800806929993L;

	private static final String API_VERSION_SERVICE = System.getenv("API_VERSION_SERVICE") == null ? "1"
			: System.getenv("API_VERSION_SERVICE");
	private static final String API_ENVIRONMENT = System.getenv("API_ENVIRONMENT") == null ? "DEV"
			: System.getenv("API_ENVIRONMENT");

	@SuppressWarnings({ "serial" })
	public List<Movie> getMovies() throws IOException {

		InputStream in = ListOfMovieService.class.getClassLoader().getResourceAsStream("movies.json");

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuffer result = new StringBuffer();
		String line;

		while ((line = reader.readLine()) != null) {
			result.append(line);
		}

		Type listType = new TypeToken<List<Movie>>() {
		}.getType();
		List<Movie> movies = new ArrayList<>();

		movies = new Gson().fromJson(result.toString(), listType);

		return movies;
	}

	private List<Movie> getMoviesByRewritten(Movie movie) {
		List<Movie> movies;
		try {
			movies = getMovies();
			return movies.stream().filter(m -> m.getRewritten().equals(movie.getRewritten()))
					.collect(Collectors.toList());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;

		}

	}

	private List<Movie> getMoviesByName(Movie movie) {
		List<Movie> movies;
		try {

			movies = getMovies();
			return movies.stream().filter(m -> m.getName().contains(movie.getName())).collect(Collectors.toList());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}

	}

	private List<Movie> getMoviesByYear(Movie movie) {
		List<Movie> movies;
		try {
			movies = getMovies();
			return movies.stream().filter(m -> m.getYear().equals(movie.getYear())).collect(Collectors.toList());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}

	}

	public void getSendMessageToBroker(String message) {
		new JMSProducer().run(message);
	}

	public MovieVO getService(Integer op, Movie movie, String message) {

		// Create this array for get a List
		List<Movie> movies = new ArrayList<>();

		// Switch the option of service
		switch (op) {

		case 1:

			movies = getMoviesByRewritten(movie);

			break;
		case 2:

			movies = getMoviesByName(movie);

			break;
		case 3:

			movies = getMoviesByYear(movie);

			break;
		case 4:

			getSendMessageToBroker(message);
			movies = new ArrayList<>();

			break;
		default:
			break;
		}

		Api api = new Api();
		api.setEnvironment(API_ENVIRONMENT);
		api.setVersion(Long.parseLong(API_VERSION_SERVICE));

		MovieVO vo = new MovieVO();
		vo.setApi(api);
		vo.setMovie(movies);

		return vo;

	}

}
