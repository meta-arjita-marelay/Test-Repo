CREATE DATABASE employee;

USE employee;

CREATE TABLE employee(
emp_id INT PRIMARY KEY AUTO_INCREMENT ,
first_name VARCHAR(25) NOT NULL ,
last_name VARCHAR(25) ,
email_id VARCHAR(50) NOT NULL UNIQUE,
age int NOT NULL
);
select * from employee;

SELECT e.first_name , e.last_name , e.email_id , e.age FROM employee e;

SELECT * 
	from employee e 
    where concat(e.first_name ," " ,e.last_name) LIKE "%rj%" 
    OR concat(e.last_name ," " , e.first_name) LIKE "%rj%";

update employee as e set e.first_name = "richa" , e.last_name="jain" , e.email_id="richa@gmail.com" , e.age=22 where e.email_id="richa@gmail.com";
#DROP TABLE employee;