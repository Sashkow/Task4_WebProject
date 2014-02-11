/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control.actions;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Amdrii
 */
public class ActionFactory {

    private static final Map<String,Action> actions;
    static{
        actions = new HashMap<String, Action>();
        actions.put("/viewTenants", new ViewTenants());
        actions.put("/createTenant", new CreateTenant());

    }

    public static Action getAction(HttpServletRequest request) {
        System.out.println(request.getPathInfo());
        return actions.get(request.getPathInfo());
    }
}
