package Negocio;

import Negocio.IDBAccess;
import Persistencia.FactoriaDAO.IHospedajeDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaHospedajes implements IDBAccess{
    private IHospedajeDao dao = fabrica.getHospedajeDao();    
    
    public int getNroDiasDisponibles(String idHabitacion){
        return dao.getDiasDisponibles(idHabitacion);
    }
    
    public ArrayList<Hospedaje> cargarHospedajes(String filter){
        return dao.listado();
    }
   
    public Hospedaje buscar(String id){
        return dao.buscar(id);
    }

    public Hospedaje guardar(Hospedaje h) {
        return dao.registrar(h);
    }
    
}
