package Negocio.Servicios;

import Negocio.Cliente;
import Negocio.Huesped;
import Negocio.Servicios.Habitacion;
import Negocio.Login.TiposUsuario;
import Negocio.Login.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* @author MeloDev */
public class LogicaRegistroEntrada {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH-mm");
    
    public Huesped registrarHuesped(Cliente c, Habitacion h, int diasEstancia){
        Huesped huesped = new Huesped();
        LocalDate fEntrada = LocalDate.now();
        LocalTime hEntrada = LocalTime.now();
        
        huesped.setCliente(c);
        huesped.setIdHabitacion(h.getIdHabitacion());
        huesped.setfEntrada(fEntrada);
        huesped.sethEntrada(hEntrada);
        huesped.setfSalida(fEntrada.plusDays(diasEstancia));
        huesped.setHSalida(hEntrada);
        //GENERAR USUARIO
        generarUsuario(huesped);
        
        //GUARDAR REGISTRO DE ENTRADA
        //cliente - habitacion - fentrada
        
        //CREAR CARRITO
        
        return huesped;
    }
    
    //REGISTRO HUESPED CON RESERVA
    
    public Usuario generarUsuario(Huesped h){
        Usuario user = new Usuario();
        user.setNombreUsuario(h.getIdHabitacion()+"-"
                +h.getfEntrada().format(dtf)+"-"
                +h.gethEntrada().format(dtf2));
        
        user.setContraseña(h.getCliente().getNumDocumento());
        user.setTipoUsuario(TiposUsuario.HUESPED);
        //user.setActivo(true);
        //AGREGAR ESTADO ACTIVO INACTIVO PARA LOS USUARIOS PQ ESAS CUENTAS SON MOMENTANEAS
        //GUARDAR USUSARIO
        return user;
    }
}
