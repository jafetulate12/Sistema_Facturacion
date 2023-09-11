
package Servlets;

/**
 *
 * @author Jafet
 */
import Entidades.Administrador;
import LogicaNegocios.LNAdministrador;
import java.io.*;// esto imprime variables en pantalla
import java.net.URLEncoder ;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EliminarAdministrador")
public class EliminarAdministrador extends HttpServlet{
    
    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // inicializa el tipo de salida html
           resp.setContentType("text/html;charset=UTF-8");
           PrintWriter out= resp.getWriter();
           try {
            LNAdministrador logica = new LNAdministrador();
            //Parametros de la query string
            String id= req.getParameter("idAdministrador");
            int codigo = Integer.parseInt(id);
            Administrador administrador = new Administrador();
            administrador.setIdAdministrador(codigo);
            
            int resultado = logica.EliminarCliente(administrador);
            //se recupera el mesaje de el sp
            String mensaje= logica.getMensaje();
            //codificacion de caracteres para mostrar 
            mensaje=URLEncoder.encode(mensaje,"UTF-8");
            // Redireccionamos la pagina frmlistar clientes
            // y enviamos por parametro mensaje
            resp.sendRedirect("frmListarAdministrador.jsp?mensajeEliminarAdministrador="+mensaje+"&resultado="+resultado);
        } catch (Exception ex) {
            out.print(ex.getMessage());// para escribirn em html
        }
    }// fin

    
    
    
}