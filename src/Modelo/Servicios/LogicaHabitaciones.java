package Modelo.Servicios;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IHabitacionDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaHabitaciones implements IDBAccess{
    private IHabitacionDao dao = fabrica.getHabitacionDao();    
    
    public ArrayList<Habitacion> cargarHabitaciones(String filter, String estado){
        return dao.filtrar(filter, estado);
    }
    
    public Habitacion buscar(String idHabitacion){
        return dao.buscar(idHabitacion);
    }

    public void guardar(Habitacion h) {
        dao.registrar(h);
    }

    public void eliminar(Habitacion habitacion) {
        dao.eliminar(habitacion);
    }

    public void modificar(Habitacion h) {
        dao.actualizar(h);
    }
   
    
}
