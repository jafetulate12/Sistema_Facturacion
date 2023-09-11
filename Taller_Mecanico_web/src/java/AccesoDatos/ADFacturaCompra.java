package AccesoDatos;

import Entidades.FacturaCompra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author Jafet
 */
 import static AccesoDatos.ClaseConexion.getcConnection;
public class ADFacturaCompra {
    
    
   
    
    // atributos
    private Connection _cnn;
    private String _mensaje;
    private Double _id;
    
    public Double getId() {
        return _id;
    }

    public String getMensaje(){
        return _mensaje;
    }
    
     // constructor
    
    public ADFacturaCompra() throws Exception{
 
            _mensaje="";
     
    }
        
         ///'METODO DE INSERTAR
       public int InsertarFacturaCompra(FacturaCompra facturacompra) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call GUARDARFACTURA(?,?,?)}");
            //parametros de entrada
            cs.setInt(1, facturacompra.getIdFacturaCompra());
            cs.setInt(2,facturacompra.getIdAdministrador());
            cs.setString(3,_mensaje);
            //parametros de salida
            cs.registerOutParameter(3,Types.VARCHAR);
            //ejecuta
            resultado=cs.executeUpdate();
            // leer partametros de salida
            _mensaje=cs.getString(3);
        } catch (Exception ex) {
            _mensaje = "Error inesperado, intentar mas tarde";
            throw ex;
        }
        finally{
            if(!_conexion.equals(null)){
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;
    }//fin InsertarCliente
   
            // listar los clientes de la bd 
public ResultSet MostrarIdCompra_RS(String condicion, String orden)throws SQLException{
ResultSet rs = null;
    try {
        Statement stm = _cnn.createStatement();
        String sentencia="SELECT IDENT_CURRENT('FACTURACOMPRA') AS LastID;";
        if (!condicion.equals("")) {
            sentencia=String.format("%s where &s",sentencia,condicion);
        }
        if (!orden.equals("")) {
            sentencia=String.format("%s where &s",sentencia,orden);
        }
        rs=stm.executeQuery(sentencia);
    } catch (Exception ex) {throw ex;}
        
     finally{_cnn=null;}
     return rs;
}// final listar clientes
        

public FacturaCompra ObtenerFacturaCompra(String condicion)throws SQLException{
    FacturaCompra facturaCompra = new FacturaCompra();
    ResultSet rs=null;
    try {
        Statement stm=_cnn.createStatement();
        String sentencia="SELECT IDFACTURACOMPRA FROM FACTURACOMPRA";
        if (!condicion.equals("")) {
            sentencia= String.format("%s where %s",sentencia,condicion);
        }
        rs= stm.executeQuery(sentencia);
        if (rs.next()) {
            facturaCompra.setIdFacturaCompra(rs.getInt(1)); 
        }
    } catch (Exception e) {throw e;}
    finally{_cnn=null;}
    return facturaCompra;
}// final obtener un cliente
        
        







    }// final 
    
    
    
    
    
    
    
    
    
    
    
    
    
