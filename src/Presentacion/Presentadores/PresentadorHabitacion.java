package Presentacion.Presentadores;

import Apoyo.Formateo;
import Modelo.Hospedaje;
import Modelo.Servicios.Habitacion;
import Modelo.Servicios.LogicaHabitaciones;
import Presentacion.Vistas.VAgregarModificarHabitaciones;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VRegistroEntrada;
import Presentacion.Vistas.VRegistroReserva;
import java.time.LocalDateTime;

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
        //fecha y hora Actuales
        LocalDateTime ahora = LocalDateTime.now();
        vista.setFechaReserva(ahora);
        //
        establecerTablaConsultada();
    }
    
    public void configurarRolRecepRegistroEntrada(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecepRegistroEntrada();
        establecerTablaHabitaciones();
    }
    
    public void configurarRolRecepRegistroReserva(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecepRegistroReserva();
        establecerTablaConsultada();
    }
    
    public void establecerTablaHabitaciones() {
        vista.setTablaHabitaciones(
            format.formatoJtableHabitaciones(
                logica.cargarHabitaciones(vista.getNombreTipo(), vista.getFiltroSeleccionado())
            )     
        );
    }
    
    public void establecerTablaConsultada(){
        vista.setTablaHabitaciones(
            format.formatoJtableHabitaciones(
                logica.consultarHabitaciones(vista.getNombreTipo(), vista.getFechaReserva())
            )     
        );
    }

    public void elegirHabitacionRE() {
        habitacion = logica.buscar(vista.getIdSeleccionado());
        hospedaje.setHabitacion(habitacion);
        System.out.println(habitacion.toString());
        VolverVRegistroEntrada();
    }
    
    public void elegirHabitacionRR() {
        habitacion = logica.buscar(vista.getIdSeleccionado());
        hospedaje.setHabitacion(habitacion);
        System.out.println(habitacion.toString());
        VolverVRegistroReserva();
    }

    public void VolverVRegistroEntrada() {
        VRegistroEntrada vistaReg = new VRegistroEntrada();
        PresentadorRegistroEntrada pReg = new PresentadorRegistroEntrada(vistaReg, hospedaje);
        vistaReg.setPresentador(pReg);
        
        vistaReg.iniciar();
        this.vista.cerrar();
    }

    public void VolverVRegistroReserva() {
        VRegistroReserva vistaReg = new VRegistroReserva();
        PresentadorRegistroReserva pReg = new PresentadorRegistroReserva(vistaReg, hospedaje);
        vistaReg.setPresentador(pReg);
        
        vistaReg.iniciar();
        this.vista.cerrar();
    }   
 
    public void mostrarVAgregarHabitaciones() {
        VAgregarModificarHabitaciones vAddHab = new VAgregarModificarHabitaciones();
        PAgregarModificarHabitacion pAddHab = new PAgregarModificarHabitacion(vAddHab);
        vAddHab.setPresentador(pAddHab);
        vAddHab.deshabilitarBotones();
        vAddHab.habilitarBtnsAdminAgregar();
        pAddHab.cargarListadoTipos();
        pAddHab.establecerPrecioAutomatico();
        
        vAddHab.iniciar();
        //terminando el registro
        establecerTablaHabitaciones();
    }

    public void mostrarVModificarHabitacion() {
        habitacion = logica.buscar(vista.getIdSeleccionado());
        VAgregarModificarHabitaciones vAddHab = new VAgregarModificarHabitaciones();
        PAgregarModificarHabitacion pAddHab = 
                new PAgregarModificarHabitacion(vAddHab,habitacion);
        vAddHab.setPresentador(pAddHab);
        vAddHab.deshabilitarBotones();
        vAddHab.habilitarBtnsAdminModificar();
        pAddHab.cargarListadoTipos();
        pAddHab.establecerPrecioAutomatico();
        
        pAddHab.cargarDatos();
        vAddHab.iniciar();
        //terminando el registro
        establecerTablaHabitaciones();
    }

    public void eliminarHabitacion() {
        habitacion.setIdHabitacion(vista.getIdSeleccionado());
        logica.eliminar(habitacion);
        establecerTablaHabitaciones();
    }
    
}
