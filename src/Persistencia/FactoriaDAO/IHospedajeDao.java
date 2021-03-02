package Persistencia.FactoriaDAO;

import Negocio.Hospedaje;

/*@author MelioDev*/
public interface IHospedajeDao extends IDaoCrud<Hospedaje>{
    public Hospedaje buscar(String idHospedaje);
    public int getDiasDisponibles(String idHabitacion);
}
