CREATE DATABASE users;

USE users;

CREATE TABLE userDetails(
user_id INT PRIMARY KEY AUTO_INCREMENT ,
first_name VARCHAR(25) NOT NULL ,
last_name VARCHAR(25) ,
email_id VARCHAR(50) NOT NULL UNIQUE,
dob DATE NOT NULL,
user_password VARCHAR(25),
contact_number VARCHAR(12),
org_name VARCHAR(10)
);

CREATE TABLE friendList(
user_id int,
friend_id int,
PRIMARY KEY (user_id, friend_id)
);