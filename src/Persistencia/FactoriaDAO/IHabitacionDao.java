package Persistencia.FactoriaDAO;

import Modelo.Servicios.Habitacion;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IHabitacionDao extends IDaoCrud<Habitacion>{
    public abstract ArrayList<Habitacion> filtrar(String palabraClave, String estado);
    public abstract Habitacion buscar(String idHabitacion);

}
