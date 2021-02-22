package Negocio.Servicios;

import Negocio.Huesped;

/* @author MeloDev */
public class Habitacion {
   private String idHabitacion;
   private TipoHabitacion tipo; 
   private String descripcion; 
   private double precio; 
   private EstadoHabitacion estado;
   private Huesped huesped;

    public Habitacion() {
        estado = new EstadoDisponible(this);
        
    }
   
    public void agregarHuesped(Huesped h) {
        estado.agregarHuesped(h);
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

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
    
    
}
