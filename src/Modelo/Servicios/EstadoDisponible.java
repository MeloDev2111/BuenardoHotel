package Modelo.Servicios;

import Modelo.Hospedaje;
import Modelo.tipoHospedaje;
import java.time.LocalDateTime;

/* @author MeloDev */
public class EstadoDisponible extends EstadoHabitacion{
    private LogicaRegistro logiRE = new LogicaRegistro();
    public EstadoDisponible(Habitacion habitacion) {
        super(habitacion);
        nombreEstado="Disponible";
    }

    @Override
    public void agregarAlquiler(Hospedaje h) {
        h.setfHEntrada(LocalDateTime.now());
        h.setfHSalida(LocalDateTime.now().plusDays(h.getNroDiasEstancia()));
        h.setTipo(tipoHospedaje.ALQUILER);
        h.setEstado("ACTIVO");
        logiRE.registrarAlquiler(h);
        
        msg.OKMsg("Hospedaje Registrado");
        
        estadoSiguiente();
    }
    
    @Override
    public void agregarReserva(Hospedaje hspdj) {
        hspdj.setfHSalida(hspdj.getfHEntrada().plusDays(hspdj.getNroDiasEstancia()));
        hspdj.setTipo(tipoHospedaje.RESERVA);
        hspdj.setEstado("ACTIVO");
        //GUARDAR HOSPEDAJE
        
        logiRE.registrarReserva(hspdj);
        msg.OKMsg("Hospedaje Registrado");
    }
    
    @Override
    public void desalojarHuesped() {
        System.out.println("No existe Huesped actualmente - Habitacion Disponible");
    }

    @Override
    public void estadoSiguiente() {
        habitacion.setEstado(new EstadoOcupado(habitacion));
    }

}
