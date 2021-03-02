package Presentacion.Presentadores;

import Apoyo.Formateo;
import Negocio.Hospedaje;
import Negocio.Servicios.Habitacion;
import Negocio.Servicios.LogicaHabitaciones;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VRegistroEntrada;

/* @author MeloDev */
public class PresentadorHabitacion {
    private VHabitaciones vista;
    private Habitacion habitacion;
    
    private Formateo format = new Formateo();
    private LogicaHabitaciones logica = new LogicaHabitaciones();
    private Hospedaje hospedaje;
    
    public PresentadorHabitacion(VHabitaciones vista, Habitacion habitacion) {
        this.vista = vista;
        this.habitacion = habitacion;
    }
    
    public PresentadorHabitacion(VHabitaciones vista, Hospedaje huesped) {
        this.vista = vista;
        this.hospedaje = huesped;
    }
    
    public void configurarRolAdmin(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsAdmin();
        establecerTablaHabitaciones();
    }
    
    public void configurarRolRecepConsultas(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecepConsultas();
        establecerTablaHabitaciones();
    }
    
    public void configurarRolRecepRegistros(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecepRegistros();
        establecerTablaHabitaciones();
    }
    
    
    
    public void establecerTablaHabitaciones() {
        vista.setTablaHabitaciones(
            format.formatoJtableHabitaciones(
                logica.cargarHabitaciones(vista.getNombreTipo(), vista.getFiltroSeleccionado())
            )     
        );
    }

    public void elegirHabitacion() {
        habitacion = logica.buscar(vista.getIdSeleccionado());
        hospedaje.setHabitacion(habitacion);
        System.out.println(habitacion.toString());
        VolverVRegistro();
    }

    public void VolverVRegistro() {
        VRegistroEntrada vistaReg = new VRegistroEntrada();
        PresentadorRegistroEntrada pReg = new PresentadorRegistroEntrada(vistaReg, hospedaje);
        vistaReg.setPresentador(pReg);
        
        vistaReg.iniciar();
        this.vista.cerrar();
    }
    
}
