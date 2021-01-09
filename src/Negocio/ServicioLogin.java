package Negocio;

import Persistencia.DAOUsuarios;
import Persistencia.DAOUsuariosImpl;
import javax.swing.JOptionPane;

public class ServicioLogin {
    DAOUsuarios dao = new DAOUsuariosImpl();
    Usuario userBD;
    
    public Usuario getUsuario(Usuario usuario){
        userBD=new Usuario();
        try {
            userBD = dao.buscarUsuarioByname(usuario);
        } catch (Exception ex) {
            System.out.println("ERROR en VerificarContraseña");
        }
        
        if (verificarExistencia(usuario)) {
            if (verificarContraseña(usuario)) {
                return userBD;
            }else{
                mostrarMensajeError("CONTRASEÑA INCORRECTA!");
            }
        }else{
            mostrarMensajeError("ESTA CUENTA NO EXISTE!");
        }
        
        userBD=new Usuario();    
        return userBD;
    }
    
    private boolean verificarExistencia(Usuario usuario){
        return !(userBD.getIdUsuario()==null);          
    }
    
    private boolean verificarContraseña(Usuario usuario){
        return userBD.getContraseña().equals(usuario.getContraseña());
    }
    
    private void mostrarMensajeError(String msg){
        JOptionPane.showMessageDialog(null,
                msg,
                "ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
