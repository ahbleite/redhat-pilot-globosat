package com.redhat.pilot.model.vo;

import java.io.Serializable;
import java.util.List;

import com.redhat.pilot.model.Api;
import com.redhat.pilot.model.Movie;

public class MovieVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6663436206817467095L;

	private Api api;
	private List<Movie> movie;

	public Api getApi() {
		return api;
	}

	public void setApi(Api api) {
		this.api = api;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

}
