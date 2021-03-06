package Modelo.Servicios;

import Modelo.Hospedaje;
import Modelo.tipoHospedaje;

/* @author MeloDev */
public class EstadoOcupado extends EstadoHabitacion{
    private LogicaRegistro logiRR = new LogicaRegistro();
    public EstadoOcupado(Habitacion habitacion) {
        super(habitacion);
        nombreEstado="Ocupado";
    }

    @Override
    public void agregarAlquiler(Hospedaje h) {
        msg.errorMsg("Actualmente "+nombreEstado+", no se puede registrar huesped");
    }

    @Override
    public void agregarReserva(Hospedaje hspdj) {
        hspdj.setfHSalida(hspdj.getfHEntrada().plusDays(hspdj.getNroDiasEstancia()));
        hspdj.setTipo(tipoHospedaje.RESERVA);
        hspdj.setEstado("ACTIVO");
        //GUARDAR HOSPEDAJE
        
        logiRR.registrarReserva(hspdj);
        msg.OKMsg("Reserva Registrado");
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
