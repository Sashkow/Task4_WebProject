/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*

package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

*/
/**
 *
 * @author Amdrii
 *//*

public class DataSourceDAOJDBCFactory extends DAOFactory{

    @Override
    public Connection getConnection() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setPortNumber(3306);
        ds.setDatabaseName("socnet");
        ds.setUser("root");
        ds.setPassword("root");
        return ds.getConnection();
    }

    @Override
    public StudentDAO getStudentDAO() {
        return new StudentDAOJDBC(this);
    }

    @Override
    public GroupDAO getGroupDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
*/
