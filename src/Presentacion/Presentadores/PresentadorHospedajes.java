package Presentacion.Presentadores;

import Apoyo.Formateo;
import Apoyo.Mensajes;
import Modelo.Hospedaje;
import Modelo.LogicaHospedajes;
import Presentacion.Vistas.VHospedajes;
import Presentacion.Vistas.VRegistroEntrada;
import Presentacion.Vistas.VRegistroReserva;

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
        establecerTablaHospedajes();
    }

    public void mostrarVRegistroEntrada() {
        VRegistroEntrada vistaRegE = new VRegistroEntrada();
        Hospedaje hospedaje = new Hospedaje();
        PresentadorRegistroEntrada pRE = new PresentadorRegistroEntrada(vistaRegE, hospedaje);
        vistaRegE.setPresentador(pRE);
        
        vistaRegE.iniciar();
    }

    public void mostrarVRegistroReserva() {
        VRegistroReserva vistaRegR = new VRegistroReserva();
        Hospedaje hospedaje = new Hospedaje();
        PresentadorRegistroReserva pRR = new PresentadorRegistroReserva(vistaRegR, hospedaje);
        vistaRegR.setPresentador(pRR);
        
        vistaRegR.iniciar();
    }



}
