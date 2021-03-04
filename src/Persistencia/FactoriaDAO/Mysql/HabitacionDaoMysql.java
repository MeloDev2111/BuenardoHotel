package Persistencia.FactoriaDAO.Mysql;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IHabitacionDao;
import Modelo.Servicios.Habitacion;

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
            
            st.close();
        } catch (Exception e) {
            System.out.println("error en registrar Habitacion");
            System.out.println(e.getMessage());
        } 
        
        return h;    
    }

    @Override
    public ArrayList<Habitacion> listado() {
        String sql ="SELECT * FROM Habitaciones where activo = true";
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
        String sql ="Update Habitaciones set "
                + "idTipoHabitacion = ?, descripcion= ?, precio=? "
                + "where idHabitacion = ?";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, obj.getTipo().getIdTipo());
            st.setString(2, obj.getDescripcion());
            st.setString(3, ""+obj.getPrecio());
            st.setString(4, obj.getIdHabitacion());
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return obj;
    }

    @Override
    public Habitacion eliminar(Habitacion obj) {
        String sql ="UPDATE Habitaciones SET activo = false WHERE idHabitacion=?";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, obj.getIdHabitacion());
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return obj;
    }

    @Override
    public ArrayList<Habitacion> filtrar(String palabraClave, String estado) {
        ArrayList<Habitacion> lista = listado();
        ArrayList<Habitacion> listaFiltrada = new ArrayList();
        
        palabraClave = palabraClave.toUpperCase();
        estado = estado.toUpperCase();
            
        for (Habitacion h : lista) {
            String tipo = h.getNombreTipo().toUpperCase();
            String estadoHab = h.getNombreEstado().toUpperCase();
                        
            if (tipo.contains(palabraClave) && estadoHab.contains(estado)) {
                listaFiltrada.add(h);
            }
        }
        
        return listaFiltrada;
    }    


}
