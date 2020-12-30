create database homework;
use honework;
create table Categories(
 id int not null primary key,
 `name` varchar(50),
 `description` varchar(500)
);

create table Suppliers(
id int not null primary key,
`name` varchar(100),
email varchar(50),
phone_number varchar(50),
address varchar(500)
);

create table Customers(
id varchar(50) not null primary key,
first_name varchar(50),
last_name varchar(50),
phone_number varchar(50),
address varchar(500),
email varchar(50),
birthday date
);

create table Employees(
id varchar(50) not null primary key,
first_name varchar(50),
last_name varchar(50),
phone_number varchar(50),
address varchar(500),
email varchar(50),
birthday date
);

create table Products(
id int not null primary key,
`name` varchar(50),
umage_url varchar(1000),
price int,
discount int,
stock int,
category_id int,
supplier_id int,
`description` varchar(65535)
);

create table Orders (
id int not null primary key,
created_date datetime,
shipped_date datetime,
`status` varchar(50),
`description` varchar(65535),
shipping_address varchar(500),
shipping_city varchar(50),
payment_type varchar(20),
customer_id varchar(50),
employee_id varchar(50)
);

create table OrderDetails(
id int not null primary key,
oder_id int,
product_id int,
quantity int
);