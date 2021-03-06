package Presentacion.Presentadores;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Login.LogicaUsuarios;
import Modelo.Login.Usuario;
import Presentacion.Vistas.VUsuarios;

/* @author MeloDev */
public class PresentadorUsuarios {
    private VUsuarios vista;
    private Usuario user;
    
    private Formateo format = new Formateo();
    private LogicaUsuarios servicio = new LogicaUsuarios();
    private Mensajes msg = new Mensajes();
    
    public PresentadorUsuarios(VUsuarios vista, Usuario user) {
        this.vista = vista;
        this.user = user;
    }
   
    
    public void establecerTablaUsuarios(){
        vista.setListaUsuarios(
            format.formatoJtableUsuarios(
                servicio.cargarListaUsuariosFiltrados(
                        vista.getNombreUsuario(), vista.getFiltroSeleccionado()
                )
            )
        );
    }

    public void deshabilitarUsuarios(){
        String idSelec = vista.getIdSeleccionado();            
        if (!user.getIdUsuario().equals(idSelec) ) {
            Usuario userConsultado = servicio.buscar(idSelec);    
            if (userConsultado.isActivo()) {
                servicio.deshabilitarUsuario(idSelec);
                establecerTablaUsuarios();
            }else{
              msg.errorMsg("EL USUARIO YA ESTA DESHABILITADO");  
            }
        }else{
            msg.errorMsg("EL USUARIO SELECCIONADO ES EL QUE ESTA USANDO "
                    + "ACTUALMENTE");
        }
        
    }
    public void habilitarUsuario() {
        String idSelec = vista.getIdSeleccionado();
        Usuario userConsultado = servicio.buscar(idSelec); 
        if (!userConsultado.isActivo()) {
            servicio.habilitarUsuario(idSelec);
            establecerTablaUsuarios();
        }else{
          msg.errorMsg("EL USUARIO YA ESTA HABILITADO");  
        }
    }
    
    public void mostrarVAgregarUsuario(){
        msg.advertenciaMsg("IN PROCESS", "PRONTO!!");
    } 
        
    public void mostrarVModificarUsuarios(){
        msg.advertenciaMsg("IN PROCESS", "PRONTO!!");
    }
}
