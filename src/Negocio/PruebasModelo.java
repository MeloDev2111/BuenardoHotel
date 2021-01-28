package Negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* @author MeloDev */
public class PruebasModelo {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH-mm");
        LocalDate now = LocalDate.now();
        LocalTime nowHour = LocalTime.now();
        System.out.println(now.format(dtf)+"-"+nowHour.format(dtf2));
    }
}
