package Negocio;

/* @author MeloDev */
public class EstadoDisponible extends EstadoHabitacion{

    public EstadoDisponible(Habitacion habitacion) {
        super(habitacion);
    }

    @Override
    public void agregarHuesped(Huesped h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desalojarHuesped() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void estadoSiguiente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombreEstado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
