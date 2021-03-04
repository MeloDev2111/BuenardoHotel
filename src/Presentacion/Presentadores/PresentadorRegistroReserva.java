package Presentacion.Presentadores;

import Apoyo.Mensajes;
import Modelo.Hospedaje;
import Modelo.LogicaHospedajes;
import Presentacion.Vistas.VClientes;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VRegistroEntrada;
import Presentacion.Vistas.VRegistroReserva;

/* @author MeloDev */
public class PresentadorRegistroReserva {
    private VRegistroReserva vista;
    private Hospedaje hospedaje;
    
    private Mensajes msg = new Mensajes();
    
    public PresentadorRegistroReserva(VRegistroReserva vista, Hospedaje hospedaje) {
        this.vista = vista;
        this.hospedaje = hospedaje;
    }
    
    public void establecerDatos(){
        if (hospedaje.getCliente()!=null) {
            String tipo = hospedaje.getCliente().getTipo().name();
            String nombreCliente = hospedaje.getCliente().getApellidos();
            if ("NATURAL".equals(tipo)) {
                nombreCliente += " "+hospedaje.getCliente().getNombres();
            }
            String documento = hospedaje.getCliente().getNumDocumento();
            
            vista.setInfoCliente(nombreCliente,tipo,documento);
        }
        
        if (hospedaje.getHabitacion()!=null) {
            String tipo = hospedaje.getHabitacion().getNombreTipo();
            String precio = ""+hospedaje.getHabitacion().getPrecio();
            String desc = hospedaje.getHabitacion().getDescripcion();
            
            vista.setInfoHabitacion(tipo,precio,desc);
        }
        
        //calcular dias en determinada fecha
        //            LogicaHospedajes logiHosp = new LogicaHospedajes();
//            String id = hospedaje.getHabitacion().getIdHabitacion();
//            vista.setDiasElegibles(logiHosp.getNroDiasDisponibles(id));

    }

    public void mostrarVClientes() {
        VClientes vistaCli = new VClientes();
        PresentadorClientes pCli = new PresentadorClientes(vistaCli, hospedaje);
        vistaCli.setPresentador(pCli);
        pCli.configurarRolRecep();
        
        vistaCli.iniciar();
        
        this.vista.cerrar();
        
        //this.vista.cambiarVistaActual(vistaCli);
    }

    public boolean mostrarVHabitaciones() {
        if (true) {
            msg.errorMsg("FECHA NO SELECCIONADA");
            return false;
        }
        
        VHabitaciones vistaHab = new VHabitaciones();
        PresentadorHabitacion pHab = new PresentadorHabitacion(vistaHab, hospedaje);
        vistaHab.setPresentador(pHab);
        pHab.configurarRolRecepRegistros();
        //Pasarle la fecha seleccionada
        vistaHab.iniciar();
        
        this.vista.cerrar();
        return true;
        //this.vista.cambiarVistaActual(vistaHab);
    }

    public boolean registrar() {
//        if (hospedaje.getCliente()==null) {
//            msg.errorMsg("CLIENTE NO SELECCIONADO");
//            return false;
//        }
//        
//        if (hospedaje.getHabitacion()==null) {
//            msg.errorMsg("HABITACION NO SELECCIONADA");
//            return false;
//        }
        
        System.out.println(vista.getFechaReserva().toString());
        
//        hospedaje.setNroDiasEstancia(vista.getNumDiasElegidos());
//        hospedaje.getHabitacion().agregarHuesped(hospedaje);
        return true;
    }

}
