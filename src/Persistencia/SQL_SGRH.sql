create database bffb61mrt4emysc84vyz;
use bffb61mrt4emysc84vyz;

-- SET GLOBAL time_zone = '-05:00';
-- EL TIME ZONE POR DEFECTO ES 00:00

-- CREACION DE TABLAS
create table Usuarios(
	idUsuario int auto_increment primary key not null,
    nombreUsuario varchar(100) not null,
    nombreCuenta varchar(40) unique not null,
    contraseña	varchar(20) not null,
    tipoCuenta varchar(20) not null,
    activo boolean not null default(true)
);

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


create table Clientes(
	idCliente int auto_increment primary key not null,
    tipoCliente varchar(20) not null,
    apellidosCliente varchar(100) not null,
    nombresCliente varchar(100),
    tipoDocumento varchar(50) not null,
    numDocumento varchar(20) unique not null,
    activo boolean not null default(true)
);

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


-- RELACIONES FK INDEX
alter table Habitaciones add constraint 
foreign key(idTipoHabitacion) references TiposHabitacion(idTipoHabitacion)
on update cascade on delete no action;  

alter table Hospedajes add constraint 
foreign key(idCliente) references Clientes(idCliente)
on update cascade on delete no action;  

alter table Hospedajes add constraint 
foreign key(idHabitacion) references Habitaciones(idHabitacion)
on update cascade on delete no action;  

alter table Hospedajes add constraint 
foreign key(idUsuario) references Usuarios(idUsuario)
on update cascade on delete set null;  



-- LLENADO DE DATOS

INSERT INTO Clientes(tipoCliente,apellidosCliente,nombresCliente,tipoDocumento,numDocumento) VALUES
	('NATURAL','Romero Loli','Harby Breyner','DNI','19358248'),
    ('NATURAL','Lujan Rojas','Nelvin Eduardo','DNI','92845631'),
    ('NATURAL','Diaz Diaz','Melio Josue','DNI','74128448'),
    ('NATURAL','ABANTO NORIEGA','MARIA','DNI','10328452'),
    ('JURIDICO','GRUPO SUCNO S.A.C.',null,'RUC','20445509893'),
    ('NATURAL','RODRIGUEZ VENTURA','BERTHA','DNI','32765772'),
    ('NATURAL','CARRANZA MEJIA','JORGE ADALBERTO','DNI','10328792'),
    ('JURIDICO','IGLESIAS  SANDOVAL','OFELIA','RUC','10327764581')
;

insert into Usuarios(nombreCuenta,nombreUsuario,contraseña,tipoCuenta) values
	("admin","Administrador por defecto","admin","ADMINISTRADOR"),
	("MeloDev","Diaz Diaz Melio Josue","2111","ADMINISTRADOR"),
	("recep","Romero Loli Harby Breyner","recep","RECEPCIONISTA")
;

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
    (1,"Habitacion Simple con tv, cama",70,"DISPONIBLE"),
    (4,"Habitacion Matrimonial",100,"DISPONIBLE"),
    (5,"Suite Buenarda",180,"DISPONIBLE"),
    (6,"Habitacion Luxury BUENARDA",320,"DISPONIBLE")
;

-- eliminado DE DATOS
UPDATE Usuarios SET activo = false WHERE idUsuario = 1;

UPDATE Clientes SET activo = false WHERE idCliente = 8;

UPDATE Habitaciones SET activo = false WHERE idHabitacion = 3;

-- Actualizado DE DATOS
UPDATE Usuarios SET
	nombreCuenta = "Admin", 
	nombreUsuario = "Administrador deshabilitado",
	contraseña = "admin",
	tipoCuenta = "ADMINISTRADOR",
	activo = false
WHERE idUsuario = 1;

UPDATE Clientes SET 
	tipoCliente = "NATURAL",
    apellidosCliente = "ABANTO NORIEGA",
    nombresCliente = "MARIA",
    tipoDocumento = "DNI",
    numDocumento = "10328452" 
WHERE idCliente = 4;

Update Habitaciones set 
	idTipoHabitacion = 1,
    descripcion= "Hab simple con baño",
    precio=80 
where idHabitacion = 2;

-- PROBANDO
select * from Usuarios;
select * from Clientes where activo = true;
select * from Clientes;
select * from Habitaciones;



-- CREACION DE VISTAS
-- vista de Usuarios Activos
create view vistaUsuariosActivos as
select
		*
from Usuarios
where activo = true
;
-- PROBANDO
	select * from vistaUsuariosActivos;

	select * from vistaUsuariosActivos where nombreUsuario like '%D%';

-- vista de Habitaciones
create view vistaHabitaciones as
select
		h.*,
        t.tipo
