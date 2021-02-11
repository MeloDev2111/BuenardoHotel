package Pruebas;

import Negocio.Habitacion;
import Negocio.Huesped;
import Negocio.Usuario;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* @author MeloDev */
public class PruebasModelo {
    public static void main(String[] args) {
        
        //CONVERSION DE HORAS Y FECHAS
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH-mm");
        LocalDate now = LocalDate.now();
        LocalTime nowHour = LocalTime.now();
        System.out.println(now.format(dtf)+"-"+nowHour.format(dtf2));
        
        
        
        //PROBANDO EL PATRON STATE
        Habitacion h1 = new Habitacion();
        Huesped h = new Huesped();
        h.setUser(new Usuario());
        Huesped h2 = new Huesped();
        
        h1.agregarHuesped(h);
        h1.agregarHuesped(h2);
        h1.desalojarHuesped();
        h1.desalojarHuesped();
        h1.agregarHuesped(h2);
    }
}
