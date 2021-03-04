create database bffb61mrt4emysc84vyz;
use bffb61mrt4emysc84vyz;

-- SET GLOBAL time_zone = '-05:00';
-- EL TIME ZONE POR DEFECTO ES 00:00

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
    estado varchar(50) not null,
    activo boolean not null default(true)
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

Update Habitaciones set idTipoHabitacion = 1, descripcion= "Hab simple con baño", precio=80 where idHabitacion = 2;

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
    numDocumento varchar(20) unique not null,
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
select * from Clientes;


UPDATE Clientes SET tipoCliente = "NATURAL",apellidosCliente = "ABANTO NORIEGA",nombresCliente = "MARIA",tipoDocumento = "DNI",numDocumento = "10328452" WHERE idCliente = 1;


-- EXPANSION REGISTRO DE ENTRADA

DELIMITER $$
CREATE procedure deshabilitarUsuario(id int)
BEGIN
	UPDATE Usuarios SET activo = false 
	WHERE idUsuario = id;
END$$
delimiter ;

call deshabilitarUsuario(2);

DELIMITER $$
CREATE procedure modificarEstado(id int, est varchar(50))
BEGIN
	UPDATE Habitaciones SET estado = est 
	WHERE idHabitacion = id;
END$$
delimiter ;

call modificarEstado(2, 'DISPONIBLE');
select * from Habitaciones;

--
create table Hospedajes(
	idHospedaje int auto_increment primary key not null,
    tipo Enum('ALQUILER', 'RESERVA') not null,
    idCliente int not null,
    idHabitacion int not null,
    fechaEntrada timestamp not null,
    fechaSalida timestamp,
    idUsuario int,
    estado Enum('ACTIVO', 'BAJA') not null
);


-- FALTAN LAS RELACIONES DE HOSPEDAJE



-- registrar Alquiler
DELIMITER $$
CREATE procedure registrarHospedajeAlquiler(idCli int, idHab int, nroDias int, idUser int)
BEGIN
	INSERT INTO Hospedajes(idCliente,idHabitacion,tipo,fechaEntrada,fechaSalida,idUsuario)VALUES
		(idCli,idHab,'ALQUILER', current_timestamp(),DATE_ADD(current_timestamp(), INTERVAL nroDias DAY),idUser)
	;
    call modificarEstado(idHab, 'OCUPADO');
END$$
delimiter ;

-- registrar Reserva
DELIMITER $$
CREATE procedure registrarHospedajeReserva(idCli int, idHab int, fReserva timestamp,nroDias int)
BEGIN
	INSERT INTO Hospedajes(idCliente,idHabitacion,tipo,fechaEntrada,fechaSalida)VALUES
		(idCli,idHab,'RESERVA',fReserva,DATE_ADD(fReserva, INTERVAL nroDias DAY) )
	;
END$$
delimiter ;

insert into Usuarios(nombreCuenta,nombreUsuario,contraseña,tipoCuenta) values
	("2-2021-02-26-00-48","Huesped por defecto","pollo","HUESPED")
;

select * from Usuarios;

call registrarHospedajeAlquiler(3,1,3,5);
call registrarHospedajeAlquiler(2,2,3,6);

call registrarHospedajeReserva(2,2,DATE_ADD(current_timestamp(), INTERVAL 20 DAY),3);




select * FROM Habitaciones;

select * FROM Hospedajes;


-- calcular dias permitidos
	select
		datediff(fechaSalida,fechaEntrada) as diasEstancia,
        datediff(fechaEntrada,current_timestamp()) as diasdispo
    from Hospedajes
    where idHabitacion = 1 AND fechaEntrada>=current_timestamp() AND estado = 'ACTIVO'
    limit 1
    ;
    select *,datediff(fechaSalida,fechaEntrada) as diasEstancia from Hospedajes;


-- Procedure de calcular dias permitidos de una habitacion disponible
DELIMITER $$
create procedure getDiasDisponibles(
IN idHab int,
OUT diasDispo int
)
begin
	DECLARE dias int default 0;
	select
		datediff(fechaEntrada,current_timestamp()) INTO dias
    from Hospedajes
    where idHabitacion = idHab AND fechaEntrada>=current_timestamp() AND estado = 'ACTIVO'
    limit 1;
    
    set diasDispo = dias;
end$$
delimiter ;

call getDiasDisponibles(2,@dias);
select @dias;

select * from Hospedajes;

select current_timestamp();





-- INTENTADO OBTENER LOS ESTADOS FUTUROS
select 
	*,
    call getDiasDisponibles(1,@dias),
    case 
		when @dias is not null
        then
			'DISPONIBLE'
	end as 'Estado Futuro'
from Habitaciones;


-- uso de cursores a ver que pedo
DELIMITER $$
create procedure recorridoConCursor()
begin
	-- Declaración de variables
	DECLARE habID int default 0;
    DECLARE fin INTEGER DEFAULT 0;
    
    -- Definicion del cursor
    DECLARE c1 CURSOR FOR SELECT idHabitacion FROM Habitaciones order by idHabitacion;
    
    -- Declaración de un manejador de error tipo NOT FOUND
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;
    
    -- Abrimos el cursor
    OPEN c1;
	-- Comenzamos nuestro bucle de lectura
    loop1: LOOP
		-- Obtenemos la primera fila en la variables correspondientes
		FETCH c1 INTO habID;
        
        IF fin=1 THEN LEAVE loop1;
		END IF;
        
		call modificarEstado(habID, 'OCUPADO');
			
		-- Si el cursor se quedó sin elementos,
		-- entonces nos salimos del bucle
		
    
	END LOOP loop1;
    
	-- Cerramos el cursor
	CLOSE c1;
end$$
delimiter ;

call recorridoConCursor();
-- drop procedure recorridoConCursor;

select * from Habitaciones;
call modificarEstado(1, 'DISPONIBLE');
call modificarEstado(2, 'DISPONIBLE');
select * from Habitaciones;


-- ME DEVUELVE EL HOSPEDAJE ACTIVO EN UNA DETERMINADA FECHA
select
	*,
    'Reservado' estadoFuturo
from Habitaciones h, (select * from Hospedajes) futuro
where h.idHabitacion = futuro.idHabitacion AND futuro.estado='ACTIVO'
AND futuro.fechaEntrada<=DATE_ADD(current_timestamp(), INTERVAL 5 DAY) AND futuro.fechaSalida>=DATE_ADD(current_timestamp(), INTERVAL 5 DAY)
AND h.idHabitacion = 2
;



-- RESET MASTER
drop database bffb61mrt4emysc84vyz;




-- diagrama de flujo
-- registrar cliente
-- seleccionar habitacion
-- comprobar habitacion disponible
-- determinar numero maximo de dias a alquilar
-- generar usuario si es alquiler
-- registrar hospedaje
-- nah mas
-- revisar

-- este tiene mas avance - NO FUNCIONA
DELIMITER $$
CREATE procedure validacionHospedajes()
BEGIN
	select 
		case
			when fechaEntrada >= fechaSalida
            THEN 
				modificarEstado(idHabitacion, 'DISPONIBLE') + deshabilitarUsuario(idUsuario)
        end
        
    from Hospedajes h;
END$$
delimiter ;

call validacionHospedajes();

-- ------------------------