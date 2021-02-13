package Persistencia.FactoriaDAO.Mysql;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Persistencia.FactoriaDAO.IHabitacionDao;
import Negocio.Habitacion;

public class HabitacionDaoMysql implements IHabitacionDao{
    private Connection conexion;

    public HabitacionDaoMysql(Connection con) {
        conexion=con;
    }

    @Override
    public Habitacion registrar(Habitacion obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Habitacion> listado() {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        Habitacion hab = new Habitacion();
        hab.setIdHabitacion("1");
        habitaciones.add(hab);
        habitaciones.add(hab);
        habitaciones.add(hab);
        habitaciones.add(hab);
        habitaciones.add(hab);
        
        return habitaciones;
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
    public ArrayList<Habitacion> filtrar(String palabraClave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
