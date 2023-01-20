/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.axyus.agendawebapp.controller;

import com.axyus.agendawebapp.bll.AgendaManager;
import com.axyus.agendawebapp.bo.Address;
import com.axyus.agendawebapp.utils.Utils;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;

/**
 *
 * @author farah.gauduin
 */
@WebServlet(name = "AddressesServlet", urlPatterns = {"/AddressesServlet"})
public class AddressesServlet extends HttpServlet {

    Utils utils = new Utils();
    AgendaManager agendaManager = new AgendaManager();
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AddressesServlet.class);

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
        request.getRequestDispatcher("/WEB-INF/view/all-addresses.jsp").forward(request, response);
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
            String action = request.getParameter("dispatchMethod") != null ? request.getParameter("dispatchMethod") : "";
            utils.initialize();

            switch (action) {
                case "deleteAddress":
                    deleteAddress(request, response);
                    break;
                case "showUpdateForm":
                    showUpdateForm(request, response);
                    break;
                default:
                    allAddresses(request, response);

            }

        } catch (SQLException ex) {
            logger.error("DOGET problem", ex);
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        Address existingAddress = agendaManager.findAddressbyId(addressId);
        request.setAttribute("existingAddress", existingAddress);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/view/update-address.jsp");
        rd.forward(request, response);
    }

    private void deleteAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        agendaManager.deleteAddressById(addressId);
        response.sendRedirect("all-addresses");

    }

    private void allAddresses(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Address> addressesList = agendaManager.getAllAddresses();
        request.setAttribute("addressesList", addressesList);

        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/view/all-addresses.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddressesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
