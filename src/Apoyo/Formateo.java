package Apoyo;

import Negocio.Cliente;
import Negocio.Login.Usuario;
import Negocio.Servicios.Habitacion;
import java.util.ArrayList;

/* @author MeloDev */
public class Formateo {
    
    public Object[][] formatoJtableHabitaciones(ArrayList<Habitacion> habitaciones){
        Object[][] H = new Object[habitaciones.size()][5];
        
        int i=0;
        for (Habitacion hab : habitaciones) {
            H[i][0]=hab.getIdHabitacion();
            H[i][1]=hab.getNombreTipo();
            H[i][2]=hab.getDescripcion();
            H[i][3]=hab.getPrecio();
            H[i][4]=hab.getNombreEstado();
            i++;
        }
       
        return H;
    }
    
    public Object[][] formatoJtableUsuarios(ArrayList<Usuario> usuarios){
        Object[][] U = new Object[usuarios.size()][5];
        
        int i=0;
        for (Usuario u : usuarios) {
            U[i][0]=u.getIdUsuario();
            U[i][1]=u.getNombreUsuario();
            U[i][2]=u.getNombreCuenta();
            U[i][3]=u.getTipoUsuario().name();
            U[i][4]=u.isActivo();
            i++;
        }
       
        return U;
    }

    public Object[][] formatoJtableClientes(ArrayList<Cliente> clientes) {
        Object[][] C = new Object[clientes.size()][5];
        
        int i=0;
        for (Cliente c : clientes) {
            C[i][0]=c.getIdCliente();
            C[i][1]=c.getApellidos()+c.getNombres();
            C[i][2]=c.getTipo().name();
            C[i][3]=c.getTipoDocumento();
            C[i][4]=c.getNumDocumento();
            i++;
        }
       
        return C;
    }
    
}
