drop database if exists thuchanh1;
create database thuchanh1;
use thuchanh1;

CREATE TABLE contacts
( contact_id INT(11) NOT NULL AUTO_INCREMENT,
contact_type varchar(30),
  -- last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

CREATE TABLE suppliers
( supplier_id INT(11) NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

-- DROP TABLE contacts, suppliers;

ALTER TABLE contacts
  ADD last_name varchar(40) NOT NULL
    AFTER contact_id;
    
    ALTER TABLE contacts
  MODIFY last_name varchar(50) NULL;
  
  ALTER TABLE contacts
  CHANGE COLUMN contact_type ctype
    varchar(20) NOT NULL;
    
    ALTER TABLE contacts
  RENAME TO people;
