
package AccesoDatos;

import Entidades.Servicios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Jafet
 */
import java.sql.CallableStatement;
import java.util.List;

public class ADServicios {
    
      // atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
     // constructor
    
    public ADServicios() throws Exception{
            _mensaje="";
    }// final cosntructor
    
  
     
    //METODO PARA LISTAR CON ARRAY

    //listar Servicios
    public List<Servicios> listarServicios(String condicion) throws Exception{
        ResultSet rs=null;
        Servicios servicios;
        List<Servicios> lista = new ArrayList();
        Connection _conexion=null;
        try {
            //abrir la coneccion
            _conexion=ClaseConexion.getcConnection();
            Statement stm = _conexion.createStatement();
             String sentencia = "SELECT IDSERVICIOS, IDMECANICO,NOMBRESERVICIO,FECHASERVICIO,CAMPOSERVICIO,PRECIOSERVICIO FROM SERVICIOS";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs=stm.executeQuery(sentencia);
            while(rs.next()){
                servicios = new Servicios(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDate(4),rs.getString(4),rs.getDouble(6));
                lista.add(servicios);
            }
        } catch (Exception ex) {throw ex;}
        finally{
            if(!_conexion.equals(null)){
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
    }//ListarClientes_List






 
   
   
   
    
}// final clase Servicios 
