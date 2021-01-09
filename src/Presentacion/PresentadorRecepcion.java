package Presentacion;

import Negocio.ServicioLogin;
import Negocio.Usuario;

public class PresentadorRecepcion {
    Usuario user;
    VistaLogin vista;

    public PresentadorRecepcion(Usuario user, VistaLogin vista) {
        this.user = user;
        this.vista = vista;
    }
    
    public void iniciarSesion(){
        ServicioLogin servicioLogin = new ServicioLogin();
        
        user.setNombreCuenta(vista.getNombreCuenta());
        user.setContraseña(vista.getContraseña());
        if (servicioLogin.verificarExistencia(user)) {
            if (servicioLogin.verificarContraseña(user)) {
                System.out.println("BIENVENIDO CRACK");
            }else{
                System.out.println("AQUI LA VISTA MUESTRA:CONTRASEÑA INCORRECTA");
            }
        }else{
            System.out.println("AQUI LA VISTA MUESTRA: ESTA CUENTA NO EXISTE");
        }
    }
}
