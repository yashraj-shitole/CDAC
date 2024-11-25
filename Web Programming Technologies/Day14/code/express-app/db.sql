CREATE DATABASE test_db;
USE test_db;
CREATE TABLE User(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(100),
    lastName VARCHAR(100),
    address1 VARCHAR(100),
    address2 VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(100),
    gender VARCHAR(100),
    birthDate VARCHAR(100),
    password VARCHAR(100)
);
