package Persistencia.FactoriaDAO;

import Negocio.Cliente;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IClienteDao extends IDaoCrud<Cliente>{
    public abstract ArrayList<Cliente> filtrar(String palabraClave);
}
