package Negocio.Servicios;

import Apoyo.Mensajes;
import Negocio.Hospedaje;

/* @author MeloDev */
public abstract class EstadoHabitacion {
    protected Habitacion habitacion;
    protected String nombreEstado;
    
    protected Mensajes msg = new Mensajes();
            
    public EstadoHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
    
    public abstract void agregarAlquiler(Hospedaje h);
    public abstract void agregarReserva(Hospedaje h);    
    public abstract void desalojarHuesped();
    public abstract void estadoSiguiente();
    
    public String getNombreEstado() {
        return nombreEstado;
    }
    
}
