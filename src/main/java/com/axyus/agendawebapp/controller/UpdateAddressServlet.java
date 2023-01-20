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
import java.util.logging.Level;
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
@WebServlet(name = "UpdateAddress", urlPatterns = {"/UpdateAddress"})
public class UpdateAddressServlet extends HttpServlet {

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
            throws ServletException, IOException {
    }
    
    private void updateAddress(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int streetNumber = Integer.parseInt(request.getParameter("streetNumber"));
        String streetName = request.getParameter("streetName");
        String city = request.getParameter("city");
        String postalCode = request.getParameter("postalCode");
        String country = request.getParameter("country");
        Address updatedAddress = new Address(addressId, streetNumber, streetName, city, postalCode, country);
        agendaManager.updateAddress(updatedAddress);
        response.sendRedirect("all-addresses");
        
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
        processRequest(request, response);
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
            updateAddress(request, response);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
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
