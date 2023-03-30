CREATE DATABASE IF NOT EXISTS customerdb;
CREATE TABLE IF NOT EXISTS  Customer (
  id INT(11) NOT NULL AUTO_INCREMENT,
  firstname VARCHAR(50) NOT NULL,
  lastname VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO Customer (firstname, lastname, email) VALUES ('John', 'Doe', 'johndoe@example.com');
INSERT INTO Customer (firstname, lastname, email) VALUES ('Jane', 'Smith', 'janesmith@example.com');
INSERT INTO Customer (firstname, lastname, email) VALUES ('Wilson', 'Eric', 'ewilson@sample.com');
