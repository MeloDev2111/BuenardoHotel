package Negocio;

import Persistencia.DAOUsuarios;
import Persistencia.DAOUsuariosImpl;

public class ServicioLogin {
    DAOUsuarios dao = new DAOUsuariosImpl();
    
    public boolean verificarExistencia(Usuario usuario){
        Usuario userBD=null;
        try {
            userBD = dao.buscarUsuarioByname(usuario);
        } catch (Exception ex) {
            System.out.println("ERROR en VerificarExistencia");
        }
        
        return !(userBD.getIdUsuario()==null);          
    }
    
    public boolean verificarContraseña(Usuario usuario){
        Usuario userBD=null;
        
        try {
            userBD = dao.buscarUsuarioByname(usuario);
        } catch (Exception ex) {
            System.out.println("ERROR en VerificarContraseña");
        }
            
            
        return userBD.getContraseña().equals(usuario.getContraseña());
    }
    
    public Usuario getUsuario(Usuario usuario){
        Usuario userBD=null;
        
        try {
            userBD = dao.buscarUsuarioByname(usuario);
        } catch (Exception ex) {
            System.out.println("ERROR en VerificarContraseña");
        }
            
            
        return userBD;
    }
    
}
