create database netflix;

use netflix;

create table shows (
show_id varchar(10) primary key,
tipo varchar(250),
title varchar(250),
director varchar(250),
cast text,
country	varchar(250), 
date_added varchar(250),
release_year varchar(4),
rating varchar(250),
duration varchar(250),
listed_in varchar(250),
descripcion text
);

create table cuentas (
idC int primary key auto_increment,
user varchar(30),
correo varchar(60),
pass varchar(45)
);

create table favoritos (
user varchar(30),
idShow varchar(10)
);