package control.actions;

import dao.DAOFactory;
import dao.TenantDAO;
import model.Table;
import model.Tenant;
import view.ResultsDecoratorHTML;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by root on 10.02.14.
 */
public class CreateTenant implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.ConnTypes.DriverManagerJDBC);
        TenantDAO tenantDAO = daoFactory.getTenantDAO();

        Tenant tenant = new Tenant();

        tenant.setName(request.getParameter("name"));
        tenant.setEmail(request.getParameter("email"));

        System.out.println(tenant.getName());

        tenantDAO.create(tenant);






        //boolean ifCreaded =tenantDAO.create(tenant);

        return "createTenant";
    }
}
