/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Table;
import model.Tenant;

import static dao.DAOJDBCUtil.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amdrii
 */
public class TenantDAOJDBC implements TenantDAO {

    private DAOFactory daoFactory;

    public TenantDAOJDBC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public Tenant find(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Tenant student = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from Tenant where id=?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                student = (map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return student;
    }

    @Override
    public List<Tenant> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Tenant> tenants = new ArrayList<Tenant>();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from tenants");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tenants.add(map(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return tenants;
    }

    @Override
    public Table toTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        //List<Tenant> tenants = new ArrayList<Tenant>();
        Table tenants = new Table();

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("select * from tenants");
            resultSet = preparedStatement.executeQuery();

            TableFiller.fillTable(tenants,resultSet);
            return tenants;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }
        return null;
    }

    @Override
    public boolean create(Tenant student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Tenant "
                    + "(name, year) VALUES (?, ?)");
            //preparedStatement.setS


            return preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return false;
    }

    private Tenant map(ResultSet resultSet) throws SQLException {
        Tenant t = new Tenant();
        t.setName("todomap");

        return t;
    }

    @Override
    public Tenant getByName(String studentName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Tenant student = null;

        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.
                    prepareStatement("select * from Tenant where studentname = ?");
            preparedStatement.setString(1, studentName);
            //resultSet = preparedStatement.executeQuery();
            statement = connection.createStatement();
            String sql = "select * from Tenant where studentname = '" + studentName + "'";
            System.out.println(sql);
            resultSet = statement.executeQuery(sql);

            if(resultSet.next()) {
                student = map(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(resultSet);
            close(preparedStatement);
            close(connection);
        }

        return student;
    }
}
