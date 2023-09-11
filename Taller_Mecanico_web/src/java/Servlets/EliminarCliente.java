
package Servlets;

/**
 *
 * @author Jafet
 */
import Entidades.Cliente;
import LogicaNegocios.LNCliente;
import java.io.*;// esto imprime variables en pantalla
import java.net.URLEncoder ;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EliminarCliente")
public class EliminarCliente extends HttpServlet{
    
    @Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // inicializa el tipo de salida html
           resp.setContentType("text/html;charset=UTF-8");
           PrintWriter out= resp.getWriter();
           try {
            LNCliente logica = new LNCliente();
            //Parametros de la query string
            String id= req.getParameter("idCliente");
            int codigo = Integer.parseInt(id);
            Cliente cliente = new Cliente();
            cliente.setIdCliente(codigo);
            
            int resultado = logica.EliminarCliente(cliente);
            //se recupera el mesaje de el sp
            String mensaje= logica.getMensaje();
            //codificacion de caracteres para mostrar 
            mensaje=URLEncoder.encode(mensaje,"UTF-8");
            // Redireccionamos la pagina frmlistar clientes
            // y enviamos por parametro mensaje
            resp.sendRedirect("frmListarClientes.jsp?mensajeEliminarCliente="+mensaje+"&resultado="+resultado);
        } catch (Exception ex) {
            out.print(ex.getMessage());// para escribirn em html
        }
    }// fin

    
    
    
}
