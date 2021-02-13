package Presentacion.Presentadores;

import Negocio.Habitacion;
import Negocio.ServicioHabitaciones;
import Presentacion.Vistas.VHabitaciones;

/* @author MeloDev */
public class PresentadorHabitacion {
    VHabitaciones vista;
    Habitacion habitacion;
    
    ServicioHabitaciones serv = new ServicioHabitaciones();
    public PresentadorHabitacion(VHabitaciones vista, Habitacion habitacion) {
        this.vista = vista;
        this.habitacion = habitacion;
    }
    
    public void configurarRolAdmin(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsAdmin();
        establecerListaHabitaciones();
    }
    
    public void configurarRolRecep(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecep();
        establecerListaHabitaciones();
    }
    
    public void establecerListaHabitaciones(){
        vista.setListaHabitaciones(serv.cargarHabitaciones());
    }
    
}
