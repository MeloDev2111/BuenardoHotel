package Persistencia.FactoriaDAO;

import Modelo.Hospedaje;
import java.time.LocalDateTime;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IHospedajeDao extends IDaoCrud<Hospedaje>{
    public Hospedaje buscar(String idHospedaje);
    public abstract ArrayList<Hospedaje> filtrar(String palabraClave, String tipo);
    public int getDiasDisponibles(String idHabitacion);
    public int getDiasReservables(String idHabitacion, LocalDateTime fecha);
}
