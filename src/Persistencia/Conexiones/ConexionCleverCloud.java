package Persistencia.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/* @author MeloDev */

public class ConexionCleverCloud{
    private static Connection con;
    //JDBC driver y url
    private static final String JDBC_Driver="com.mysql.cj.jdbc.Driver";
    //"org.postgresql.Driver"
    //com.mysql.jdbc.Driver //org.gjt.mm.mysql.Driver
    
    private static final String url="jdbc:mysql://"
            + "bffb61mrt4emysc84vyz-mysql.services.clever-cloud.com" //HOST
            + ":3306" //PORT
            + "/bffb61mrt4emysc84vyz"; //DBNAME
    
    //Credenciales
    private static final String user="uxpvq6ygeqz30ng8";
    private static final String pass="omgovng0Egj47uLRQLkP";
    private static final String descripcion="Host CLEVER CLOUD de Mysql";

    private ConexionCleverCloud() {
    }

    public static Connection getInstance() {
        if (con == null) {
            try {
                Class.forName(JDBC_Driver);
                con = DriverManager.getConnection(url, user, pass);//"con" tipo Connection de clase conexion
                System.out.println("Conexion establecida con Clever Cloud");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return con;
    }    
    
    
    public void cerrar() throws SQLException{
        if (con!=null) {
            if(!con.isClosed()){
                con.close();
//                System.out.println("CONEXION CERRADA");
            }
        }
    }

    
    public void descripcion() {
        System.out.println(descripcion);
    }
    
}
