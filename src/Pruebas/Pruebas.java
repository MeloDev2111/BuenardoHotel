/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Negocio.ServicioLogin;
import Negocio.Usuario;
import Persistencia.old.BuilderConexion;
import Persistencia.old.BuilderConexionCleverCloud;
import Persistencia.Conexion;
import java.util.List;


/**
 *
 * @author josue
 */
public class Pruebas {
    public static void main(String[] args) {
        BuilderConexion builder = new BuilderConexionCleverCloud();
        Conexion conexion = builder.crearConexion();
        
        System.out.println("HOLA");
        conexion.conectar();
        conexion.descripcion();        
         
//        BuilderConexion builder2 = new BuilderConexionMySql();
//        Conexion conexion2 = builder2.crearConexion();

//        System.out.println("HOLA");
//        conexion2.conectar();
//        conexion2.descripcion();
        
//        DAOUsuarios dao = new DAOUsuariosImpl();
////        
//        Usuario user = new Usuario("VASVASMAN", "1234", "Administrador");

//        
//        try {
//            dao.registrar(user);
//        } catch (Exception ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        user = new Usuario("VASVASMAN", "1234", "Recepcionista");
//        try {
//            dao.actualizar(user);
//        } catch (Exception ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            dao.eliminar(user);
//        } catch (Exception ex) {
//            System.out.println("ELIMINADO");
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        try {
//            List<Usuario> usuarios = dao.listar();
//            usuarios.forEach(usuario -> {
//                System.out.println(usuario.toString());
//            });
//        }catch (Exception e) {
//        }
    }
}
