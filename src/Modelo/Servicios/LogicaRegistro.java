package Modelo.Servicios;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Hospedaje;
import Modelo.LogicaHospedajes;
import Modelo.Login.LogicaUsuarios;
import Modelo.Login.TiposUsuario;
import Modelo.Login.Usuario;
import java.time.format.DateTimeFormatter;

/* @author MeloDev */
public class LogicaRegistro {
    private Mensajes msg = new Mensajes();
    private Formateo format = new Formateo();
    private LogicaHospedajes logica = new LogicaHospedajes();
    
    public void registrarAlquiler(Hospedaje h){
        //Generamos Usuario
        h.setUser(generarUsuario(h));
        
        //AGREGAR GASTOS OPCIONAL
        
        //Ajustes antes de entrar a la bd
        //la bd esta en utc 0
        h.setfHEntrada( format.formatoUTC_0( h.getfHEntrada() ) );
        h.setfHSalida( format.formatoUTC_0( h.getfHSalida() ) );
        
        logica.guardar(h);
        
    }
    
    //REGISTRO HUESPED CON RESERVA
    public void registrarReserva(Hospedaje h) {
        //Ajustes antes de entrar a la bd
        //la bd esta en utc 0
        h.setfHEntrada( format.formatoUTC_0( h.getfHEntrada() ) );
        h.setfHSalida( format.formatoUTC_0( h.getfHSalida() ) );
        
        logica.guardar(h);
    }
    
    public Usuario generarUsuario(Hospedaje h){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
        LogicaUsuarios logi = new LogicaUsuarios();
        Usuario user = new Usuario();
        
        user.setNombreCuenta(h.getHabitacion().getIdHabitacion()+"-"
                +h.getfHEntrada().format(dtf) );
        
        String nombreCliente = h.getCliente().getApellidos()
                               +h.getCliente().getNombres();
        user.setNombreUsuario(nombreCliente);
        
        user.setContraseña(h.getCliente().getNumDocumento());
        user.setTipoUsuario(TiposUsuario.HUESPED);
        
        //GUARDAR USUSARIO
        user = logi.guardar(user);
        
        msg.OKMsg("Usuario registrado con credenciales:"
                  +"\nUsuario: "+user.getNombreCuenta()
                  +"\nContraseña: "+user.getContraseña());
        
        return user;
    }
}
