package Presentacion;

import Negocio.Usuario;

public class PresentadorRecepcion {
    Usuario user;
    VistaRecepcion vista;

    public PresentadorRecepcion(Usuario user, VistaRecepcion vista) {
        this.user = user;
        this.vista = vista;
    }
    
    public void backToLogin(){
        VistaLogin vistaLogin = new VistaLogin();
        user = new Usuario();
        
        PresentadorLogin presentador = new PresentadorLogin(user,vistaLogin);
        vistaLogin.setPresentador(presentador);
        
        vistaLogin.iniciar();
        this.vista.close();
    }
}
