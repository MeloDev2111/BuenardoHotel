package Presentacion.Presentadores;

import Apoyo.Formateo;
import Negocio.Cliente;
import Negocio.Huesped;
import Negocio.LogicaClientes;
import Presentacion.Vistas.VClientes;

/* @author MeloDev */
public class PresentadorClientes {
    private VClientes vista;
    private Cliente cliente;
    
    private Formateo format = new Formateo();
    private LogicaClientes logiClientes = new LogicaClientes();
    private Huesped huesped;
    
    public PresentadorClientes(VClientes vista, Cliente cliente) {
        this.vista = vista;
        this.cliente = cliente;
    }
    
    public PresentadorClientes(VClientes vista, Huesped huesped) {
        this.vista = vista;
        this.huesped = huesped;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mostrarVModificarCliente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void EliminarCliente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void elegirCliente() {
        cliente = logiClientes.buscar(vista.getIdSeleccionado());
        System.out.println(cliente.toString());
        huesped.setCliente(cliente);
    }

    public void volverVRecep() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
