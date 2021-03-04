package Persistencia.FactoriaDAO;

import Modelo.Servicios.TipoHabitacion;
/*@author MelioDev*/
public interface ITipoHabitacionDao extends IDaoCrud<TipoHabitacion>{
    public abstract TipoHabitacion buscar(String idTipoHabitacion);
}
