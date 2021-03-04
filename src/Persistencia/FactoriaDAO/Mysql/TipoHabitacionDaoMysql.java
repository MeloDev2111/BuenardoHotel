package Persistencia.FactoriaDAO.Mysql;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.Servicios.TipoHabitacion;
import Persistencia.FactoriaDAO.ITipoHabitacionDao;

public class TipoHabitacionDaoMysql implements ITipoHabitacionDao{
    private Connection conexion;

    public TipoHabitacionDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public TipoHabitacion buscar(String idTipoHabitacion) {
        String sql ="select * from TiposHabitacion WHERE idTipoHabitacion = ?";
        TipoHabitacion tipo = null;
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idTipoHabitacion);
            
            ResultSet rs = st.executeQuery(); 
            tipo = new TipoHabitacion();
            
            while (rs.next()) {
                tipo.setIdTipo(rs.getString("idTipoHabitacion"));
                tipo.setNombreTipo(rs.getString("tipo"));
                tipo.setPrecioDflt(rs.getDouble("precioDflt"));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return tipo;
    }

    @Override
    public TipoHabitacion registrar(TipoHabitacion obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TipoHabitacion actualizar(TipoHabitacion obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TipoHabitacion eliminar(TipoHabitacion obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<TipoHabitacion> listado() {
        String sql ="select * from TiposHabitacion";
        ArrayList<TipoHabitacion> lista =null;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                TipoHabitacion t = new TipoHabitacion();
                t.setIdTipo(rs.getString("idTipoHabitacion"));//parametro del nombre de la columna en la bd
                t.setNombreTipo(rs.getString("tipo"));
                t.setPrecioDflt(rs.getDouble("precioDflt"));
                lista.add(t);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }
    


}
