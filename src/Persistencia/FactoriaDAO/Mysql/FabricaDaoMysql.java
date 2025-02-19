package Persistencia.FactoriaDAO.Mysql;

import java.sql.Connection;
import Persistencia.Conexiones.ConexionTipo;
import Persistencia.Conexiones.FabricaConexiones;
import Persistencia.FactoriaDAO.FabricaDao;
import Persistencia.FactoriaDAO.IClienteDao;
import Persistencia.FactoriaDAO.IHabitacionDao;
import Persistencia.FactoriaDAO.IHospedajeDao;
import Persistencia.FactoriaDAO.ITipoHabitacionDao;
import Persistencia.FactoriaDAO.IUsuarioDao;

public class FabricaDaoMysql extends FabricaDao{
    private Connection con = FabricaConexiones.getConnection(ConexionTipo.CLEVERCLOUD);

    @Override
    public IUsuarioDao getUsuarioDao() {
        return new UsuarioDaoMysql(con);
    }

    @Override
    public IHabitacionDao getHabitacionDao() {
        return new HabitacionDaoMysql(con);
    }

    @Override
    public ITipoHabitacionDao getTipoHabitacionDao() {
        return new TipoHabitacionDaoMysql(con);
    }

    @Override
    public IClienteDao getClientesDao() {
        return new ClienteDaoMysql(con);
    }

    @Override
    public IHospedajeDao getHospedajeDao() {
        return new HospedajeDaoMysql(con);
    }

}
