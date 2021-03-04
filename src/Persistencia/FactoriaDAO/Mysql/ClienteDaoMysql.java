package Persistencia.FactoriaDAO.Mysql;

import Modelo.Cliente;
import Modelo.Servicios.EstadoDisponible;
import Modelo.Servicios.EstadoOcupado;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IHabitacionDao;
import Modelo.Servicios.Habitacion;
import Modelo.Servicios.TipoHabitacion;
import Persistencia.FactoriaDAO.IClienteDao;

public class ClienteDaoMysql implements IClienteDao{
    private Connection conexion;

    public ClienteDaoMysql(Connection con) {
        conexion=con;
    }

        @Override
    public Cliente buscar(String idCliente) {
        String sql ="select * from Clientes WHERE idCliente=? ";
        Cliente c = null;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idCliente);
            
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 

            while (rs.next()) {
                c = new Cliente();
                c.setIdCliente(rs.getString("idCliente"));
                c.setTipo(rs.getString("tipoCliente"));
                c.setApellidos(rs.getString("apellidosCliente"));
                c.setNombres(rs.getString("nombresCliente"));
                c.setTipoDocumento(rs.getString("tipoDocumento"));
                c.setNumDocumento(rs.getString("numDocumento"));    
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return c;
    }

    
    @Override
    public ArrayList<Cliente> filtrar(String palabraClave) {
        String sql ="select * from Clientes WHERE activo = true AND numDocumento like '%"+palabraClave+"%' ";
        ArrayList<Cliente> lista =null;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getString("idCliente"));
                c.setTipo(rs.getString("tipoCliente"));
                c.setApellidos(rs.getString("apellidosCliente"));
                c.setNombres(rs.getString("nombresCliente"));
                c.setTipoDocumento(rs.getString("tipoDocumento"));
                c.setNumDocumento(rs.getString("numDocumento"));
                
                lista.add(c);
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return lista;
    }    

    @Override
    public Cliente registrar(Cliente obj) {
        String sql ="INSERT INTO Clientes(tipoCliente,apellidosCliente,nombresCliente,tipoDocumento,numDocumento)"
                + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);//Codigo sql
            st.setString(1, obj.getTipo().name());// replace ? número 1 con el nombre
            st.setString(2, obj.getApellidos());
            st.setString(3, obj.getNombres());
            st.setString(4, obj.getTipoDocumento());
            st.setString(5, obj.getNumDocumento());
            st.executeUpdate();//Ejectura codigo sql cuando este tiene parametros
            
            st.close();
        } catch (Exception e) {
            System.out.println("error en registrar Clientes");
            System.out.println(e.getMessage());
        } 
        
        return obj; 
    }

    @Override
    public Cliente actualizar(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente eliminar(Cliente obj) {
        String sql ="UPDATE Clientes SET activo = false WHERE idCliente=?";
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, obj.getIdCliente());
            st.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return obj;
    }

    @Override
    public ArrayList<Cliente> listado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
