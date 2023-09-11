/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;
import Entidades.Administrador;
import LogicaNegocios.LNAdministrador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class CrearModificarAdministrador extends HttpServlet {


   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        String mensaje="";
        
        try {
            LNAdministrador logica= new LNAdministrador ();
            Administrador administrador = new Administrador();
            int resultado;
            administrador.setIdAdministrador(Integer.parseInt(request.getParameter("txtCodigo")));
            administrador.setNombre(new String (request.getParameter("txtNombre").
                    getBytes("ISO-8859-1"),"UTF-8"));
            administrador.setTelefono(request.getParameter("txtTelefono"));
            administrador.setCedula(new String (request.getParameter("txtCedula").
                    getBytes("ISO-8859-1"),"UTF-8"));
            administrador.setCorreo(new String (request.getParameter("txtCorreo").
                    getBytes("ISO-8859-1"),"UTF-8"));
      // inserta o actualiza
                resultado=logica.InsertarAdministrador(administrador);
                 mensaje=logica.getMensaje();
            
            response.sendRedirect("frmListarAdministrador.jsp?mensajeEliminarAdministrador="+mensaje);
        } catch (Exception ex) {
            out.print(ex.getMessage());
        }
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
