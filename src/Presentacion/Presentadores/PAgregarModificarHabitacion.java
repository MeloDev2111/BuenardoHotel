package Presentacion.Presentadores;

import Apoyo.Formateo;
import Modelo.Servicios.Habitacion;
import Modelo.Servicios.LogicaHabitaciones;
import Modelo.Servicios.LogicaTiposHabitacion;
import Modelo.Servicios.TipoHabitacion;
import Presentacion.Vistas.VAgregarModificarHabitaciones;

/* @author MeloDev */
public class PAgregarModificarHabitacion {
    private VAgregarModificarHabitaciones vista;
    private Habitacion h;
    
    private LogicaTiposHabitacion logicaTipos = new LogicaTiposHabitacion();
    private Formateo format = new Formateo();
    private LogicaHabitaciones logicaHabs = new LogicaHabitaciones();
    
    
    public PAgregarModificarHabitacion(VAgregarModificarHabitaciones vista, Habitacion h) {
        this.vista = vista;
        this.h = h;
    }

    public PAgregarModificarHabitacion(VAgregarModificarHabitaciones vista) {
        this.vista = vista;
        h = new Habitacion();
    }
    
    public void guardarHabitacion(){
        h.setPrecio(vista.getPrecio());
        h.setTipo(logicaTipos.buscar(vista.getTipoSeleccionado()));
        h.setDescripcion(vista.getDescripcion());
        h.setEstado("DISPONIBLE");
        logicaHabs.guardar(h);
        
        this.vista.cerrar();
    }
    
    public void modificarHabitacion(){
        h.setPrecio(vista.getPrecio());
        h.setTipo(logicaTipos.buscar(vista.getTipoSeleccionado()));
        h.setDescripcion(vista.getDescripcion());
        logicaHabs.modificar(h);
        
        this.vista.cerrar();
    }
    
    public void cargarDatos(){
        if (h!=null) {
            vista.setTipo(h.getTipo().getIdTipo(), h.getNombreTipo());
            vista.mostrarPrecio(h.getPrecio()+"");
            vista.setDescripcion(h.getDescripcion());
        }
    }
    
    public void cargarListadoTipos(){
        vista.mostrarListaTiposVehiculos(
            format.formatoJtableTiposHab(
                    logicaTipos.cargarTiposHab()
            )
        );
    }
    
    public void establecerPrecioAutomatico() {
        TipoHabitacion tipo = logicaTipos.buscar(vista.getTipoSeleccionado());
        vista.mostrarPrecio(""+tipo.getPrecioDflt());
    }
    
    
    
}
