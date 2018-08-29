CREATE DATABASE employee;

USE employee;

CREATE TABLE employee(
emp_id INT PRIMARY KEY AUTO_INCREMENT ,
first_name VARCHAR(25) NOT NULL ,
last_name VARCHAR(25) ,
email_id VARCHAR(50) NOT NULL,
age VARCHAR(10) NOT NULL
);
select * from employee;

SELECT e.first_name , e.last_name , e.email_id , e.age FROM employee e;