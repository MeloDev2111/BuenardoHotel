package Presentacion.Presentadores;

import Negocio.Habitacion;
import Negocio.Usuario;
import Presentacion.Vistas.VAdmin;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VistaLogin;

public class PresentadorAdmin{
    private Usuario user;
    private VAdmin vista;
    public PresentadorAdmin(Usuario user, VAdmin vista) {
        this.vista = vista;
        this.user = user;
    }
    
    public void backToLogin(){
        VistaLogin vistaLogin = new VistaLogin();
        user = new Usuario();
        
        PresentadorLogin presentador = new PresentadorLogin(user,vistaLogin);
        vistaLogin.setPresentador(presentador);
        
        vistaLogin.iniciar();
        this.vista.cerrar();
    }
    
    public void mostrarInicio(){
        vista.mostrarInicio();
    }   
    public void mostrarVUsuarios(){
        
    }
    public void mostrarVClientes(){
        
    }
    public void mostrarVHabitacciones(){
        
        VHabitaciones vistaHab = new VHabitaciones();
        Habitacion hab = new Habitacion();
        PresentadorHabitacion pHabitacion = new PresentadorHabitacion(vistaHab, hab);
        vistaHab.setPresentador(pHabitacion);
        pHabitacion.configurarRolAdmin();
        
        this.vista.cambiarVistaActual(vistaHab);
    }
    
    public void mostrarVReservaciones(){
        
    }
    
    public void mostrarVComprobantes(){
        
    }
    
    public void mostrarVServicios(){
        
    }
    

}
