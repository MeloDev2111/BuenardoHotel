package Pruebas;

/* @author MeloDev */
public class PruebasVistas {
    public static void main(String[] args) {
        General vista = new General();
        PresentadorGeneral presentador = new PresentadorGeneral(vista);
        vista.setPresentador(presentador);
        vista.iniciar();
    }
}
