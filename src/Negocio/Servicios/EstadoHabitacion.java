package Negocio.Servicios;

import Negocio.Huesped;

/* @author MeloDev */
public abstract class EstadoHabitacion {
    protected Habitacion habitacion;
    protected String nombreEstado;
    
    public abstract void agregarHuesped(Huesped h);
    //public abstract void agregarHuesped(Reservacion r);
    public abstract void desalojarHuesped();
    public abstract void estadoSiguiente();
    public String getNombreEstado() {
        return nombreEstado;
    }
    
    public EstadoHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
