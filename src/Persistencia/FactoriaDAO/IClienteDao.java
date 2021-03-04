package Persistencia.FactoriaDAO;

import Modelo.Cliente;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IClienteDao extends IDaoCrud<Cliente>{
    public abstract ArrayList<Cliente> filtrar(String palabraClave);
    public abstract Cliente buscar(String idCliente);

}
