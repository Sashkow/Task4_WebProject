package dao;

import model.Table;
import model.Tenant;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by root on 09.02.14.
 */
public interface TenantDAO {
    Tenant find(Integer id);
    List<Tenant> findAll();
    Table toTable();
    boolean create(Tenant student);

    Tenant getByName(String studentName);
}
