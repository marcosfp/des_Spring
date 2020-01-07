drop database if exists ejemplo_spring;

create database ejemplo_spring;

use ejemplo_spring; 

drop table if exists usuario;

create table usuario(
   idUsuario BIGINT NOT NULL AUTO_INCREMENT,
   nombreUsuario VARCHAR(30) NOT NULL,
   email VARCHAR(40) NOT NULL UNIQUE,
   direccion VARCHAR(40) NOT NULL,
   password VARCHAR(15) NOT NULL,
   PRIMARY KEY ( idUsuario)
);