package Negocio;

/* @author MeloDev */
public class EstadoDisponible extends EstadoHabitacion{

    public EstadoDisponible(Habitacion habitacion) {
        super(habitacion);
        nombreEstado="Disponible";
    }

    @Override
    public void agregarHuesped(Huesped h) {
        habitacion.setHuesped(h);
        System.out.println("HUESPED ALOJADO");
        estadoSiguiente();
    }

    @Override
    public void desalojarHuesped() {
        System.out.println("No existe Huesped actualmente - Habitacion Disponible");
    }

    @Override
    public void estadoSiguiente() {
        habitacion.setEstado(new EstadoOcupado(habitacion));
    }
}