from Habitaciones h
inner join TiposHabitacion t on t.idTipoHabitacion = h.idTipoHabitacion
;
-- PROBANDO
	select * from vistaHabitaciones;
	SELECT * FROM vistaHabitaciones WHERE tipo like '%Doble%' AND estado = "DISPONIBLE";
    
    
-- vista de Habitaciones Disponibles
create view vistaHabitacionesDisponibles as
select
		h.*,
        t.tipo
from Habitaciones h
natural join TiposHabitacion t
where h.estado = "DISPONIBLE"
;
-- PROBANDO
	select * from vistaHabitacionesDisponibles;


-- vistaHospedajes que muestra en gmt-5 las fechas
create view vistaHospedajesHorarioPeru as
select
	h.idHospedaje,
    h.tipo as "Tipo Hospedaje",
    h.idCliente,
    c.apellidosCliente,
    h.idHabitacion,
    t.tipo as "Tipo Habtacion",
    hab.precio,
    date_sub(h.fechaEntrada, INTERVAL 5 hour) as "fechaEntrada",
    date_sub(h.fechaSalida, INTERVAL 5 hour) as "fechaSalida",
    datediff(fechaSalida,fechaEntrada) as diasEstancia,
    h.idUsuario,
    h.estado
from Hospedajes h
natural join Clientes c
inner join Habitaciones hab on hab.idHabitacion = h.idHabitacion
inner join TiposHabitacion t on t.idTipoHabitacion = hab.idTipoHabitacion
;
-- PROBANDO
	select * from vistaHospedajesHorarioPeru;


-- Store Procedures

DELIMITER $$
CREATE procedure habilitarUsuario(id int)
BEGIN
	UPDATE Usuarios SET activo = true 
	WHERE idUsuario = id;
END$$
delimiter ;
-- probando
	call habilitarUsuario(1);
	select * from Usuarios;

DELIMITER $$
CREATE procedure deshabilitarUsuario(id int)
BEGIN
	UPDATE Usuarios SET activo = false 
	WHERE idUsuario = id;
END$$
delimiter ;
-- probando
	call deshabilitarUsuario(1);
	select * from Usuarios;
    
DELIMITER $$
CREATE procedure modificarEstado(id int, est varchar(50))
BEGIN
	UPDATE Habitaciones SET estado = est 
	WHERE idHabitacion = id;
END$$
delimiter ;
-- probando
	call modificarEstado(2, 'OCUPADO');
    select * from Habitaciones;
	call modificarEstado(2, 'DISPONIBLE');
	select * from Habitaciones;


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

-- probando
	insert into Usuarios(nombreCuenta,nombreUsuario,contraseña,tipoCuenta) values
		("4-2021-03-05-02-48","Huesped por defecto","19358248","HUESPED"),
        ("5-2021-03-06-13-48","Huesped por defecto","92845631","HUESPED")
	;
	call registrarHospedajeAlquiler(1,4,10,4);
	call registrarHospedajeAlquiler(2,5,8,5);
-- comprobando
	select * from Usuarios;
    select * from Clientes;
    select * FROM Habitaciones;
    select * from Hospedajes;
    select * from vistaHospedajesHorarioPeru;
    
-- registrar Reserva
DELIMITER $$
CREATE procedure registrarHospedajeReserva(idCli int, idHab int, fReserva timestamp,nroDias int)
BEGIN
	INSERT INTO Hospedajes(idCliente,idHabitacion,tipo,fechaEntrada,fechaSalida)VALUES
		(idCli,idHab,'RESERVA',fReserva,DATE_ADD(fReserva, INTERVAL nroDias DAY) )
	;
END$$
delimiter ;

call registrarHospedajeReserva(3,1,DATE_ADD(current_timestamp(), INTERVAL 15 DAY),3);
call registrarHospedajeReserva(3,1,DATE_ADD(current_timestamp(), INTERVAL 20 DAY),4);
call registrarHospedajeReserva(3,4,DATE_ADD(current_timestamp(), INTERVAL 25 DAY),3);
call registrarHospedajeReserva(3,5,DATE_ADD(current_timestamp(), INTERVAL 30 DAY),5);

-- comprobando
    select * from Clientes;
    select * FROM Habitaciones;
    select * from Hospedajes;
    select * from vistaHospedajesHorarioPeru;
    
    
-- ME DEVUELVE LOS HOSPEDAJE ACTIVO EN UNA DETERMINADA FECHA
DELIMITER $$
create procedure getHospedajesActivos(
IN fConsulta timestamp
)
begin
	select
		*
	from Habitaciones h, (select * from Hospedajes) futuro
	where h.idHabitacion = futuro.idHabitacion AND futuro.estado='ACTIVO'
	AND futuro.fechaEntrada<=fConsulta AND futuro.fechaSalida>=fConsulta
	;
    
