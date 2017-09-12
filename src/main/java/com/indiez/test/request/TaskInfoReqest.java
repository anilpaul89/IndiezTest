package com.indiez.test.request;

import java.util.Date;

import javax.validation.constraints.NotNull;


public class TaskInfoReqest {

	@NotNull(message="Name is required")
	private String name;

	@NotNull(message="Description is required")
	private String description;

	@NotNull(message="createdby is required")
	private String createdby;

	@NotNull(message="End date(endson) is required)")
	private Date endson;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getEndson() {
		return endson;
	}

	public void setEndson(Date endson) {
		this.endson = endson;
	}

}
