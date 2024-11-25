CREATE DATABASE test_db;
USE test_db;
CREATE TABLE User(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    surname VARCHAR(100),
    email VARCHAR(100),
    phone VARCHAR(100),
    password VARCHAR(100)
);
