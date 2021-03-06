package Modelo.Login;

import Modelo.IDBAccess;
import Modelo.Login.Usuario;
import Persistencia.FactoriaDAO.IUsuarioDao;
import java.util.ArrayList;

/* @author MeloDev */
public class LogicaUsuarios implements IDBAccess{
    private IUsuarioDao dao = fabrica.getUsuarioDao();

    public void deshabilitarUsuario(String idUsuario){
        Usuario user = new Usuario();
        user.setIdUsuario(idUsuario);
        dao.eliminar(user);
    }
    
    public void habilitarUsuario(String idUsuario) {
        Usuario user = new Usuario();
        user.setIdUsuario(idUsuario);
        dao.habilitar(user);
    }
    
    public ArrayList<Usuario> cargarListaUsuariosFiltrados(String filter, boolean activo){
        return dao.filtrar(filter, activo);                
    }

    public Usuario guardar(Usuario user) {
        user = dao.registrar(user);
        return user;
    }

    public Usuario buscar(String idSelec) {
        return dao.buscar(idSelec);
    }
    
}
