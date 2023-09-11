
package AccesoDatos;



import Entidades.FacturaVenta;
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

public class ADFacturaVenta {
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
    
    public ADFacturaVenta() throws Exception{

            _mensaje="";
    
    }
    
      ///'METODO DE INSERTAR
       public int InsertarFacturaVenta(FacturaVenta facturaVenta ) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call GUARDARFACTURAVenta(?,?,?,?)}");
            //parametros de entrada
            cs.setInt(1, facturaVenta.getIdFacturaVenta());
            cs.setInt(2, facturaVenta.getIdAdministrador());
            cs.setInt(3,facturaVenta.getIdCliente());
            cs.setString(4,_mensaje);
            //parametros de salida
            cs.registerOutParameter(4,Types.VARCHAR);
            //ejecuta
            resultado=cs.executeUpdate();
            // leer partametros de salida
            _mensaje=cs.getString(4);
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
public ResultSet MostrarIdVenta_RS(String condicion, String orden)throws SQLException{
ResultSet rs = null;
    try {
        Statement stm = _cnn.createStatement();
        String sentencia="SELECT IDENT_CURRENT('FACTURAVENTA') AS LastID;";
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
        

public FacturaVenta ObtenerFacturaVenta(String condicion)throws SQLException{
    FacturaVenta facturaVenta = new FacturaVenta();
    ResultSet rs=null;
    try {
        Statement stm=_cnn.createStatement();
        String sentencia="SELECT IDFACTURAVENTA FROM FACTURAVENTA";
        if (!condicion.equals("")) {
            sentencia= String.format("%s where %s",sentencia,condicion);
        }
        rs= stm.executeQuery(sentencia);
        if (rs.next()) {
            facturaVenta.setIdFacturaVenta(rs.getInt(1)); 
        }
    } catch (Exception e) {throw e;}
    finally{_cnn=null;}
    return facturaVenta;
}// final obtener un cliente
    
    
    // Listar los detalles de compra junto con el nombre de la refacción
public ResultSet ListarPorId(String condicion, String orden) throws SQLException {
    ResultSet rs = null;
    try {
        Statement stm = _cnn.createStatement();
        String sentencia = "SELECT A.IDADMINISTRADOR, A.NOMBREADMINISTRADOR, SUM(FV.TOTALVENTA) AS CantidadTotalVentas\n" +
"FROM ADMINISTRADOR A\n" +
"JOIN FACTURAVENTA FV ON A.IDADMINISTRADOR = FV.IDADMINISTRADOR\n" +
"GROUP BY A.IDADMINISTRADOR, A.NOMBREADMINISTRADOR";
        if (!condicion.equals("")) {
            sentencia = String.format("%s WHERE %s", sentencia, condicion);
        }
        if (!orden.equals("")) {
            sentencia = String.format("%s ORDER BY %s", sentencia, orden);
        }
        rs = stm.executeQuery(sentencia);
    } catch (Exception ex) {
        throw ex;
    } finally {
        // _cnn=null; // No es necesario asignar null aquí
    }
    return rs;
}
    
    
    
    // Listar los detalles de compra junto con el nombre de la refacción
public ResultSet listaPorFecha(String condicion, String orden) throws SQLException {
    ResultSet rs = null;
    try {
        Statement stm = _cnn.createStatement();
        String sentencia = "SELECT DATEPART(YEAR, FECHA) AS Anio,\n" +
"       DATEPART(MONTH, FECHA) AS Mes,\n" +
"       SUM(TOTALVENTA) AS TotalVentasPorMes\n" +
"FROM FACTURAVENTA\n" +
"GROUP BY DATEPART(YEAR, FECHA), DATEPART(MONTH, FECHA)\n" +
"ORDER BY Anio, Mes";
        if (!condicion.equals("")) {
            sentencia = String.format("%s WHERE %s", sentencia, condicion);
        }
        if (!orden.equals("")) {
            sentencia = String.format("%s ORDER BY %s", sentencia, orden);
        }
        rs = stm.executeQuery(sentencia);
    } catch (Exception ex) {
        throw ex;
    } finally {
        // _cnn=null; // No es necesario asignar null aquí
    }
    return rs;
}
    
 // listar los clientes de la bd 
public ResultSet MostraFactura(String condicion, String orden)throws SQLException{
ResultSet rs = null;
    try {
        Statement stm = _cnn.createStatement();
        String sentencia="Select IDFACTURAVENTA,IDADMINISTRADOR,FECHA,IDCLIENTE,TOTALVENTA FROM FACTURAVENTA";
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
    
    
    

}// final Factura Venta
