CREATE DATABASE DIN_HMMC;
USE DIN_HMMC;

CREATE TABLE USER (
	USERNAME VARCHAR(50) PRIMARY KEY,
    PASSWORD VARCHAR(100),
    BIRTHDATE DATE,
    DESCRIPTION TEXT,
    GENDER ENUM ("MALE", "FEMALE", "NON_BINARY", "OTHER")
);

INSERT INTO USER VALUES ("user4", "user4", "2006-10-17", "General description for User no. 4!", "MALE");
INSERT INTO USER VALUES ("user5", "user5", "2006-10-17", "General description for User no. 5!", "FEMALE");
INSERT INTO USER VALUES ("user6", "user6", "2006-10-17", "General description for User no. 6!", "NON_BINARY");