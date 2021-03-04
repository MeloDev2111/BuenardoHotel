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

    public void EliminarUsuarios(){
        String idSelec = vista.getIdSeleccionado();
        if (!user.getIdUsuario().equals(idSelec) ) {
            servicio.eliminarUsuario(idSelec);
        }
        
        msg.errorMsg("EL ID SELECCIONADO ES EL USADO ACTUALMENTE");
    }

    public void mostrarVAgregarUsuario(){

    } 
        
    public void mostrarVModificarUsuarios(){

    }
    
}
