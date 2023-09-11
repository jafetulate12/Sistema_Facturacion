
package AccesoDatos;


import Entidades.Refaccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Jafet
 */
 import static AccesoDatos.ClaseConexion.getcConnection;
import java.util.List;
public class ADRefaccion {
    
    
         // atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
     // constructor
    
    public ADRefaccion() throws Exception{

            _mensaje="";

    }// final cosntructor
    
    //listar Clientes
    public List<Refaccion> ListarClientes_List(String condicion) throws Exception{
        ResultSet rs=null;
        Refaccion refaccion;
        List<Refaccion> lista = new ArrayList();
        Connection _conexion=null;
        try {
            //abrir la coneccion
            _conexion=ClaseConexion.getcConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "SELECT IDREFACCION, CODIGO_REFACCION,NOMBREREFACCION,PRECIOREFACCION FROM REFACCION";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs=stm.executeQuery(sentencia);
            while(rs.next()){
                refaccion = new Refaccion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
                lista.add(refaccion);
            }
        } catch (Exception ex) {throw ex;}
        finally{
            if(!_conexion.equals(null)){
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
    }//ListarClientes_List



 // METODO QUE RECUPERA UN CLIENTE
    // obtener un cliente
public Refaccion ObtenerRefaccion(String condicion)throws SQLException{
    Refaccion refaccion = new Refaccion();
    ResultSet rs=null;
    try {
        Statement stm=_cnn.createStatement();
        String sentencia="SELECT IDREFACCION, NOMBREREFACCION FROM REFACCION";
        if (!condicion.equals("")) {
            sentencia= String.format("%s where %s",sentencia,condicion);
        }
        rs= stm.executeQuery(sentencia);
        if (rs.next()) {
            refaccion.setIdRefaccion(rs.getInt(1));
            refaccion.setNombre(rs.getString(2));  
        }
    } catch (Exception e) {throw e;}
    finally{_cnn=null;}
    return refaccion;
}// final obtener un cliente

public Refaccion ObtenerPrecio(String condicion)throws SQLException{
    Refaccion refaccion = new Refaccion();
    ResultSet rs=null;
    try {
        Statement stm=_cnn.createStatement();
        String sentencia="SELECT PRECIOREFACCION FROM REFACCION WHERE IDREFACCION = <ID_DE_LA_REFACCION>";
        if (!condicion.equals("")) {
            sentencia= String.format("%s where %s",sentencia,condicion);
        }
        rs= stm.executeQuery(sentencia);
        if (rs.next()) {
            refaccion.setIdRefaccion(rs.getInt(1));
            refaccion.setNombre(rs.getString(2));  
        }
    } catch (Exception e) {throw e;}
    finally{_cnn=null;}
    return refaccion;
}// final obtener un cliente


}// final 
