package dao;

import model.Tenant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by root on 09.02.14.
 */
public class DriverManagerDAOJDBCFactory extends DAOFactory {

    @Override
    public Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println("class com.mysql.jdbc.Driver not found");
            e.toString();
        }
        String url ="jdbc:mysql://localhost:3306/CommunalService";
        String user ="root";
        String pass= "";
        return DriverManager.getConnection(url, user, pass);
    }

    @Override
    public TenantDAO getTenantDAO() {
        return new TenantDAOJDBC(this);
    }



}
