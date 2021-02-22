package Negocio.Servicios;

import Negocio.Huesped;

/* @author MeloDev */
public class EstadoOcupado extends EstadoHabitacion{

    public EstadoOcupado(Habitacion habitacion) {
        super(habitacion);
        nombreEstado="Ocupado";
    }

    @Override
    public void agregarHuesped(Huesped h) {
        System.out.println("Existe Huesped actualmente - Habitacion Ocupada");
    }

    @Override
    public void desalojarHuesped() {
        habitacion.setHuesped(null);
        System.out.println("HUESPED DESALOJADO");
        estadoSiguiente();
    }

    @Override
    public void estadoSiguiente() {
        habitacion.setEstado(new EstadoDisponible(habitacion));
    }
}
