package Negocio.Login;

import Negocio.IDBAccess;
import Negocio.Login.Usuario;
import Persistencia.FactoriaDAO.IUsuarioDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaUsuarios implements IDBAccess{
    private IUsuarioDao dao = fabrica.getUsuarioDao();

    public void eliminarUsuario(String idUsuario){
        Usuario user = new Usuario();
        user.setIdUsuario(idUsuario);
        dao.eliminar(user);
    }
    
    public ArrayList<Usuario> cargarListaUsuariosFiltrados(String filter, boolean activo){
        return dao.filtrar(filter, activo);                
    }

    public Usuario guardar(Usuario user) {
        user = dao.registrar(user);
        return user;
    }
    
}
