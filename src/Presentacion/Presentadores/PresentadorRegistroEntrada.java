package Presentacion.Presentadores;

import Negocio.Cliente;
import Negocio.Huesped;
import Negocio.Servicios.Habitacion;
import Presentacion.Vistas.VClientes;
import Presentacion.Vistas.VHabitaciones;
import Presentacion.Vistas.VRegistroEntrada;

/* @author MeloDev */
public class PresentadorRegistroEntrada {
    private VRegistroEntrada vista;
    
    private Huesped huesped;

    public PresentadorRegistroEntrada(VRegistroEntrada vista, Huesped huesped) {
        this.vista = vista;
        this.huesped = huesped;
    }
    
    public void establecerDatos(){
        System.out.println(huesped.toString());
//        vista.setInfoCliente(cliente.getNumDocumento()+"-"+cliente.getApellidos());
//        vista.setInfoHabitacion(habitacion.getNombreTipo());
    }

    public void mostrarVClientes() {
        VClientes vistaCli = new VClientes();
        PresentadorClientes pCli = new PresentadorClientes(vistaCli, huesped);
        vistaCli.setPresentador(pCli);
        pCli.configurarRolRecep();
        
        this.vista.cambiarVistaActual(vistaCli);
    }

    public void mostrarVHabitaciones() {
        VHabitaciones vistaHab = new VHabitaciones();
        PresentadorHabitacion pHab = new PresentadorHabitacion(vistaHab, huesped);
        vistaHab.setPresentador(pHab);
        pHab.configurarRolRecep();
        
        this.vista.cambiarVistaActual(vistaHab);
    }

    public void registrar() {
        establecerDatos();
//        System.out.println(habitacion.toString());
//        System.out.println(cliente.toString());
    }

}
