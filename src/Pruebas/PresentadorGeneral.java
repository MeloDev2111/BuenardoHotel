package Pruebas;

/* @author MeloDev */
public class PresentadorGeneral {
    General vista;
    Contador c;
    public PresentadorGeneral(General vista,Contador c) {
        this.vista = vista;
        this.c=c;
    }


    void mostarVistaAnidad() {
        Anidado vistaAnidad = new Anidado();
        PresentadorAnidado presentadorAnidado = new PresentadorAnidado(vistaAnidad,c);
        vistaAnidad.setPresenter(presentadorAnidado);
        presentadorAnidado.sumar();
        
        vista.cambiarPanel(vistaAnidad);
    }

    void test() {
        System.out.println(""+c.getA());
    }
    
}
