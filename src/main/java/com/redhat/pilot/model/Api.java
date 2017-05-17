package com.redhat.pilot.model;

import java.io.Serializable;

public class Api implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 926877026551600862L;

	private Long version;
	private String environment;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
