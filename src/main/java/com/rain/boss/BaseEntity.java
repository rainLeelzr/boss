package com.rain.boss;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;

	public void setId() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}