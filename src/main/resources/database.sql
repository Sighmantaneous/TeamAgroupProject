CREATE DATABASE IF NOT EXISTS customerdatabase;

USE customerdatabase;

CREATE TABLE IF NOT EXISTS Product (
    productID INT(11) NOT NULL AUTO_INCREMENT,
    productName VARCHAR(50) NOT NULL,
    productDescription VARCHAR(50) NOT NULL,
    productPrice INT(11) NOT NULL,
    warehouseID INT(11) NOT NULL,
    productBrandID INT(11) NOT NULL,
    PRIMARY KEY (productID),
    FOREIGN KEY (warehouseID) REFERENCES Address(productWarehouseID),

    );

CREATE TABLE IF NOT EXISTS Orders (


    );

CREATE TABLE IF NOT EXISTS Customer (


    );

CREATE TABLE IF NOT EXISTS Address (
    customerAddressID INT(11) NOT NULL,
    productWarehouseID INT(11) NOT NULL,
    );

CREATE TABLE IF NOT EXISTS Brands (

    );

CREATE TABLE IF NOT EXISTS Staff (

    );