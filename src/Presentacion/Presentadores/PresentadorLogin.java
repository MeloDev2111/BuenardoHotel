package Presentacion.Presentadores;

import Negocio.ServicioLogin;
import Negocio.Usuario;
import Presentacion.Vistas.VAdmin;
import Presentacion.Vistas.VistaLogin;
import Presentacion.Vistas.VistaRecepcion;

public class PresentadorLogin {
    Usuario user;
    VistaLogin vista;

    public PresentadorLogin(Usuario user, VistaLogin vista) {
        this.user = user;
        this.vista = vista;
    }
    
    public void iniciarSesion(){
        ServicioLogin servicioLogin = new ServicioLogin();
        user.setNombreUsuario(vista.getNombreCuenta());
        user.setContraseña(vista.getContraseña());
        
        user = servicioLogin.iniciarSesion(user);
        
        mostrarVentanaUsuario();
    }
    
    private void mostrarVentanaUsuario(){
        if (user.getIdUsuario() != null) {
            System.out.println("LOGGING...");
            switch (user.getTipoUsuario()) {
                case "ADMINISTRADOR":
                    VAdmin vistaAdmin = new VAdmin();
                    PresentadorAdmin presentadorAdmin = new PresentadorAdmin(user, vistaAdmin);
                    vistaAdmin.setPresentador(presentadorAdmin);
                    //Ver si creamos una entidad empleado y ponemos a los admins y recepcionistas
                    vistaAdmin.iniciar();
                    vistaAdmin.setNombre(user.getNombreUsuario());
                    
                    this.vista.cerrar();
                    
                    break;
                case "RECEPCIONISTA":
                    //AQUI PROXIMAMENTE IRA LA CLASE RECEPCIONISTA -- SE VIENEN BASTANTES CAMBIOS
                    VistaRecepcion vistaRecep = new VistaRecepcion();

                    PresentadorRecepcion presentadorRecep = new PresentadorRecepcion(user,vistaRecep);
                    vistaRecep.setPresentador(presentadorRecep);

                    vistaRecep.iniciar();
                    vistaRecep.setNombreCuenta(user.getNombreUsuario());

                    vista.cerrar();
                    break;
                case "HUESPED":
                    vista.mostrarMensajeAdvertencia("PRONTO DISPONIBLE VISTA HUESPED, C;");
                    break;
                default:
                    vista.mostrarMensajeError("SU VISTA AUN NO HA SIDO CREADA");
            } 
        }
        
    }
}
