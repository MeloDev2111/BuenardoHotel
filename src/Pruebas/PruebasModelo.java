package Pruebas;

import Apoyo.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/* @author MeloDev */
public class PruebasModelo {
    public static void main(String[] args) {
        
        //La base de datos esta en 00:00
//        LocalDateTime oldDateTime = LocalDateTime.parse("2015-10-10T10:00:00");

//        LocalDateTime newDateTime = oldDateTime.atZone(oldZone)
//                                               .withZoneSameInstant(newZone)
//                                               .toLocalDateTime();
//        System.out.println(newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
//    
//CONVERTIR DE UTC -5 A 0
//        ZoneId oldZone = ZoneId.systemDefault();
//        System.out.println(oldZone);
//        ZoneId newZone = ZoneId.of("GMT+0");
//        LocalDateTime now = LocalDateTime.now();
//        
//        LocalDateTime nowUTC0 = now.atZone(oldZone)
//                                    .withZoneSameInstant(newZone).toLocalDateTime();
//        System.out.println(nowUTC0);
        
//        Formateo format = new Formateo();
//        System.out.println(format.formatoUTC_0( LocalDateTime.now() ));
//        
//        System.out.println(format.formatoUTC0_to_Actual( LocalDateTime.now().plusHours(5) ));
//        
//        //AQUI PASA ALGO FEO XDD el current time stamp devuelve date y hora
//        //entonces
//        String fechaBD = "2021-03-01 20:54:50";
//        
//        System.out.println( format.formatoUTC0_to_Actual( 
//                                format.timeStamp_to_DateTime(fechaBD) 
//                                ) 
//                            );
//        System.out.println(format.DateTime_to_timeStamp(LocalDateTime.now()));
//      
        //PROBANDO EL PATRON STATE
//        Habitacion h1 = new Habitacion();
//        Huesped h = new Huesped();
//        h.setUser(new Usuario());
//        Huesped h2 = new Huesped();
//        
//        h1.agregarHuesped(h);
//        h1.agregarHuesped(h2);
//        h1.desalojarHuesped();
//        h1.desalojarHuesped();
//        h1.agregarHuesped(h2);
        
//          Inputs entradas = new Inputs();
//          entradas.inDoublePositivo("Ingrese el nro de horas");
        
    }
}
