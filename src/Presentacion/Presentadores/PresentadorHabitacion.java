package Presentacion.Presentadores;

import Apoyo.Formateo;
import Negocio.Servicios.Habitacion;
import Negocio.Servicios.LogicaHabitaciones;
import Presentacion.Vistas.VHabitaciones;

/* @author MeloDev */
public class PresentadorHabitacion {
    private VHabitaciones vista;
    private Habitacion habitacion;
    
    private Formateo format = new Formateo();
    private LogicaHabitaciones logica = new LogicaHabitaciones();
    
    public PresentadorHabitacion(VHabitaciones vista, Habitacion habitacion) {
        this.vista = vista;
        this.habitacion = habitacion;
    }
    
    public void configurarRolAdmin(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsAdmin();
        establecerTablaHabitaciones();
    }
    
    public void configurarRolRecep(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecep();
        establecerTablaHabitaciones();
    }
    
    public void establecerTablaHabitaciones() {
        vista.setTablaHabitaciones(
            format.formatoJtableHabitaciones(
                logica.cargarHabitaciones(vista.getNombreTipo(), vista.getFiltroSeleccionado())
            )     
        );
    }
    
}
