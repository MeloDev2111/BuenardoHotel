/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;


import Negocio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class DAOUsuariosImpl implements DAOUsuarios {
    BuilderConexion builder = new BuilderConexionCleverCloud();
    Conexion conexion = builder.crearConexion();
    
    //Connection con = conexion.getConnection();//enlace dinamico?? // probando //FALLO
    //PORQUE? PQ es un atributo, y no lo actualizaba; perecita actualizar metodo get nomas

    @Override
    public void registrar(Usuario usuario) throws Exception{
        String sql ="INSERT INTO Usuarios(nombreCuenta,contraseña,tipoCuenta) VALUES(?,?,?)";
        try {
            this.conexion.conectar();
            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);//Codigo sql
            st.setString(1, usuario.getNombreCuenta());// replace ? número 1 con el nombre
            st.setString(2, usuario.getContraseña());
            st.setString(3, usuario.getTipoCuenta());
            st.executeUpdate();//Ejectura codigo sql cuando este tiene parametros
            
        } catch (Exception e) {
            System.out.println("error");
            System.out.println(e.getMessage());
        } finally{
            this.conexion.cerrar();
        }
    }

    @Override
    public void actualizar(Usuario usuario) throws Exception{
        String sql ="UPDATE Usuarios set nombreCuenta=?, contraseña=?,tipoCuenta=? where idUsuario=? ";
        try {
            this.conexion.conectar();
            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
            st.setString(1, usuario.getNombreCuenta());
            st.setString(2, usuario.getContraseña());
            st.setString(3, usuario.getTipoCuenta());
            st.setString(4, usuario.getIdUsuario());
            
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            this.conexion.cerrar();
        }
    }

    @Override
    public void eliminar(Usuario usuario) throws Exception{
        String sql ="DELETE FROM Usuarios WHERE idUsuario=?";
        try {
            this.conexion.conectar();
            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
            st.setString(1, usuario.getIdUsuario());
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            this.conexion.cerrar();
        }
    }

    @Override
    public Usuario buscarUsuarioByid(Usuario user) throws Exception {
        
        Usuario usuario = null;
        
        String sql ="SELECT * FROM Usuarios WHERE idUsuario = ?";
        try {
            this.conexion.conectar();
            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
            st.setString(1, user.getIdUsuario());
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            usuario = new Usuario();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getString("idUsuario"));
                usuario.setNombreCuenta(rs.getString("nombreCuenta"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTipoCuenta(rs.getString("tipoCuenta"));
            }
            
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally{
            this.conexion.cerrar();
        }
        
        return usuario;
    }
    
    @Override
    public Usuario buscarUsuarioByname(Usuario user) throws Exception {
        
        Usuario usuario = null;
        
        String sql ="SELECT * FROM Usuarios WHERE nombreCuenta=?";
        try {
            this.conexion.conectar();
            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
            st.setString(1, user.getNombreCuenta());
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO?
            usuario = new Usuario();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getString("idUsuario"));
                usuario.setNombreCuenta(rs.getString("nombreCuenta"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTipoCuenta(rs.getString("tipoCuenta"));
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            this.conexion.cerrar();
        }
        
        return usuario;
        
    }
    
    @Override
    public List<Usuario> listar() throws Exception{
        String sql ="SELECT * FROM Usuarios";
        List<Usuario> lista =null;
        try {
            this.conexion.conectar();
            PreparedStatement st = this.conexion.getConnection().prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getString("idUsuario"));//parametro del nombre de la columna en la bd
                usuario.setNombreCuenta(rs.getString("nombreCuenta"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTipoCuenta(rs.getString("tipoCuenta"));
                lista.add(usuario);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            this.conexion.cerrar();
        }
        
        return lista;
    }

}
