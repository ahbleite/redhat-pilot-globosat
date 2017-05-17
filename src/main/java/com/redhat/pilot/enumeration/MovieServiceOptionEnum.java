package com.redhat.pilot.enumeration;

public enum MovieServiceOptionEnum {

	FIND_BY_REWRINTTEN(1), FIND_BY_NAME(2), FIND_BY_YEAR(3), SEND_MESSAGE_BROKER(4);

	private Integer op;

	MovieServiceOptionEnum(Integer op) {
		this.op = op;
	}

	public Integer getOp() {
		return op;
	}

}
