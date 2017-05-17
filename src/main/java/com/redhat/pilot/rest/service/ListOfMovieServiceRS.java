package com.redhat.pilot.rest.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redhat.pilot.enumeration.MovieServiceOptionEnum;
import com.redhat.pilot.model.Movie;
import com.redhat.pilot.model.vo.MovieVO;
import com.redhat.pilot.service.ListOfMovieService;

@Service
public class ListOfMovieServiceRS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5026598859456319598L;

	@Autowired
	private ListOfMovieService listOfMovieService;

	public MovieVO getMoviesByName(String name) {
		return listOfMovieService.getService(MovieServiceOptionEnum.FIND_BY_NAME.getOp(), new Movie(name), "");
	}

	public MovieVO getMoviesByRewritten(String rewritten) {
		return listOfMovieService.getService(MovieServiceOptionEnum.FIND_BY_REWRINTTEN.getOp(),
				new Movie(Boolean.parseBoolean(rewritten)), "");
	}

	public MovieVO getMoviesByYear(String year) {
		return listOfMovieService.getService(MovieServiceOptionEnum.FIND_BY_YEAR.getOp(),
				new Movie(Long.parseLong(year)), "");
	}

	public boolean getSendMessageToBroker(String message) {
		listOfMovieService.getService(MovieServiceOptionEnum.SEND_MESSAGE_BROKER.getOp(),
				null, message);

		return true;
	}

}
