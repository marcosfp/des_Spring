drop database if exists ejemplo_spring_authentication;

create database ejemplo_spring_authentication;

use ejemplo_spring_authentication; 

drop table if exists rol;
drop table if exists usuario;

create table usuario(
   idUsuario BIGINT NOT NULL AUTO_INCREMENT,
   nombreUsuario VARCHAR(30) NOT NULL,
   email VARCHAR(40) NOT NULL UNIQUE,
   direccion VARCHAR(40) NOT NULL,
   password VARCHAR(15) NOT NULL,
   idRol INT NOT NULL DEFAULT 1,
   PRIMARY KEY ( idUsuario),
   FOREIGN KEY (idRol) REFERENCES rol(idRol)
);



create table rol(
	idRol INT NOT NULL,
	nombreRol VARCHAR (10) NOT NULL,
	PRIMARY KEY ( idRol)
);	



drop database if exists ejemplo_spring_authentication;

create database ejemplo_spring_authentication;

use ejemplo_spring_authentication; 

drop table if exists usuario_rol;
drop table if exists rol;
drop table if exists usuario;

create table usuario(
   idUsuario BIGINT NOT NULL AUTO_INCREMENT,
   nombreUsuario VARCHAR(30) NOT NULL,
   email VARCHAR(40) NOT NULL UNIQUE,
   direccion VARCHAR(40) NOT NULL,
   password VARCHAR(100) NOT NULL,
   idRol INT(11) NOT NULL DEFAULT 1,
   PRIMARY KEY ( idUsuario)
);



create table rol(
	idRol INT(11) NOT NULL,
	nombreRol VARCHAR (10) NOT NULL,
	PRIMARY KEY ( idRol)
);	


CREATE TABLE `usuario_rol` (
  `users_idUsuario` bigint(20) NOT NULL,
  `roles_idRol` int(11) NOT NULL,
  PRIMARY KEY (`users_idUsuario`,`roles_idRol`),
  KEY `FK1ymhq1s8erqbhx4c9kqxp4bbh` (`roles_idRol`)
);

INSERT INTO rol (idRol,nombreRol) VALUES (1, 'usuario');
INSERT INTO rol (idRol,nombreRol) VALUES (2, 'admin');


CREATE TABLE `usuario_rol` (
  `users_idUsuario` bigint(20) NOT NULL,
  `roles_idRol` int(11) NOT NULL,
  PRIMARY KEY (`users_idUsuario`,`roles_idRol`),
  KEY `FK1ymhq1s8erqbhx4c9kqxp4bbh` (`roles_idRol`)
);

INSERT INTO rol (idRol,nombreRol) VALUES (1, 'usuario');
INSERT INTO rol (idRol,nombreRol) VALUES (2, 'admin');
