package Persistencia.FactoriaDAO;

import Persistencia.FactoriaDAO.Mysql.FabricaDaoMysql;

/* @author MeloDev */
public abstract class FabricaDao {
    //DAOs a FABRICAR
    public abstract IUsuarioDao getUsuarioDao();
    public abstract IHabitacionDao getHabitacionDao();
    public abstract ITipoHabitacionDao getTipoHabitacionDao();
    public abstract IClienteDao getClientesDao();
    public abstract IHospedajeDao getHospedajeDao();
    
    public static FabricaDao getDAOFactory(ETiposFabricaDao tipo) {

      switch (tipo) {
        case MYSQL: 
            return new FabricaDaoMysql();
        case SQLSERVER: 
            //
        case FICHEROS    : 
            //
        default           : 
            return null;
      }
    } 
}
