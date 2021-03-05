package Modelo.Servicios;

import Modelo.Hospedaje;

/* @author MeloDev */
public class Habitacion {
   private String idHabitacion;
   private TipoHabitacion tipo; 
   private String descripcion; 
   private double precio; 
   private EstadoHabitacion estado;

    public Habitacion() {
        estado = new EstadoDisponible(this);
        
    }
   
    //MOVER LO DE TIPO HABITACION AQUI PQ SINO PAILA
    public void setEstado(String estado){
        switch(estado) {
            case "DISPONIBLE":
                setEstado(new EstadoDisponible(this));
                break;
            case "OCUPADO":
                setEstado(new EstadoOcupado(this));
                break;
            case "RESERVADO":
                setEstado(new EstadoOcupado(this));
                break;
        }
    }
    
    public void agregarAlquiler(Hospedaje h) {
        estado.agregarAlquiler(h);
    }
    
    public void agregarReserva(Hospedaje h) {
        estado.agregarReserva(h);
    }

    public void desalojarHuesped() {
        estado.desalojarHuesped();
    }

    public void estadoSiguiente() {
        estado.estadoSiguiente();
    }

    public String getNombreEstado() {
        return estado.getNombreEstado();
    }
    
    public String getNombreTipo(){
        return tipo.getNombreTipo();
    }
    
    public double getPrecioDefault(){
        return tipo.getPrecioDflt();
    }
    
   //GETTERS AND SETTERS
    public String getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(String idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion Tipo) {
        this.tipo = Tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoHabitacion getEstado() {
        return estado;
    }

    public void setEstado(EstadoHabitacion estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", tipo=" + tipo + ", descripcion=" + descripcion + ", precio=" + precio + ", estado=" + estado + '}';
    }
    
}
