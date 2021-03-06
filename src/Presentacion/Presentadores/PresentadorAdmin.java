package Presentacion.Presentadores;

import Apoyo.Mensajes;
import Modelo.Cliente;
import Modelo.Hospedaje;
import Modelo.Servicios.Habitacion;
import Modelo.Login.Usuario;
import Presentacion.Vistas.VAdmin;
import Presentacion.Vistas.VClientes;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VHospedajes;
import Presentacion.Vistas.VUsuarios;
import Presentacion.Vistas.VistaLogin;

public class PresentadorAdmin{
    private Usuario user;
    private VAdmin vista;
    
    private Mensajes msg = new Mensajes();
    public PresentadorAdmin(Usuario user, VAdmin vista) {
        this.vista = vista;
        this.user = user;
    }
    
    public void backToLogin(){
        VistaLogin vistaLogin = new VistaLogin();
        PresentadorLogin presentador = new PresentadorLogin(vistaLogin);
        vistaLogin.setPresentador(presentador);
        
        vistaLogin.iniciar();
        this.vista.cerrar();
    }
    
    public void mostrarInicio(){
        vista.mostrarInicio();
    }   
    public void mostrarVUsuarios(){
        VUsuarios vistaUsu = new VUsuarios();
        PresentadorUsuarios pUsuarios = new PresentadorUsuarios(vistaUsu,user);
        vistaUsu.setPresentador(pUsuarios);
        pUsuarios.establecerTablaUsuarios();
        vistaUsu.setListeners();
        
        this.vista.cambiarVistaActual(vistaUsu);
    }
    public void mostrarVClientes(){
        VClientes vistaCli = new VClientes();
        Cliente cliente = new Cliente();
        PresentadorClientes pClien = new PresentadorClientes(vistaCli, cliente);
        vistaCli.setPresentador(pClien);
        pClien.configurarRolAdmin();
        
        this.vista.cambiarVistaActual(vistaCli);
    }
    public void mostrarVHabitacciones(){
        
        VHabitaciones vistaHab = new VHabitaciones();
        Habitacion hab = new Habitacion();
        PresentadorHabitacion pHabitacion = new PresentadorHabitacion(vistaHab, hab);
        vistaHab.setPresentador(pHabitacion);
        pHabitacion.configurarRolAdmin();
        vistaHab.setListeners();
        
        this.vista.cambiarVistaActual(vistaHab);
    }
    
    public void mostrarVHospedajes(){
        VHospedajes vistaHos = new VHospedajes();
        Hospedaje hos = new Hospedaje();
        PresentadorHospedajes pHos = new PresentadorHospedajes(vistaHos, hos);
        vistaHos.setPresentador(pHos);
        pHos.configurarRolAdmin();
        vistaHos.setListeners();
        
        this.vista.cambiarVistaActual(vistaHos);     
    }
    
    public void mostrarVComprobantes(){
        msg.advertenciaMsg("IN PROCESS", "PRONTO!!");
    }
    
    public void mostrarVServicios(){
        msg.advertenciaMsg("IN PROCESS", "PRONTO!!");
    }
    

}
