/*package com.redhat.pilot;

import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;

import com.redhat.pilot.model.Movie;
import com.redhat.pilot.model.vo.MovieVO;
import com.redhat.pilot.service.ListOfMovieService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestMovieService {
	
	@Test()
	@InSequence(1)
	public void getMoviesByRewritten(){
		
		
		ListOfMovieService list = new ListOfMovieService();
		MovieVO vo  = list.getService(1, new Movie(true));
		
		
		Assert.assertEquals(1, vo.getMovie().size());
	}
	
	@Test
	@InSequence(2)
	public void getMoviesByName(){
		
		
		ListOfMovieService list = new ListOfMovieService();
		MovieVO vo  = list.getService(2, new Movie("Chefão"));
		
		Assert.assertEquals(1, vo.getMovie().size());
		
	}
	
	@Test
	@InSequence(3)
	public void getMoviesByYear(){
		
		
		ListOfMovieService list = new ListOfMovieService();
		MovieVO vo  = list.getService(3, new Movie(1985L));
		
		
		Assert.assertEquals(1, vo.getMovie().size());
	}

}*/
