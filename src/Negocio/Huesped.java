package Negocio;

import java.time.LocalDate;
import java.time.LocalTime;

/* @author MeloDev */
public class Huesped {
    //REFACTOR
    private Cliente cliente;
    private String idHabitacion;
    private LocalDate fEntrada;
    private LocalTime hEntrada;
    private LocalDate fSalida;
    private LocalTime HSalida;
    private Usuario user;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public LocalDate getfEntrada() {
        return fEntrada;
    }

    public void setfEntrada(LocalDate fEntrada) {
        this.fEntrada = fEntrada;
    }

    public LocalTime gethEntrada() {
        return hEntrada;
    }

    public void sethEntrada(LocalTime hEntrada) {
        this.hEntrada = hEntrada;
    }

    public LocalDate getfSalida() {
        return fSalida;
    }

    public void setfSalida(LocalDate fSalida) {
        this.fSalida = fSalida;
    }

    public LocalTime getHSalida() {
        return HSalida;
    }

    public void setHSalida(LocalTime HSalida) {
        this.HSalida = HSalida;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    
    
    
}
