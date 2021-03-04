package Presentacion.Presentadores;

import Apoyo.Mensajes;
import Modelo.Login.LogicaLogin;
import Modelo.Login.Usuario;
import Presentacion.Vistas.VAdmin;
import Presentacion.Vistas.VistaLogin;
import Presentacion.Vistas.VistaRecepcion;

public class PresentadorLogin {
    private Usuario user;
    private VistaLogin vista;
    
    private Mensajes msg = new Mensajes();
    private LogicaLogin logiLogin = new LogicaLogin();
    
    public PresentadorLogin(VistaLogin vista) {
        this.user = new Usuario();
        this.vista = vista;
    }
    
    public void iniciarSesion(){
        user.setNombreCuenta(vista.getNombreCuenta());
        user.setContraseña(vista.getContraseña());
        
        user = logiLogin.iniciarSesion(user);
        
        
        mostrarVentanaUsuario();  
    }
    
    private void mostrarVentanaUsuario(){
        if (user.getIdUsuario() != null) {
            System.out.println("LOGGING...");
            
            switch (user.getTipoUsuario()) {
                case ADMINISTRADOR:
                    VAdmin vistaAdmin = new VAdmin();
                    PresentadorAdmin presentadorAdmin = new PresentadorAdmin(user, vistaAdmin);
                    vistaAdmin.setPresentador(presentadorAdmin);
                    vistaAdmin.iniciar();
                    vistaAdmin.setNombre(user.getNombreUsuario());
                    this.vista.cerrar();
                    break;
                case RECEPCIONISTA:
                    VistaRecepcion vistaRecep = new VistaRecepcion();

                    PresentadorRecepcion presentadorRecep = new PresentadorRecepcion(user,vistaRecep);
                    vistaRecep.setPresentador(presentadorRecep);

                    vistaRecep.iniciar();
                    vistaRecep.setNombreUsuario(user.getNombreUsuario());
                    this.vista.cerrar();
                    break;
                case HUESPED:
                    msg.advertenciaMsg("IN PROCESS", "PRONTO DISPONIBLE VISTA HUESPED, C;");
                    break;
                default:
                    msg.advertenciaMsg("IN PROCESS", "PRONTO DISPONIBLE VISTA HUESPED, C;");
                    break;
            } 
        }
        
    }
}
