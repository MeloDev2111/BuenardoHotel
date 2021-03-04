package Modelo.Servicios;

import Modelo.Cliente;
import Modelo.Hospedaje;

/* @author MeloDev */
public class EstadoOcupado extends EstadoHabitacion{
    
    public EstadoOcupado(Habitacion habitacion) {
        super(habitacion);
        nombreEstado="Ocupado";
    }

    @Override
    public void agregarAlquiler(Hospedaje h) {
        msg.errorMsg("Actualmente "+nombreEstado+", no se puede registrar huesped");
    }

    @Override
    public void agregarReserva(Hospedaje h) {
        msg.errorMsg("Actualmente "+nombreEstado+", no se puede reservar habitacion");
    }
    
    @Override
    public void desalojarHuesped() {
        
        //CHECK OUT
        
        //MSG FINALIZADO
        msg.OKMsg("HUESPED DESALOJADO");
        estadoSiguiente();
    }

    @Override
    public void estadoSiguiente() {
        habitacion.setEstado(new EstadoDisponible(habitacion));
    }



}
