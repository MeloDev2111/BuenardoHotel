package Presentacion.Presentadores;

import Apoyo.Mensajes;
import Modelo.Hospedaje;
import Modelo.LogicaHospedajes;
import Presentacion.Vistas.VAgregarModificarCliente;
import Presentacion.Vistas.VClientes;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VRegistroEntrada;
import Presentacion.Vistas.VRegistroReserva;

/* @author MeloDev */
public class PresentadorRegistroReserva {
    private VRegistroReserva vista;
    private Hospedaje hospedaje;
    
    private Mensajes msg = new Mensajes();
    private LogicaHospedajes logiHosp = new LogicaHospedajes();
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
                    //calcular dias en determinada fecha
            String id = hospedaje.getHabitacion().getIdHabitacion();
            
            vista.setFechaReserva(hospedaje.getfHEntrada());
            
            vista.setDiasElegibles(
                logiHosp.getNroDiasReservables( id, vista.getFechaReserva() )
            );

        }
    }

    public void mostrarVClientes() {
        VClientes vistaCli = new VClientes();
        PresentadorClientes pCli = new PresentadorClientes(vistaCli, hospedaje);
        vistaCli.setPresentador(pCli);
        pCli.configurarRolRecepRR();
        
        vistaCli.iniciar();
        
        this.vista.cerrar();
        
        //this.vista.cambiarVistaActual(vistaCli);
    }

    public void mostrarVHabitaciones() {   
        
        hospedaje.setfHEntrada(this.vista.getFechaReserva());
        VHabitaciones vistaHab = new VHabitaciones();
        PresentadorHabitacion pHab = new PresentadorHabitacion(vistaHab, hospedaje);
        vistaHab.setPresentador(pHab);
        vistaHab.setFechaReserva(hospedaje.getfHEntrada());
        
        pHab.configurarRolRecepRegistroReserva();
        //Pasarle la fecha seleccionada
        
        vistaHab.setFechaReserva( hospedaje.getfHEntrada() );
        vistaHab.iniciar();
        
        this.vista.cerrar();
        //this.vista.cambiarVistaActual(vistaHab);
    }

    public boolean registrar() {
        if (hospedaje.getCliente()==null) {
            msg.errorMsg("CLIENTE NO SELECCIONADO");
            return false;
        }
        
        if (hospedaje.getHabitacion()==null) {
            msg.errorMsg("HABITACION NO SELECCIONADA");
            return false;
        }
        
        hospedaje.setNroDiasEstancia(vista.getNumDiasElegidos());
        System.out.println(hospedaje.toString());
        
        hospedaje.getHabitacion().agregarReserva(hospedaje);
        return true;
    }

    public void mostrarVAgregarCliente() {
        VAgregarModificarCliente vAddCliente = new VAgregarModificarCliente();
        PAgregarModificarClientes pAddCliente = new PAgregarModificarClientes(vAddCliente);
        vAddCliente.setPresentador(pAddCliente);
        vAddCliente.deshabilitarBotones();
        vAddCliente.habilitarBtnsAdminAgregar();
        pAddCliente.cargarListadoTipos();
        pAddCliente.establecerDatosTipoDocumento();
        
        vAddCliente.iniciar();
    }

}
