package Negocio;

import Persistencia.FactoriaDAO.IHabitacionDao;
import java.util.ArrayList;

/* @author MeloDev */
public class ServicioHabitaciones implements IBDAccess{
    IHabitacionDao dao = fabrica.getHabitacionDao();
    
    public Object[][] cargarHabitaciones(){
        ArrayList<Habitacion> habitaciones = dao.listado();
        Object[][] H = new Object[habitaciones.size()][5];
        
        int i=0;
        for (Habitacion hab : habitaciones) {
            H[i][0]=hab.getIdHabitacion();
            H[i][1]=hab.getTipo();
            H[i][2]=hab.getDescripcion();
            H[i][3]=hab.getPrecio();
            H[i][4]=hab.getNombreEstado();
            i++;
        }
        
        return H;
    }
    
}
