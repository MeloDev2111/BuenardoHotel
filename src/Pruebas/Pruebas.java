/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Modelo.Hospedaje;
import Modelo.LogicaHospedajes;
import Modelo.Servicios.Habitacion;
import Modelo.Servicios.LogicaHabitaciones;
import Presentacion.Presentadores.PresentadorRegistroReserva;
import Presentacion.Vistas.VRegistroReserva;
import java.security.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author josue
 */
public class Pruebas {
    public static void main(String[] args) {
        LogicaHospedajes logi = new LogicaHospedajes();
//        System.out.println(logi.getNroDiasDisponibles("2"));
        System.out.println(logi.getNroDiasReservables("2", LocalDateTime.now()));
//        for (Hospedaje h : logi.cargarHospedajes("")) {
//            System.out.println(h.toString());
//        }
//        for (Hospedaje h : logi.cargarHospedajesFiltrados("SUC", "RESERVA")) {
//            System.out.println(h.toString());
//        }
           
//        VRegistroReserva vistaRegR = new VRegistroReserva();
//        Hospedaje hospedaje = new Hospedaje();
//        PresentadorRegistroReserva pRR = new PresentadorRegistroReserva(vistaRegR, hospedaje);
//        vistaRegR.setPresentador(pRR);
//        
//        vistaRegR.iniciar();

//        LogicaHabitaciones logiHab = new LogicaHabitaciones();   
//        for (Habitacion h : logiHab.consultarHabitaciones("", LocalDateTime.now().plusDays(3))) {
//            System.out.println(h.toString());
//        }
    }
}
