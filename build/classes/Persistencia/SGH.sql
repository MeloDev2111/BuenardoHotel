create database bffb61mrt4emysc84vyz;
use bffb61mrt4emysc84vyz;

create table Usuarios(
	idUsuario int auto_increment primary key not null,
    nombreCuenta varchar(40) unique not null,
    contraseña	varchar(20) not null,
    tipoCuenta varchar(20) not null
);

insert into Usuarios(nombreCuenta,contraseña,tipoCuenta) values
	("admin","admin","ADMINISTRADOR"),
	("MeloDev","2111","ADMINISTRADOR")
;

insert into Usuarios(nombreCuenta,contraseña,tipoCuenta) values
	("recep","recep","RECEPCIONISTA"),
	("huesped","huesped","HUESPED")
;

select * from Usuarios;