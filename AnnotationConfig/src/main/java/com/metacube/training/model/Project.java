package com.metacube.training.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Project {

	private Long id;
	private String name;
	private String description;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date endDate;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
