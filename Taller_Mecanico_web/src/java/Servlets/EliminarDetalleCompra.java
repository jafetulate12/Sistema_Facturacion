package Servlets;

/**
 *
 * @author Jafet
 */
import Entidades.DetalleCompra;
import LogicaNegocios.LNDetalleCompra;
import java.io.*;// esto imprime variables en pantalla
import java.net.URLEncoder ;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EliminarDetalleCompra")
public class EliminarDetalleCompra extends HttpServlet{
    
    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // inicializa el tipo de salida html
           resp.setContentType("text/html;charset=UTF-8");
           PrintWriter out= resp.getWriter();
           try {
               LNDetalleCompra logica = new LNDetalleCompra();
            //Parametros de la query string
            String id= req.getParameter("idCliente");
            int codigo = Integer.parseInt(id);
            DetalleCompra detallecompra = new DetalleCompra();
            detallecompra.setIdDetalleCompra(codigo);
            
            int resultado = logica.EliminarDetalle(detallecompra);
            //se recupera el mesaje de el sp
            String mensaje= logica.getMensaje();
            //codificacion de caracteres para mostrar 
            mensaje=URLEncoder.encode(mensaje,"UTF-8");
            // Redireccionamos la pagina frmlistar clientes
            resp.sendRedirect("frmDetalleCompra.jsp?mensajeEliminarDetalleCompra="+mensaje);
            // y enviamos por parametro mensaje
        } catch (Exception ex) {
            out.print(ex.getMessage());// para escribirn em html
        }
    }// fin

    
    
    
}
