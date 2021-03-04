package Presentacion.Presentadores;

import Apoyo.Formateo;
import Modelo.Cliente;
import Modelo.Hospedaje;
import Modelo.LogicaClientes;
import Presentacion.Vistas.VAgregarModificarCliente;
import Presentacion.Vistas.VClientes;
import Presentacion.Vistas.VRegistroEntrada;

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
    
    public void configurarRolRecep(){
        vista.deshabilitarBotones();
        vista.habilitarBtnsRecep();
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
        
        vAddCliente.iniciar();
    }

    public void mostrarVModificarCliente() {
        cliente = logiClientes.buscar(vista.getIdSeleccionado());
        VAgregarModificarCliente vAddCli = new VAgregarModificarCliente();
        PAgregarModificarClientes pAddCli = 
                new PAgregarModificarClientes(vAddCli,cliente);
        vAddCli.setPresentador(pAddCli);
        vAddCli.deshabilitarBotones();
        vAddCli.habilitarBtnsAdminModificar();
        
        vAddCli.iniciar();
        pAddCli.cargarDatos();
    }

    public void EliminarCliente() {
        cliente.setIdCliente(vista.getIdSeleccionado());
        logiClientes.eliminar(cliente);
        establecerTablaClientes();
    }

    public void elegirCliente() {
        cliente = logiClientes.buscar(vista.getIdSeleccionado());
        System.out.println(cliente.toString());
        
        hospedaje.setCliente(cliente);
        volverVRegistro();
    }

    public void volverVRegistro() {
        VRegistroEntrada vistaReg = new VRegistroEntrada();
        PresentadorRegistroEntrada pReg = new PresentadorRegistroEntrada(vistaReg, hospedaje);
        vistaReg.setPresentador(pReg);
        
        vistaReg.iniciar();
        this.vista.cerrar();
    }
    
}
