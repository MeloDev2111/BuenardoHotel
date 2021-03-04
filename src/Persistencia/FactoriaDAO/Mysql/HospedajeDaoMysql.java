package Persistencia.FactoriaDAO.Mysql;

import Apoyo.Formateo;
import Modelo.Hospedaje;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IHospedajeDao;
import java.time.LocalDateTime;

public class HospedajeDaoMysql implements IHospedajeDao{
    private Connection conexion;
    private Formateo format = new Formateo();
    
    public HospedajeDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public int getDiasDisponibles(String idHabitacion) {
        String sql ="call getDiasDisponibles(?,@dias)";
        String sql2="select @dias";
        int dias=0;
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, idHabitacion);

            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            st = this.conexion.prepareStatement(sql2);
            rs = st.executeQuery();
            while (rs.next()) {
                dias = rs.getInt("@dias");
            }
            rs.close();
            st.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        
        return dias;
    }
    
    @Override
    public Hospedaje buscar(String idHospedaje) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

    @Override
    public Hospedaje registrar(Hospedaje obj) {
        switch (obj.getTipo()) {
            case ALQUILER:
                registrarHospedajeAlquiler(obj);
                break;
            case RESERVA:
                registrarHospedajeReserva(obj);
                break;
            default:
                System.out.println("Tipo de Hospedaje no enumerado en la bd");
                throw new AssertionError();
        }
        return obj;
    }
    
    public Hospedaje registrarHospedajeAlquiler(Hospedaje obj){
        String sql ="call registrarHospedajeAlquiler(?, ?, ?, ?)";
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, obj.getCliente().getIdCliente());
            st.setString(2, obj.getHabitacion().getIdHabitacion());
            st.setInt(3, obj.getNroDiasEstancia());
            st.setString(4, obj.getUser().getIdUsuario());

            st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            st.close();
            
        } catch (Exception e) {
            System.out.println("Error en Registrar Hospedaje");
            System.out.println(e.getMessage());
        } 
        
        return obj;
    }
    
    public Hospedaje registrarHospedajeReserva(Hospedaje obj){
        String sql ="call registrarHospedajeReserva(?, ?, ?,?)";
        
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            st.setString(1, obj.getCliente().getIdCliente());
            st.setString(2, obj.getHabitacion().getIdHabitacion());
            LocalDateTime fHEntradaBD = format.formatoUTC_0( obj.getfHEntrada() );
            st.setString(3, format.DateTime_to_timeStamp(fHEntradaBD));
            st.setInt(4, obj.getNroDiasEstancia());

            st.executeQuery(); 
            
            st.close();
            
        } catch (Exception e) {
            System.out.println("Error en Registrar Reserva");
            System.out.println(e.getMessage());
        } 
        
        return obj;
    }
    
    @Override
    public ArrayList<Hospedaje> filtrar(String palabraClave, String tipo) {
        ArrayList<Hospedaje> lista = listado();
        
        ArrayList<Hospedaje> listaFiltrada = new ArrayList();
        palabraClave = palabraClave.toUpperCase();
        tipo = tipo.toUpperCase();
            
        for (Hospedaje h : lista) {
            String nombreCliente = h.getCliente().getApellidos()+" "+h.getCliente().getNombres();
            nombreCliente = nombreCliente.toUpperCase();
            String tipoHab = h.getNombreTipo();
            
            if (nombreCliente.contains(palabraClave) && tipoHab.contains(tipo)) {
                listaFiltrada.add(h);
            }
        }
        
        
        return listaFiltrada;
        
    }

    @Override
    public ArrayList<Hospedaje> listado() {
        String sql ="SELECT *,datediff(fechaSalida,fechaEntrada) as diasEstancia"
                + " FROM Hospedajes";
        ArrayList<Hospedaje> lista =null;
        
        HabitacionDaoMysql daoHab = new HabitacionDaoMysql(conexion);
        ClienteDaoMysql daoCli = new ClienteDaoMysql(conexion);
        UsuarioDaoMysql daoUser = new UsuarioDaoMysql(conexion);
        try {
            PreparedStatement st = this.conexion.prepareStatement(sql);
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery(); //ejecutar el codigo sql ya sea ddl o dml??//ITERATOR? QUE ES ESTO? 
            
            while (rs.next()) {
                Hospedaje h = new Hospedaje();
                h.setIdHospedaje( rs.getString("idHospedaje") );
                h.setTipo(rs.getString("tipo"));
                h.setCliente( daoCli.buscar( rs.getString("idCliente") ) );
                h.setHabitacion(daoHab.buscar( rs.getString("idHabitacion") ) );
                LocalDateTime fHEntradaBD = format.timeStamp_to_DateTime( rs.getString("fechaEntrada") );
                h.setfHEntrada( format.formatoUTC0_to_Actual(fHEntradaBD) );
                LocalDateTime fHSalidaBD = format.timeStamp_to_DateTime( rs.getString("fechaSalida") );
                h.setfHSalida( format.formatoUTC0_to_Actual( fHSalidaBD ) );
                h.setNroDiasEstancia( rs.getInt("diasEstancia") );
                h.setUser( daoUser.buscar( rs.getString("idUsuario") ) );
                h.setEstado(rs.getString("estado"));
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
    public Hospedaje actualizar(Hospedaje obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Hospedaje eliminar(Hospedaje obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
