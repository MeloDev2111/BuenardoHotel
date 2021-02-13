package Persistencia.FactoriaDAO;

import Negocio.Habitacion;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IHabitacionDao extends IDaoCrud<Habitacion>{
    public abstract ArrayList<Habitacion> filtrar(String palabraClave);
}
