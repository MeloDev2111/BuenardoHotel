package Pruebas;

/* @author MeloDev */
class PresentadorAnidado {
    Anidado vista;
    Contador c;
    public PresentadorAnidado(Anidado vista, Contador c) {
        this.vista = vista;
        this.c=c;
    }
    
    public void sumar(){
        c.suma();
        vista.setNumero(c.getA());
    }
    
    public void restar(){
        c.resta();
        vista.setNumero(c.getA());
    }
}
