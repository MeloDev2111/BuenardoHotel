package Presentacion.Presentadores;

import Apoyo.Mensajes;
import Negocio.Hospedaje;
import Negocio.Login.Usuario;
import Negocio.Servicios.Habitacion;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VRegistroEntrada;
import Presentacion.Vistas.VistaLogin;
import Presentacion.Vistas.VistaRecepcion;

public class PresentadorRecepcion {
    private Usuario user;
    private VistaRecepcion vista;
    
    private Mensajes msg = new Mensajes();
    
    public PresentadorRecepcion(Usuario user, VistaRecepcion vista) {
        this.user = user;
        this.vista = vista;
    }
    
    public void backToLogin(){
        VistaLogin vistaLogin = new VistaLogin();
        PresentadorLogin presentador = new PresentadorLogin(vistaLogin);
        vistaLogin.setPresentador(presentador);
        
        vistaLogin.iniciar();
        this.vista.close();
    }

    public void mostrarVConsultarCuartos() {
        VHabitaciones vistaHab = new VHabitaciones();
        Habitacion hab = new Habitacion();
        PresentadorHabitacion pHab = new PresentadorHabitacion(vistaHab, hab);
        vistaHab.setPresentador(pHab);
        
        pHab.configurarRolRecepConsultas();
        vistaHab.iniciar();
    }

    public void mostrarVRegistroEntrada() {
        VRegistroEntrada vistaRegE = new VRegistroEntrada();
        Hospedaje huesped = new Hospedaje();
        PresentadorRegistroEntrada pRE = new PresentadorRegistroEntrada(vistaRegE, huesped);
        vistaRegE.setPresentador(pRE);
        
        vistaRegE.iniciar();
    }

    public void mostrarVReservar() {
        msg.advertenciaMsg("IN PROCESS", "PRONTO!!");
    }

    public void mostrarVRegistroSalida() {
        msg.advertenciaMsg("IN PROCESS", "PRONTO!!");
    }

    public void mostrarVReservaciones() {
        msg.advertenciaMsg("IN PROCESS", "PRONTO!!");
    }
}
