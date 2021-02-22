package Persistencia.FactoriaDAO;

import Negocio.Servicios.TipoHabitacion;
/*@author MelioDev*/
public interface ITipoHabitacionDao extends IDaoCrud<TipoHabitacion>{
    public abstract TipoHabitacion buscar(String idTipoHabitacion);
}
