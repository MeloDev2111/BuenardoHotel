package Presentacion.Presentadores;

import Apoyo.Formateo;
import Modelo.Cliente;
import Modelo.Hospedaje;
import Modelo.LogicaClientes;
import Presentacion.Vistas.VAgregarModificarCliente;
import Presentacion.Vistas.VClientes;
import Presentacion.Vistas.VRegistroEntrada;
import Presentacion.Vistas.VRegistroReserva;

/* @author MeloDev */
public class PresentadorClientes {
    private VClientes vista;
    private Cliente cliente;
    
    private Formateo format = new Formateo();
    private LogicaClientes logiClientes = new LogicaClientes();
    private Hospedaje hospedaje;
    
    public PresentadorClientes(VClientes vista, Cliente cliente) {
        this.vista = vista;
        this.cliente = cliente;
    }
    
    public PresentadorClientes(VClientes vista, Hospedaje huesped) {
        this.vista = vista;
        this.hospedaje = huesped;
    }
    
    public void configurarRolAdmin(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsAdmin();
        establecerTablaClientes();
    }
    
    public void configurarRolRecepRE(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecepRE();
        establecerTablaClientes();
    }
    
    public void configurarRolRecepRR(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecepRR();
        establecerTablaClientes();
    }
    
    public void establecerTablaClientes() {
        vista.setTablaClientes(
            format.formatoJtableClientes(
                logiClientes.cargarClientes(vista.getNumDocumento())
            )
        );
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
        
        //terminando el Agregar
        establecerTablaClientes();
    }

    public void mostrarVModificarCliente() {
        cliente = logiClientes.buscar(vista.getIdSeleccionado());
        VAgregarModificarCliente vModCli = new VAgregarModificarCliente();
        PAgregarModificarClientes pModCli = 
                new PAgregarModificarClientes(vModCli,cliente);
        vModCli.setPresentador(pModCli);
        vModCli.deshabilitarBotones();
        vModCli.habilitarBtnsAdminModificar();
        pModCli.cargarListadoTipos();
        pModCli.establecerDatosTipoDocumento();
        pModCli.cargarDatos();
        
        vModCli.iniciar();
        
        //terminando el modificar
        establecerTablaClientes();
    }

    public void EliminarCliente() {
        cliente.setIdCliente(vista.getIdSeleccionado());
        logiClientes.eliminar(cliente);
        establecerTablaClientes();
    }

    public void elegirClienteRE() {
        cliente = logiClientes.buscar(vista.getIdSeleccionado());
        System.out.println(cliente.toString());
        
        hospedaje.setCliente(cliente);
        volverVRegistroEntrada();
    }
    
    public void elegirClienteRR() {
        cliente = logiClientes.buscar(vista.getIdSeleccionado());
        System.out.println(cliente.toString());
        
        hospedaje.setCliente(cliente);
        volverVRegistroReserva();
    }
    

    public void volverVRegistroEntrada() {
        VRegistroEntrada vistaReg = new VRegistroEntrada();
        PresentadorRegistroEntrada pReg = new PresentadorRegistroEntrada(vistaReg, hospedaje);
        vistaReg.setPresentador(pReg);
        
        vistaReg.iniciar();
        this.vista.cerrar();
    }
    
    public void volverVRegistroReserva() {
        VRegistroReserva vistaReg = new VRegistroReserva();
        PresentadorRegistroReserva pReg = new PresentadorRegistroReserva(vistaReg, hospedaje);
        vistaReg.setPresentador(pReg);
        
        vistaReg.iniciar();
        this.vista.cerrar();
    }
    
}
