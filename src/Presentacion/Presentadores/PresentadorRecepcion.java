package Presentacion.Presentadores;

import Apoyo.Mensajes;
import Modelo.Hospedaje;
import Modelo.Login.Usuario;
import Modelo.Servicios.Habitacion;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VHospedajes;
import Presentacion.Vistas.VRegistroEntrada;
import Presentacion.Vistas.VRegistroReserva;
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
        Hospedaje hospedaje = new Hospedaje();
        PresentadorRegistroEntrada pRE = new PresentadorRegistroEntrada(vistaRegE, hospedaje);
        vistaRegE.setPresentador(pRE);
        
        vistaRegE.iniciar();
    }

    public void mostrarVRegistroReserva() {
        VRegistroReserva vistaRegR = new VRegistroReserva();
        Hospedaje hospedaje = new Hospedaje();
        PresentadorRegistroReserva pRR = new PresentadorRegistroReserva(vistaRegR, hospedaje);
        vistaRegR.setPresentador(pRR);
        
        vistaRegR.iniciar();
    }

    public void mostrarVRegistroSalida() {
        msg.advertenciaMsg("IN PROCESS", "PRONTO!!");
    }

    public void mostrarVHospedajes() {
        VHospedajes vistaHos = new VHospedajes();
        Hospedaje hos = new Hospedaje();
        PresentadorHospedajes pHos = new PresentadorHospedajes(vistaHos, hos);
        vistaHos.setPresentador(pHos);
        pHos.configurarRolAdmin();
        vistaHos.setListeners();
        
        vistaHos.iniciar();
    }
}
