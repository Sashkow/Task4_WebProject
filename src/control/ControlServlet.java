package control;


import control.actions.Action;
import control.actions.ActionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by root on 09.02.14.
 */
public class ControlServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String view = null;

        System.out.println("processRequest");

        Action action = ActionFactory.getAction(request);
        try {
            view = action.execute(request, response);
        } catch (Exception ex) {
            System.out.println("action.execute failed");
            System.out.println(ex.getMessage());
        }

        dispatch(request, response, view);
    }
    private void dispatch(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException {
        String prefix ="/WEB-INF/view/";
        String sufix =".jsp";
        System.out.println(prefix + view + sufix);
        RequestDispatcher dispatcher =
                request.getRequestDispatcher(prefix + view + sufix);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
