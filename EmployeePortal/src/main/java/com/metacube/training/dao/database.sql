CREATE DATABASE employee_portal;

#ON UPDATE CASCADE ON DELETE CASCADE
#DROP DATABASE employee_portal;

USE employee_portal;

CREATE TABLE Employee (
    emp_code VARCHAR(50) NOT NULL,
    first_name VARCHAR(25) NOT NULL,
    middle_name  VARCHAR(25),
    last_name VARCHAR(25),#not mentioned
    dob DATE NOT NULL,
    gender CHAR(1) NOT NULL,
    primary_contact_no CHAR(10) NOT NULL,
    secondary_contact_no CHAR(10),
    email_id VARCHAR(50) NOT NULL,
    skype_id VARCHAR(50),
    profile_picture VARCHAR(250),
    password VARCHAR(20) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    CONSTRAINT PK_Employee PRIMARY KEY (emp_code)
);

CREATE TABLE JobTitleMaster(
    job_code INTEGER NOT NULL,
    job_title VARCHAR(50) NOT NULL,
    CONSTRAINT PK_JobTitleMaster PRIMARY KEY(job_code)
);

CREATE TABLE UserRoles(
    user_role_id INTEGER AUTO_INCREMENT NOT NULL,
    username VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT PK_UserRoles PRIMARY KEY(user_role_id)
);

CREATE TABLE SkillsMaster(
    skill_id INTEGER AUTO_INCREMENT NOT NULL,
    skill_name VARCHAR(50) NOT NULL,
    CONSTRAINT PK_SkillsMaster PRIMARY KEY (skill_id)
);

CREATE TABLE EmployeeSkills(
    emp_skill_id INTEGER AUTO_INCREMENT NOT NULL,
    emp_code VARCHAR(50) NOT NULL, 
    skill_code INTEGER NOT NULL,
    CONSTRAINT PK_EmployeeSkills PRIMARY KEY (emp_skill_id),
    CONSTRAINT FK_EmployeeSkillsEmployee_emp_code FOREIGN KEY (emp_code) REFERENCES Employee (emp_code) ON DELETE CASCADE,
    CONSTRAINT FK_EmployeeSkillsUserRoles_skill_code FOREIGN KEY (skill_code) REFERENCES SkillsMaster (skill_id) ON DELETE CASCADE
);

CREATE TABLE ProjectMaster(
    project_id INTEGER NOT NULL,
    description VARCHAR(250) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE,
    project_logo VARCHAR(250),
    CONSTRAINT PK_ProjectMaster PRIMARY KEY (project_id)
);

CREATE TABLE Address(
    address_id INTEGER AUTO_INCREMENT NOT NULL,
    emp_code VARCHAR(50) NOT NULL,#was int in assignment
    add_line_1 VARCHAR(50) NOT NULL,
    add_line_2 VARCHAR(50),
    city VARCHAR(25) NOT NULL,
    state VARCHAR(25) NOT NULL,
    pincode CHAR(6) NOT NULL,#6 digit pincodes
    CONSTRAINT PK_Address PRIMARY KEY (address_id),
    CONSTRAINT FK_AddressEmployee_emp_code FOREIGN KEY (emp_code) REFERENCES Employee(emp_code) ON DELETE CASCADE
);

CREATE TABLE JobDetails(    
    job_detail_id INTEGER AUTO_INCREMENT NOT NULL,
    emp_code VARCHAR(50) NOT NULL,#was int in assignment
    date_of_joining DATE NOT NULL,
    total_exp INTEGER NOT NULL,
    job_code INTEGER NOT NULL,#was string in assignment
    reproting_mgr VARCHAR(50),#was int in assignment
    team_lead VARCHAR(50),#was int in assignment
    curr_proj_id INTEGER,
    CONSTRAINT PK_JobDetails PRIMARY KEY (job_detail_id),
    CONSTRAINT FK_JobDetailsEmployee_emp_code 
    FOREIGN KEY (emp_code) REFERENCES Employee (emp_code),    
    CONSTRAINT FK_JobDetailsEmployee_reproting_mgr FOREIGN KEY (reproting_mgr) REFERENCES Employee(emp_code) ON DELETE CASCADE,
    CONSTRAINT FK_JobDetailsEmployee_team_lead FOREIGN KEY (team_lead) REFERENCES Employee(emp_code) ON DELETE CASCADE,
    CONSTRAINT FK_JobDetailsJobTitleMaster_job_code FOREIGN KEY (job_code) REFERENCES JobTitleMaster(job_code) ON DELETE CASCADE,
    CONSTRAINT FK_JobDetailsProjectMaster_project_id FOREIGN KEY (curr_proj_id) REFERENCES ProjectMaster(project_id) ON DELETE CASCADE
);