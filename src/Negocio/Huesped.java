package Negocio;

import Negocio.Login.Usuario;
import Negocio.Servicios.Habitacion;
import java.time.LocalDate;
import java.time.LocalTime;

/* @author MeloDev */
public class Huesped {
    //REFACTOR
    private Cliente cliente;
    private Habitacion habitacion;
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

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
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

    @Override
    public String toString() {
        return "Huesped{" + "cliente=" + cliente + ", habitacion=" + habitacion + ", fEntrada=" + fEntrada + ", hEntrada=" + hEntrada + ", fSalida=" + fSalida + ", HSalida=" + HSalida + ", user=" + user + '}';
    }

    
    
}
