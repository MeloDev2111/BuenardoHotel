package Persistencia.FactoriaDAO.Mysql;

import Negocio.Servicios.EstadoDisponible;
import Negocio.Servicios.EstadoOcupado;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IHabitacionDao;
import Negocio.Servicios.Habitacion;
import Negocio.Servicios.TipoHabitacion;

public class HabitacionDaoMysql implements IHabitacionDao{
    private Connection conexion;

    public HabitacionDaoMysql(Connection con) {
        conexion=con;
    }
    
    @Override
    public Habitacion buscar(String idHabitacion) {
        String sql ="SELECT * FROM Habitaciones WHERE idHabitacion=?";
        Habitacion h =null;
        
        TipoHabitacionDaoMysql daoTipo = new TipoHabitacionDaoMysql(conexion);
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idHabitacion);

            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                h = new Habitacion();
                h.setIdHabitacion(rs.getString("idHabitacion"));//parametro del nombre de la columna en la bd
                h.setDescripcion(rs.getString("descripcion"));
                h.setPrecio(rs.getDouble("precio"));
                //TiposEstado Estado = TiposEstado.valueOf(rs.getString("estado"));
                //switch(Estado) {
                h.setEstado(rs.getString("estado"));
                h.setTipo( daoTipo.buscar( rs.getString("idTipoHabitacion") ) );
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return h;
    }
    
    
    @Override
    public Habitacion registrar(Habitacion h) {
        String sql ="INSERT INTO Habitaciones(idTipoHabitacion,descripcion,precio,estado)"
                + " VALUES (?,?,?,?)";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);//Codigo sql
            st.setString(1, h.getTipo().getIdTipo());// replace ? número 1 con el nombre
            st.setString(2, h.getDescripcion());
            st.setString(3, ""+h.getPrecio());
            st.setString(4, h.getNombreEstado());
            st.executeUpdate();//Ejectura codigo sql cuando este tiene parametros
            
        } catch (Exception e) {
            System.out.println("error en registrar Habitacion");
            System.out.println(e.getMessage());
        } 
        
        return h;    
    }

    @Override
    public ArrayList<Habitacion> listado() {
        String sql ="SELECT * FROM vistaHabitaciones";
        ArrayList<Habitacion> lista =null;
        
        TipoHabitacionDaoMysql daoTipo = new TipoHabitacionDaoMysql(conexion);
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                Habitacion h = new Habitacion();
                h.setIdHabitacion(rs.getString("idHabitacion"));//parametro del nombre de la columna en la bd
                h.setDescripcion(rs.getString("descripcion"));
                h.setPrecio(rs.getDouble("precio"));
                //TiposEstado Estado = TiposEstado.valueOf(rs.getString("estado"));
                //switch(Estado) {
                h.setEstado(rs.getString("estado"));
                h.setTipo( daoTipo.buscar( rs.getString("idTipoHabitacion") ) );
                lista.add(h);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }

    @Override
    public Habitacion actualizar(Habitacion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Habitacion eliminar(Habitacion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Habitacion> filtrar(String palabraClave, String estado) {
        String sql ="SELECT * FROM vistaHabitaciones WHERE tipo like '%"+palabraClave+"%' ";
        if (estado!=null) {
            sql = sql +" AND estado = '"+estado+"'";
        }
        ArrayList<Habitacion> lista =null;
        
        TipoHabitacionDaoMysql daoTipo = new TipoHabitacionDaoMysql(conexion);
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 

            while (rs.next()) {
                Habitacion h = new Habitacion();
                h.setIdHabitacion(rs.getString("idHabitacion"));//parametro del nombre de la columna en la bd
                h.setDescripcion(rs.getString("descripcion"));
                h.setPrecio(rs.getDouble("precio"));
                //TiposEstado Estado = TiposEstado.valueOf(rs.getString("estado"));
                //switch(Estado) {
                switch(rs.getString("estado")) {
                    case "DISPONIBLE":
                        h.setEstado(new EstadoDisponible(h));
                        break;
                    case "OCUPADO":
                        h.setEstado(new EstadoOcupado(h));
                        break;
                    case "RESERVADO":
                        h.setEstado(new EstadoOcupado(h));
                        break;
                }
                h.setTipo( daoTipo.buscar( rs.getString("idTipoHabitacion") ) );
                lista.add(h);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }    


}
