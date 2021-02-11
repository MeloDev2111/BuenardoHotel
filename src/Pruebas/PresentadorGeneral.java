package Pruebas;

/* @author MeloDev */
public class PresentadorGeneral {
    General vista;

    public PresentadorGeneral(General vista) {
        this.vista = vista;
    }


    void mostarVistaAnidad() {
        Anidado vistaAnidad = new Anidado();
        PresentadorAnidado presentadorAnidado = new PresentadorAnidado(vistaAnidad);
        vistaAnidad.setPresenter(presentadorAnidado);
        vista.cambiarPanel(vistaAnidad);
    }
    
}
