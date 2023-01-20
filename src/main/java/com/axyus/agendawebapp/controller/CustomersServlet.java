/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.axyus.agendawebapp.controller;

import com.axyus.agendawebapp.bll.AgendaManager;
import com.axyus.agendawebapp.bo.Customer;
import com.axyus.agendawebapp.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author farah.gauduin
 */
@WebServlet(name = "CustomersServlet", urlPatterns = {"/CustomersServlet"})
public class CustomersServlet extends HttpServlet {

    Utils utils = new Utils();
    AgendaManager agendaManager = new AgendaManager();
    private static final Logger logger = LoggerFactory.getLogger(CustomersServlet.class);

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        request.getRequestDispatcher("/WEB-INF/view/all-customers.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //TERNAIRE (équivalent du if)
            // variable = condition ? si condition ok : condition ko;
            // int age = 16;
            //String majeur = age > 18 ? "majeur" : "mineur";

            String action = request.getParameter("dispatchMethod") != null ? request.getParameter("dispatchMethod") : "";

            utils.initialize();

            switch (action) {
                case "deleteCustomer":
                    deleteCustomer(request, response);
                    break;
                case "showUpdateForm":
                    showUpdateForm(request, response);
                    break;
                default:
                    allCustomers(request, response);

            }
        } catch (SQLException ex) {
            logger.error("DOGET problem", ex);
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        agendaManager.deleteById(customerId);
        response.sendRedirect("all-customers");

    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Customer existingCustomer = agendaManager.findCustomerbyId(customerId);
        request.setAttribute("existingCustomer", existingCustomer);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/view/update-customer.jsp");
        rd.forward(request, response);
    }

    private void allCustomers(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Customer> customersList = agendaManager.getAllCustomers();
        request.setAttribute("customersList", customersList);

        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/view/all-customers.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String firstname = request.getParameter("firstname");
        utils.initialize();

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
