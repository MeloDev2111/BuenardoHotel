package App;

import Negocio.Usuario;
import Presentacion.Presentadores.PresentadorLogin;
import Presentacion.Vistas.VistaLogin;

public class main {
    public static void main(String[] args) {
        VistaLogin vista = new VistaLogin();
        Usuario MUsuario = new Usuario();
        
        PresentadorLogin presentador = new PresentadorLogin(MUsuario,vista);
        vista.setPresentador(presentador);
        
        vista.iniciar();
        
        //PUEDE INICIAR SESION CON LAS SIGUIENTES CUENTAS
        //USUARIO   CONTRASEÑA  ROL
        //admin     admin       ADMINISTRADOR
        //recep     recep       RECEPCIONISTA
        //huesped   huesped     Huesped
        
    }
}
