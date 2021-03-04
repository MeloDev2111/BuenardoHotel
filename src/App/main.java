package App;

import Presentacion.Presentadores.PresentadorLogin;
import Presentacion.Vistas.VistaLogin;

public class Main {
    public static void main(String[] args) {
        VistaLogin vista = new VistaLogin();
        
        PresentadorLogin presentador = new PresentadorLogin(vista);
        vista.setPresentador(presentador);
        
        vista.iniciar();
        
        //PUEDE INICIAR SESION CON LAS SIGUIENTES CUENTAS
        //USUARIO   CONTRASEÑA  ROL
        //admin     admin       ADMINISTRADOR  --DESACTIVADO
        //melodev   2111        ADMINISTRADOR
        //recep     recep       RECEPCIONISTA
        //huesped   huesped     Huesped
        
    }
}
