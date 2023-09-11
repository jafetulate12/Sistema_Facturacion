package AccesoDatos;


import Entidades.Inventario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jafet
 */
import static AccesoDatos.ClaseConexion.getcConnection;
import java.util.ArrayList;
import java.util.List;
public class ADInventario {
       // atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
     // constructor
    
    public ADInventario() throws Exception{

            _mensaje="";

    }


      // obtener un cliente
public Inventario ObtenerDetalleVenta(String condicion)throws SQLException{
    Inventario inventario = new Inventario();
    ResultSet rs=null;
    try {
        Statement stm=_cnn.createStatement();
        String sentencia="SELECT I.IDINVENTARIO, I.IDREFACCION, R.NOMBREREFACCION, R.PRECIOREFACCION, I.CANTIDAD\n" +
"FROM INVENTARIO I\n" +
"JOIN REFACCION R ON I.IDREFACCION = R.IDREFACCION";
        if (!condicion.equals("")) {
            sentencia= String.format("%s where %s",sentencia,condicion);
        }
        rs= stm.executeQuery(sentencia);
        if (rs.next()) {
            inventario.setIdInventario(rs.getInt(1));
            inventario.setIdRefaccion(rs.getInt(2));
            inventario.setNombre(rs.getString(3));
            inventario.setPrecioUnitario(rs.getDouble(4));
            inventario.setCantidad(rs.getInt(5));
        }
    } catch (Exception e) {throw e;}
    finally{_cnn=null;}
    return inventario;
}// final obtener un cliente
    
    
     //listar Clientes
    public List<Inventario> ListarInventario_List(String condicion) throws Exception{
        ResultSet rs=null;
        Inventario invetario;
        List<Inventario> lista = new ArrayList();
        Connection _conexion=null;
        try {
            //abrir la coneccion
            _conexion=ClaseConexion.getcConnection();
            Statement stm = _conexion.createStatement();
            String sentencia="SELECT I.IDINVENTARIO, I.IDREFACCION, R.NOMBREREFACCION, R.PRECIOREFACCION, I.CANTIDAD\n" +
"FROM INVENTARIO I\n" +
"JOIN REFACCION R ON I.IDREFACCION = R.IDREFACCION";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs=stm.executeQuery(sentencia);
            while(rs.next()){
                invetario = new Inventario(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getInt(5));
                lista.add(invetario);
            }
        } catch (Exception ex) {throw ex;}
        finally{
            if(!_conexion.equals(null)){
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
    }//ListarClientes_List
    
    
}// final
