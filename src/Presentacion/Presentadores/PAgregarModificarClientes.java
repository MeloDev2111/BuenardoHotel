package Presentacion.Presentadores;

import Apoyo.Formateo;
import Modelo.Cliente;
import Modelo.LogicaClientes;
import Modelo.TiposCliente;
import Presentacion.Vistas.VAgregarModificarCliente;

/* @author MeloDev */
public class PAgregarModificarClientes {
    private VAgregarModificarCliente vista;
    private Cliente c;
    
    private LogicaClientes logica = new LogicaClientes();
    private Formateo format = new Formateo();

    public PAgregarModificarClientes(VAgregarModificarCliente vista) {
        this.vista = vista;
        c = new Cliente();
    }
    
    public PAgregarModificarClientes(VAgregarModificarCliente vista, Cliente c) {
        this.vista = vista;
        this.c = c;
    }
    
    
    public void guardarCliente(){
        c.setApellidos(vista.getApellidos());
        c.setNombres(vista.getNombres());
        c.setTipo(vista.getTipoCliSeleccionado());
        c.setTipoDocumento(vista.getTipoDocumento());
        c.setNumDocumento(vista.getNumDocumento());
        logica.guardar(c);
        this.vista.cerrar();
    }
    
    public void modificarCliente() {
        c.setApellidos(vista.getApellidos());
        c.setNombres(vista.getNombres());
        c.setTipo(vista.getTipoCliSeleccionado());
        c.setTipoDocumento(vista.getTipoDocumento());
        c.setNumDocumento(vista.getNumDocumento());
        
        logica.modificar(c);
        this.vista.cerrar();
    }
    public void cargarDatos(){
        if (c!=null) {
            vista.setTipoCliente(c.getTipo().name());
            vista.setApellidos(c.getApellidos());
            vista.setNombres(c.getNombres());
            establecerDatosTipoDocumento();
            vista.setNumDocumento(c.getNumDocumento());
        }
    }
    
    public void cargarListadoTipos(){
        vista.mostrarListaTiposCliente(
            format.formatoJtableTiposCli(
                    TiposCliente.values()
            )
        );
    }
    
    public void establecerDatosTipoDocumento() {
        TiposCliente tipo = TiposCliente.valueOf(vista.getTipoCliSeleccionado());
        vista.setTipoDocumento(tipo.getTipoDoc());
        switch (tipo) {
            case JURIDICO:
                vista.POVClienteJuridico();
                break;
            case NATURAL:
                vista.POVClienteNatural();
                break;
            default:
                throw new AssertionError();
        }
    }

    
}
