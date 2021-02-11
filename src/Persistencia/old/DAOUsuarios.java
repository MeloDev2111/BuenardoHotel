/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.old;

import Negocio.Usuario;
import java.util.List;

/**
 *
 * @author josue
 */
public interface DAOUsuarios {
    //CRUD(CREATE-READ-UPDATE-DELETE)
    public void registrar(Usuario usuario) throws Exception;
    public List<Usuario> listar() throws Exception;
    public void actualizar(Usuario usuario) throws Exception;
    public void eliminar(Usuario usuario) throws Exception;
    public Usuario buscarUsuarioByid(Usuario user) throws Exception;
    public Usuario buscarUsuarioByname(Usuario user) throws Exception;
}
