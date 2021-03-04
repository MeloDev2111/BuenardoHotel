package Modelo.Servicios;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.ITipoHabitacionDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaTiposHabitacion implements IDBAccess{
    private ITipoHabitacionDao dao = fabrica.getTipoHabitacionDao();    
    
    public ArrayList<TipoHabitacion> cargarTiposHab(){
        return dao.listado();
    }
    
    public TipoHabitacion buscar(String idHabitacion){
        return dao.buscar(idHabitacion);
    }
   
    
}
