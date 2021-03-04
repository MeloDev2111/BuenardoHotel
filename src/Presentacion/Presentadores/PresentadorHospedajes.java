package Presentacion.Presentadores;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Hospedaje;
import Modelo.LogicaHospedajes;
import Presentacion.Vistas.VHospedajes;

/* @author MeloDev */
public class PresentadorHospedajes {
    private VHospedajes vista;
    private Hospedaje h;
    
    private Formateo format = new Formateo();
    private LogicaHospedajes servicio = new LogicaHospedajes();
    private Mensajes msg = new Mensajes();
    
    public PresentadorHospedajes(VHospedajes vista, Hospedaje hos) {
        this.vista = vista;
        this.h = hos;
    }
   
    public void configurarRolAdmin(){
        establecerTablaHospedajes();
    }
    
    public void configurarRolRecepConsultas(){
        establecerTablaHospedajes();
    }
    
    
    public void establecerTablaHospedajes(){
        vista.setListaHospedajes(
            format.formatoJtableHospedajes(
                servicio.cargarHospedajesFiltrados(
                        vista.getNombreCliente(), vista.getFiltroSeleccionado()
                )
            )
        );
    }

    public void EliminarHospedaje(){
        String idSelec = vista.getIdSeleccionado();
        h = servicio.buscar(idSelec);
        
        servicio.eliminarHospedaje(h);
    }

    public void mostrarVAgregarUsuario(){

    } 
        
    public void mostrarVModificarUsuarios(){

    }
    
}
