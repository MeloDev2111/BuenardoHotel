/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author josue
 */
public class BuilderConexionCleverCloud extends BuilderConexion{
         
    //JDBC driver y url
    private final String JDBC_Driver="com.mysql.cj.jdbc.Driver";
    //"org.postgresql.Driver"
    //com.mysql.jdbc.Driver //org.gjt.mm.mysql.Driver
    
    private final String url="jdbc:mysql://"
            + "bffb61mrt4emysc84vyz-mysql.services.clever-cloud.com" //HOST
            + ":3306" //PORT
            + "/bffb61mrt4emysc84vyz"; //DBNAME
    
    //Credenciales
    private final String user="uxpvq6ygeqz30ng8";
    private final String pass="omgovng0Egj47uLRQLkP";

    private final String descripcion="CONECTADO A CLEVER CLOUD";
    
    @Override
    public Conexion crearConexion() {
        return new Conexion(JDBC_Driver, url, user, pass, descripcion);
    }
}
