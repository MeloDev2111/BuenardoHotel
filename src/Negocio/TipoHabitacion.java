
package Negocio;

public enum TipoHabitacion {
    SIMPLE(50), DOBLE(90),TRIPLE(130),MATRIMONIAL(100),SUITE(200), LUXURY(300);
    
    private double precio;
    
    private TipoHabitacion(double precio){
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
    
}
