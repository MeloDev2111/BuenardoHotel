package Modelo;

import Apoyo.Mensajes;
import Modelo.Login.Usuario;
import Persistencia.FactoriaDAO.IHospedajeDao;
import java.time.LocalDateTime;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaHospedajes implements IDBAccess{
    private IHospedajeDao dao = fabrica.getHospedajeDao();    
    private Mensajes msg = new Mensajes();
    
    public int getNroDiasDisponibles(String idHabitacion){
        return dao.getDiasDisponibles(idHabitacion);
    }
    
    public int getNroDiasReservables(String idHabitacion, LocalDateTime fecha){
        return dao.getDiasReservables(idHabitacion,fecha);
    }
    
    public ArrayList<Hospedaje> cargarHospedajesFiltrados(String filter, String tipo) {
        return dao.filtrar(filter, tipo);
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

    public boolean eliminarHospedaje(Hospedaje h) {
        if ("BAJA".equals(h.getEstado())) {
                msg.errorMsg("YA ESTA DE BAJA");
                return false;
        }
        
        if ("RESERVA".equals(h.getNombreTipo())) {
            System.out.println("IMPLEMENTAR");
            //sin dar de baja su usuario
            dao.eliminar(h);
        }else{
            dao.eliminar(h);
            System.out.println("IMPLEMENTAR DANDO DE BAJA EL USUARIO");
        }
        
        return true;
    }
    
}
