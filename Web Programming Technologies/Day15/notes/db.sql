CREATE DATABASE my_store_db;
USE my_store_db;

-- admin table

CREATE TABLE Admin(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    password VARCHAR(200),
    email VARCHAR(50),
    phone VARCHAR(50),
    isActive INT(1) DEFAULT 1,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- customer table

CREATE TABLE Customer(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    password VARCHAR(200),
    email VARCHAR(50),
    phone VARCHAR(50),
    isActive INT(1) DEFAULT 1,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- address table

CREATE TABLE CustomerAddress(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    address1 VARCHAR(100),
    address2 VARCHAR(100),
    city VARCHAR(50),
    state VARCHAR(50),
    zipCode VARCHAR(50),
    isActive INT(1) DEFAULT 1,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- category table

CREATE TABLE Category(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    details VARCHAR(50),
    isActive INT(1) DEFAULT 1,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- brand table

CREATE TABLE ProductBrand(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    details VARCHAR(50),
    isActive INT(1) DEFAULT 1,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- product table

CREATE TABLE Product(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    details VARCHAR(10000),
    price float,
    categoryId INTEGER,
    brandId INTEGER,
    tags VARCHAR(1000), 
    isActive INT(1) DEFAULT 1,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- product image table

CREATE TABLE ProductMetadata (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    productId INTEGER,
    fileName VARCHAR(100),
    type VARCHAR(10),
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- product review table

CREATE TABLE ProductReview (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    productId INTEGER,
    customerId INTEGER,
    comments VARCHAR(1000),
    ratings FLOAT,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- product review image table

CREATE TABLE ProductReviewImages (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    reviewId INTEGER,
    fileName VARCHAR(100),
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- cart table

CREATE TABLE Cart (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    customerId INTEGER,
    totalAmount VARCHAR(1000),
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- cart details table

CREATE TABLE CartDetails (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    cartId INTEGER,
    productId INTEGER,
    price FLOAT,
    quantity INTEGER,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- order table

CREATE TABLE CustomerOrder (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    customerId INTEGER,
    totalAmount VARCHAR(1000),
    paymentMethod VARCHAR(50),
    paymentReferenceId VARCHAR(100),
    status VARCHAR(50) DEFAULT 'placed',
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- cart details table

CREATE TABLE OrderDetails (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    orderId INTEGER,
    productId INTEGER,
    price FLOAT,
    quantity INTEGER,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- coupon table

CREATE TABLE Coupon (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50),
    discount FLOAT,
    type VARCHAR(50) DEFAULT 'percentage',
    activeFrom DATETIME,
    activeTo DATETIME,
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- FAQ table

CREATE TABLE FAQ (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    question VARCHAR(1000),
    answer VARCHAR(10000),
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- complaint table

CREATE TABLE Complaint (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    customerId INTEGER,
    title VARCHAR(100),
    details VARCHAR(1000),
    status INT(1),
    createdDateTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);