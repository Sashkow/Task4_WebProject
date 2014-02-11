/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//import util.Config;

/**
 *
 * @author Amdrii
 */
public class DataSourceConnPoolFactory extends DAOFactory {

    @Override
    public Connection getConnection() throws SQLException {
        DataSource ds = null;
        try {
            InitialContext cxt = new InitialContext();
            ds = (DataSource) cxt.lookup("jdbc/socnet");
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
        return ds.getConnection();
        //return Config.getInstance(servletContext).getDataSource();
    }

    @Override
    public TenantDAO getTenantDAO() {
        return new TenantDAOJDBC(this);
    }
/*
    @Override
    public GroupDAO getGroupDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }*/


}