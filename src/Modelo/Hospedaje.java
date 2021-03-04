package Modelo;

import Modelo.Login.Usuario;
import Modelo.Servicios.Habitacion;
import java.time.LocalDateTime;

/* @author MeloDev */
public class Hospedaje {
    //REFACTOR
    private String idHospedaje;
    private tipoHospedaje tipo;
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDateTime fHEntrada;
    private int nroDiasEstancia;
    private LocalDateTime fHSalida;
    private Usuario user;
    private String estado;
    
    public void setTipo(String tipo){
        switch (tipo) {
            case "ALQUILER":
                setTipo(tipoHospedaje.ALQUILER);
                break;
            case "RESERVA":
                setTipo(tipoHospedaje.RESERVA);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public String getNombreTipo(){
        return tipo.name();
    }

    public String getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(String idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public tipoHospedaje getTipo() {
        return tipo;
    }

    public void setTipo(tipoHospedaje tipo) {
        this.tipo = tipo;
    }

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

    public LocalDateTime getfHEntrada() {
        return fHEntrada;
    }

    public void setfHEntrada(LocalDateTime fHEntrada) {
        this.fHEntrada = fHEntrada;
    }

    public LocalDateTime getfHSalida() {
        return fHSalida;
    }

    public int getNroDiasEstancia() {
        return nroDiasEstancia;
    }

    public void setNroDiasEstancia(int nroDiasEstancia) {
        this.nroDiasEstancia = nroDiasEstancia;
    }
    
    public void setfHSalida(LocalDateTime fHSalida) {
        this.fHSalida = fHSalida;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "idHospedaje=" + idHospedaje + ", tipo=" + tipo + ", cliente=" + cliente + ", habitacion=" + habitacion + ", fHEntrada=" + fHEntrada + ", fHSalida=" + fHSalida + ", user=" + user + ", estado=" + estado + '}';
    }

}
