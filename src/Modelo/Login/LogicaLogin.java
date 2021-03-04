package Modelo.Login;

import Apoyo.Mensajes;
import Modelo.IDBAccess;
import Persistencia.FactoriaDAO.IUsuarioDao;

public class LogicaLogin implements IDBAccess{
    IUsuarioDao dao = fabrica.getUsuarioDao();
    Mensajes msg = new Mensajes();
    Usuario userBD;
    
    public Usuario iniciarSesion(Usuario usuario){
              
        if (!existe(usuario)) {
            msg.errorMsg("ESTA CUENTA NO EXISTE!");
            return usuario;
        }
        
        if (!verificarContraseña(usuario)) {
            msg.errorMsg("CONTRASEÑA INCORRECTA!");
            return usuario;
        }
        
        //REVISAR SI ESTA ACTIVO(HUESPEDES DESALOJADOS)
        
        if (!userBD.isActivo()) {
            msg.errorMsg("USUARIO DESHABILITADO");    
            return usuario; 
        }
        
        return userBD;
    }
    
    private boolean existe(Usuario usuario){
        userBD = dao.buscarxNombre(usuario.getNombreCuenta());
        
        return userBD.getIdUsuario() != null;
    }
    
    private boolean verificarContraseña(Usuario usuario){
        return userBD.getContraseña().equals(usuario.getContraseña());
    }

}
