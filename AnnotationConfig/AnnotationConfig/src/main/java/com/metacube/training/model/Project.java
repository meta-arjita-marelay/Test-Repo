package com.metacube.training.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

	public class Project {
	    private int projectId;
	    private String name;
		private String description;
	    private Date startDate;
	    private Date endDate;
	    private String projectLogo;
	    
	    /*Project(int projectId, String description, Date startDate, Date endDate, String projectLogo) {
	        this.projectId = projectId;
	        this.description = description;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.projectLogo = projectLogo;
	    }*/
	    public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setProjectId(int id) {
			this.projectId = id;
		}
	    public int getProjectId() {
	        return projectId;
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
	    public String getProjectLogo() {
	        return projectLogo;
	    }
	    public void setProjectLogo(String projectLogo) {
	        this.projectLogo = projectLogo;
	    }
	}

