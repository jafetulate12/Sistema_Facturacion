
package LogicaNegocios;


import AccesoDatos.ADInventario;
import Entidades.Inventario;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jafet
 */
public class LNInventario {
        
    //atributos
        private String _mensaje;
        
         private int _id;
    
    public int getId() {
        return _id;
    }
        // get
    public String getMensaje() {
        return _mensaje;
    }
 public List<Inventario> ListarClientes_List(String condicion) throws Exception{
        List<Inventario> resultado = new ArrayList();
        ADInventario adinventario;
        try {
            adinventario=new ADInventario();
            resultado = adinventario.ListarInventario_List(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//ListarClientes_Rs
    
    //llamar a obtener un client
    public Inventario ObtenerInventario(String condicion) throws Exception{
        Inventario inventario;
        ADInventario adinventario;
        try {
            adinventario= new ADInventario();
            inventario=adinventario.ObtenerDetalleVenta(condicion);
            if (inventario.isExiste()) {
                _mensaje="detalle recuperado";
            } else{
                 _mensaje="detalle no existe en la base de datos ";
            }
        } catch (Exception e) {
            throw e;
        }
        return inventario;
    }// fin obtener cliente
    
}// final
