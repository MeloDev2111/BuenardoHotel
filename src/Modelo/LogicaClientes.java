package Modelo;

import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IClienteDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaClientes implements IDBAccess{
    private IClienteDao dao = fabrica.getClientesDao();    
    
    public ArrayList<Cliente> cargarClientes(String filter){
        return dao.filtrar(filter);
    }
   
    public Cliente buscar(String idCliente){
        return dao.buscar(idCliente);
    }

    public void guardar(Cliente c) {
        dao.registrar(c);
    }

    public void eliminar(Cliente cliente) {
        dao.eliminar(cliente);
    }
    
}
