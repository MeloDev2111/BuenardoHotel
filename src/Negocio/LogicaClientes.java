package Negocio;

import Negocio.IDBAccess;
import Persistencia.FactoriaDAO.IClienteDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaClientes implements IDBAccess{
    private IClienteDao dao = fabrica.getClientesDao();    
    
    public ArrayList<Cliente> cargarClientes(String filter){
        return dao.filtrar(filter);
    }
   
    
}
