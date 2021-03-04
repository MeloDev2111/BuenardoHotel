package Presentacion.Presentadores;

import Apoyo.Formateo;
import Modelo.Hospedaje;
import Modelo.Servicios.Habitacion;
import Modelo.Servicios.LogicaHabitaciones;
import Presentacion.Vistas.VAgregarModificarHabitaciones;
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

    public void mostrarVAgregarHabitaciones() {
        VAgregarModificarHabitaciones vAddHab = new VAgregarModificarHabitaciones();
        PAgregarModificarHabitacion pAddHab = new PAgregarModificarHabitacion(vAddHab);
        vAddHab.setPresentador(pAddHab);
        vAddHab.deshabilitarBotones();
        vAddHab.habilitarBtnsAdminAgregar();
        
        vAddHab.iniciar();
    }

    public void mostrarVModificarHabitacion() {
        habitacion = logica.buscar(vista.getIdSeleccionado());
        VAgregarModificarHabitaciones vAddHab = new VAgregarModificarHabitaciones();
        PAgregarModificarHabitacion pAddHab = 
                new PAgregarModificarHabitacion(vAddHab,habitacion);
        vAddHab.setPresentador(pAddHab);
        vAddHab.deshabilitarBotones();
        vAddHab.habilitarBtnsAdminModificar();
        
        vAddHab.iniciar();
        pAddHab.cargarDatos();
    }

    public void eliminarHabitacion() {
        habitacion.setIdHabitacion(vista.getIdSeleccionado());
        logica.eliminar(habitacion);
        establecerTablaHabitaciones();
    }
    
}
