package Persistencia.FactoriaDAO.Mysql;

import Negocio.Cliente;
import Negocio.Servicios.EstadoDisponible;
import Negocio.Servicios.EstadoOcupado;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IHabitacionDao;
import Negocio.Servicios.Habitacion;
import Negocio.Servicios.TipoHabitacion;
import Persistencia.FactoriaDAO.IClienteDao;

public class ClienteDaoMysql implements IClienteDao{
    private Connection conexion;

    public ClienteDaoMysql(Connection con) {
        conexion=con;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente actualizar(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Cliente eliminar(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Cliente> listado() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
