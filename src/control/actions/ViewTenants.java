package control.actions;

import dao.DAOFactory;
import dao.TenantDAO;
import model.Table;
import model.Tenant;
import view.ResultsDecoratorHTML;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by root on 09.02.14.
 */
public class ViewTenants implements Action {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.ConnTypes.DriverManagerJDBC);
        TenantDAO tenantDAO = daoFactory.getTenantDAO();

        //List<Tenant> tntns=tenantDAO.findAll();
        Table tenants = tenantDAO.toTable();



        ResultsDecoratorHTML rd=new ResultsDecoratorHTML();


        request.setAttribute("tableHtmlCode", rd.write(tenants));


        return "viewTenants";
    }
}
