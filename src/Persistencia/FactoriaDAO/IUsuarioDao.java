package Persistencia.FactoriaDAO;

import Modelo.Login.Usuario;
import java.util.ArrayList;

/*@author MelioDev*/
public interface IUsuarioDao extends IDaoCrud<Usuario>{
    public abstract Usuario buscar(String idUsuario);
    public abstract Usuario buscarxNombre(String nombreUsuario);
    public abstract ArrayList<Usuario> filtrar(String palabraClave, boolean activo);
    public void habilitar(Usuario user);
}
