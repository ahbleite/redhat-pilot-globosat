package com.redhat.pilot.model;

import java.io.Serializable;

public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1921097099187847168L;

	private Long id;
	private String name;
	private Long year;
	private Boolean rewritten;

	public Movie() {}

	public Movie(String name) {
		this.name = name;
	}

	public Movie(Long year) {
		this.year = year;
	}

	public Movie(Boolean rewritten) {
		this.rewritten = rewritten;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Boolean getRewritten() {
		return rewritten;
	}

	public void setRewritten(Boolean rewritten) {
		this.rewritten = rewritten;
	}

}