end$$
delimiter ;
-- probando
	call getHospedajesActivos( DATE_ADD(current_timestamp(), INTERVAL 1 DAY) );


-- Procedure de calcular dias permitidos de una habitacion disponible TIEMPO ACTUAL
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
-- PROBANDO
	call getDiasDisponibles(1,@dias);
	select @dias;
-- comprobando
	select * from vistaHospedajesHorarioPeru;



-- Procedure de calcular dias permitidos de una habitacion en el futuro
DELIMITER $$
create procedure getDiasReservables(
IN idHab int,
IN fReserva timestamp,
OUT diasDispo int
)
begin
	DECLARE dias int default 0;
	select
		datediff(fechaEntrada,fReserva) INTO dias
    from Hospedajes
    where idHabitacion = idHab AND fechaEntrada>=fReserva AND tipo='RESERVA' AND estado = 'ACTIVO'
    limit 1;
    
    set diasDispo = dias;
end$$
delimiter ;

call getDiasReservables(4,DATE_ADD(current_timestamp(), INTERVAL 12 DAY),@dias);
select @dias;
-- comprobando
	select * from vistaHospedajesHorarioPeru;
	select * from Hospedajes;


-- uso de cursores
DELIMITER $$
create procedure habilitarAllHabitaciones()
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
        
		call modificarEstado(habID, 'DISPONIBLE');
		-- Si el cursor se quedó sin elementos,
		-- entonces nos salimos del bucle
    
	END LOOP loop1;
    
	-- Cerramos el cursor
	CLOSE c1;
end$$
delimiter ;
-- probando
	call habilitarAllHabitaciones();
-- drop procedure recorridoConCursor;
-- comprobando
	select * from Habitaciones;
    


-- Consultar EL ESTADO (OCUPADO, RESERVADO, DISPONIBLE) DE UNA HABITACION
DELIMITER $$
create procedure consultarEstado(
IN idHab int,
IN ahora timestamp
)
proceso: begin
	-- Declaración de variables
    DECLARE _tipo Enum('ALQUILER', 'RESERVA');
	DECLARE _habID int default 0;
    DECLARE _fechaEntrada timestamp;
    DECLARE _fechaSalida timestamp;
    DECLARE _idUsuario int;
    
    DECLARE fin INTEGER DEFAULT 0;
    -- Definicion del cursor
    DECLARE c1 CURSOR FOR SELECT tipo,idHabitacion,fechaEntrada,fechaSalida,idUsuario FROM Hospedajes where estado = 'ACTIVO' AND idHabitacion=idHab order by fechaEntrada asc ;
    -- Declaración de un manejador de error tipo NOT FOUND
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET fin = 1;

    -- Abrimos el cursor
    OPEN c1;
	-- Comenzamos nuestro bucle de lectura
    loop1: LOOP
		-- Obtenemos la primera fila en la variables correspondientes
		FETCH c1 INTO _tipo,_habID,_fechaEntrada,_fechaSalida,_idUsuario;
        
        -- si no tiene ningun registro
        IF fin=1 THEN 
			select idHab as "idHabitacion","DISPONIBLE" as "estado";
            LEAVE loop1;
		END IF;
        
        -- Aqui haremos la magia
        
        if ahora>_fechaEntrada then
			if ahora<=_fechaSalida then
				select _habID as "idHabitacion" ,"OCUPADO" as "estado";
                LEAVE loop1;
            end if;
            -- si se va al else
            -- "Siguiente Hospedaje proximo"
		else
			if ahora=_fechaEntrada then
				if _tipo = "ALQUILER" then
					select _habID as "idHabitacion","OCUPADO" as "estado";
                else
					select _habID as "idHabitacion","RESERVADO" as "estado";
                end if;
				leave loop1;
            end if;
            select _habID as "idHabitacion","DISPONIBLE" as "estado";
            leave loop1;
        end if;
		-- Si el cursor se quedó sin elementos,
		-- entonces nos salimos del bucle
	END LOOP loop1;
    
	-- Cerramos el cursor
	CLOSE c1;
end$$
delimiter ;
-- probando
	call consultarEstado(4, DATE_ADD(current_timestamp(), INTERVAL 25 DAY));
-- comprobando

	select * from Hospedajes where idHabitacion=4 AND estado="ACTIVO" order by fechaEntrada asc;
	select * from Hospedajes;



-- RESET MASTER
drop database bffb61mrt4emysc84vyz;