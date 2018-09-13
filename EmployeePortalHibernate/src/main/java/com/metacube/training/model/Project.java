package com.metacube.training.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "project_master")
public class Project {

	@Override
	public String toString() {
		return "Project [id=" + id + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "start_date")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Column(name = "end_date")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Column(name = "project_logo")
	private String project_logo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getProject_logo() {
		return project_logo;
	}

	public void setProject_logo(String project_logo) {
		this.project_logo = project_logo;
	}


}
