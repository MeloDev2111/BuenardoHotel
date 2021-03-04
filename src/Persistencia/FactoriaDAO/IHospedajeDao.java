package Persistencia.FactoriaDAO;

import Modelo.Hospedaje;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IHospedajeDao extends IDaoCrud<Hospedaje>{
    public Hospedaje buscar(String idHospedaje);
    public abstract ArrayList<Hospedaje> filtrar(String palabraClave, String tipo);
    public int getDiasDisponibles(String idHabitacion);
}
