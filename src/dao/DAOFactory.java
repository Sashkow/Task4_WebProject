
package dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Amdrii
 */
public abstract class DAOFactory {

    public enum ConnTypes{
        DriverManagerJDBC, DataSourceJDBC, DataSourceConnPool
    }

    public static DAOFactory getDAOFactory(ConnTypes connType){
        switch(connType){
            case DriverManagerJDBC:
                return new DriverManagerDAOJDBCFactory();
            /*case DataSourceJDBC:
                return new DataSourceDAOJDBCFactory();*/
            case DataSourceConnPool:
                return new DataSourceConnPoolFactory();
            default: return null;
        }
    };

    public abstract Connection getConnection() throws SQLException;

    public abstract TenantDAO getTenantDAO();
    //public abstract GroupDAO getGroupDAO();

}
