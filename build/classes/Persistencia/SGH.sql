create database bffb61mrt4emysc84vyz;
use bffb61mrt4emysc84vyz;

create table Usuarios(
	idUsuario int auto_increment primary key not null,
    nombreUsuario varchar(100) not null,
    nombreCuenta varchar(40) unique not null,
    contraseña	varchar(20) not null,
    tipoCuenta varchar(20) not null,
    activo boolean not null default(true)
);

insert into Usuarios(nombreCuenta,nombreUsuario,contraseña,tipoCuenta) values
	("admin","Administrador por defecto","admin","ADMINISTRADOR"),
	("MeloDev","Diaz Diaz Melio Josue","2111","ADMINISTRADOR"),
	("recep","Romero Loli Harby Breyner","recep","RECEPCIONISTA"),
	("huesped","Lujan Rojas Nelvin Eduardo","huesped","HUESPED")
;

UPDATE Usuarios SET
nombreCuenta = "Admin", 
nombreUsuario = "Administrador por defecto",
contraseña = "admin",
tipoCuenta = "ADMINISTRADOR",
activo = false
WHERE idUsuario = 1;

delete from Usuarios where idUsuario = 1;

SELECT * FROM Usuarios WHERE nombreCuenta="admin";
select * from Usuarios;

create view vistaUsuariosActivos as
select
		*
from Usuarios
where activo = true
;

select * from vistaUsuariosActivos;

select * from vistaUsuariosActivos where nombreUsuario like '%D%';


-- EXPANDIENDO HABITACIONES
create table Habitaciones(
	idHabitacion int auto_increment primary key not null,
    idTipoHabitacion int not null,
	descripcion text not null,
    precio double not null,
    estado varchar(50) not null
);

create table TiposHabitacion(
	idTipoHabitacion int auto_increment primary key not null,
    tipo varchar(50) not null,
    precioDflt double not null
);

alter table Habitaciones add constraint 
foreign key(idTipoHabitacion) references TiposHabitacion(idTipoHabitacion)
on update cascade on delete no action;  


INSERT INTO TiposHabitacion(tipo,precioDflt)VALUES
	("SIMPLE",50),
    ("DOBLE",90),
    ("TRIPLE",130),
    ("MATRIMONIAL",100),
    ("SUITE",200),
    ("LUXURY",300)
;

INSERT INTO Habitaciones(idTipoHabitacion,descripcion,precio,estado) VALUES
	(2,"Habitacion Doble con baño, tv, cama",90,"DISPONIBLE"),
    (1,"Habitacion Simple con tv, cama",70,"OCUPADO")
;

select * from TiposHabitacion;
select * from Habitaciones;


create view vistaHabitaciones as
select
		h.*,
        t.tipo
from Habitaciones h
inner join TiposHabitacion t on t.idTipoHabitacion = h.idTipoHabitacion
;

create view vistaHabitacionesDisponibles as
select
		h.*,
        t.tipo
from Habitaciones h
natural join TiposHabitacion t
where h.estado = "DISPONIBLE"
;
select * from vistaHabitaciones;
select * from vistaHabitacionesDisponibles;

SELECT * FROM vistaHabitaciones WHERE tipo like '%Doble%'  
AND estado = "DISPONIBLE";



-- EXPANSION Clientes

create table Clientes(
	idCliente int auto_increment primary key not null,
    tipoCliente varchar(20) not null,
    apellidosCliente varchar(100) not null,
    nombresCliente varchar(100),
    tipoDocumento varchar(50) not null,
    numDocumento text not null,
    activo boolean not null default(true)
);

INSERT INTO Clientes(tipoCliente,apellidosCliente,nombresCliente,tipoDocumento,numDocumento) VALUES
	('NATURAL','ABANTO NORIEGA','MARIA','DNI','10328452'),
    ('JURIDICO','GRUPO SUCNO S.A.C.',null,'RUC','20445509893'),
    ('NATURAL','RODRIGUEZ VENTURA','BERTHA','DNI','32765772'),
    ('NATURAL','CARRANZA MEJIA','JORGE ADALBERTO','DNI','10328792'),
    ('JURIDICO','IGLESIAS  SANDOVAL','OFELIA','RUC','10327764581')
;

select * from Clientes where activo = true;

-- RESET MASTER
drop database bffb61mrt4emysc84vyz;
