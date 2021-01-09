package Presentacion;

import Negocio.ServicioLogin;
import Negocio.Usuario;

public class PresentadorLogin {
    Usuario user;
    VistaLogin vista;

    public PresentadorLogin(Usuario user, VistaLogin vista) {
        this.user = user;
        this.vista = vista;
    }
    
    public void iniciarSesion(){
        ServicioLogin servicioLogin = new ServicioLogin();
        user.setNombreCuenta(vista.getNombreCuenta());
        user.setContraseña(vista.getContraseña());
        
        user = servicioLogin.getUsuario(user);
        
        mostrarVentanaUsuario();
    }
    
    private void mostrarVentanaUsuario(){
        if (user.getIdUsuario()!=null) {
            System.out.println("LOGGING...");
            switch (user.getTipoCuenta()) {
                case "ADMINISTRADOR":
                    vista.mostrarMensajeAdvertencia("PRONTO DISPONIBLE VISTA ADMINISTRADOR, C;");
                    break;
                case "RECEPCIONISTA":
                    //AQUI PROXIMAMENTE IRA LA CLASE RECEPCIONISTA -- SE VIENEN BASTANTES CAMBIOS
                    VistaRecepcion vistaRecep = new VistaRecepcion();

                    PresentadorRecepcion presentadorRecep = new PresentadorRecepcion(user,vistaRecep);
                    vistaRecep.setPresentador(presentadorRecep);

                    vistaRecep.iniciar();
                    vistaRecep.setNombreCuenta(user.getNombreCuenta());

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
