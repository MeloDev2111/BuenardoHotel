package Presentacion.Presentadores;

import Apoyo.Mensajes;
import Modelo.Hospedaje;
import Modelo.LogicaHospedajes;
import Presentacion.Vistas.VAgregarModificarCliente;
import Presentacion.Vistas.VClientes;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VRegistroEntrada;

/* @author MeloDev */
public class PresentadorRegistroEntrada {
    private VRegistroEntrada vista;
    private Hospedaje hospedaje;
    
    private Mensajes msg = new Mensajes();
    
    public PresentadorRegistroEntrada(VRegistroEntrada vista, Hospedaje huesped) {
        this.vista = vista;
        this.hospedaje = huesped;
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
            
            LogicaHospedajes logiHosp = new LogicaHospedajes();
            String id = hospedaje.getHabitacion().getIdHabitacion();
            vista.setDiasElegibles(logiHosp.getNroDiasDisponibles(id));
        }
    }

    public void mostrarVClientes() {
        VClientes vistaCli = new VClientes();
        PresentadorClientes pCli = new PresentadorClientes(vistaCli, hospedaje);
        vistaCli.setPresentador(pCli);
        pCli.configurarRolRecepRE();
        
        vistaCli.iniciar();
        
        this.vista.cerrar();
        
        //this.vista.cambiarVistaActual(vistaCli);
    }

    public void mostrarVHabitaciones() {
        VHabitaciones vistaHab = new VHabitaciones();
        PresentadorHabitacion pHab = new PresentadorHabitacion(vistaHab, hospedaje);
        vistaHab.setPresentador(pHab);
        pHab.configurarRolRecepRegistroEntrada();
        
        vistaHab.iniciar();
        
        this.vista.cerrar();
        
        //this.vista.cambiarVistaActual(vistaHab);
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
        hospedaje.getHabitacion().agregarAlquiler(hospedaje);
        return true;
    }

}
