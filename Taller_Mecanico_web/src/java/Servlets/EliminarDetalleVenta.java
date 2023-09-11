/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;

;
import Entidades.DetalleVenta;
import LogicaNegocios.LNDetalleVenta;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */@WebServlet("/EliminarDetalleVenta")
public class EliminarDetalleVenta extends HttpServlet{      
     
     @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // inicializa el tipo de salida html
           resp.setContentType("text/html;charset=UTF-8");
           PrintWriter out= resp.getWriter();
           try {
               LNDetalleVenta logica = new LNDetalleVenta();
            //Parametros de la query string
            String id= req.getParameter("idCliente");
            int codigo = Integer.parseInt(id);
            DetalleVenta detalleventa = new DetalleVenta();
            detalleventa.setIdDetalleVenta(codigo);
            
            int resultado = logica.EliminarDetalleVenta(detalleventa); 
            //se recupera el mesaje de el sp
            String mensaje= logica.getMensaje();
            //codificacion de caracteres para mostrar 
            mensaje=URLEncoder.encode(mensaje,"UTF-8");
            // Redireccionamos la pagina frmlistar clientes
            resp.sendRedirect("frmDetalleVenta.jsp?mensajeEliminarDetalleCompra="+mensaje);
            // y enviamos por parametro mensaje
        } catch (Exception ex) {
            out.print(ex.getMessage());// para escribirn em html
        }
    }// fin

    
    
    
}


