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

SHOW tables;

ALTER TABLE userDetails ADD COLUMN image BLOB NOT NULL;

SELECT * FROM userDetails;

SELECT u.email_id FROM userDetails u;

INSERT INTO userDetails(first_name , last_name , email_id , dob , user_password , contact_number , org_name) 
VALUES("Richa" ,  "jain" , "richa@gmail.com" , "1996-06-22" , "Pika@1234" , "9907591320" , "Metacube");

ALTER TABLE userDetails DROP image;

SELECT u.email_id FROM userDetails u;