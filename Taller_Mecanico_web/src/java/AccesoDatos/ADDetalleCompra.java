package AccesoDatos;


import Entidades.DetalleCompra;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jafet
 *///importar los metodos de la ClaseConesion
import static AccesoDatos.ClaseConexion.getcConnection;
import Entidades.Cliente;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ADDetalleCompra {
    // atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
     // constructor
    
    public ADDetalleCompra() throws Exception{
    
            _mensaje="";

    }// final cosntructor
    
    //Insertar un Cliente
    public int InsertarDetalleCompraTEMP(DetalleCompra detallecompra ) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call GUARDARDETALLECOMPRA(?,?,?,?)}");
            //parametros de entrada
            cs.setInt(1,detallecompra.getIdRefaccion());
            cs.setInt(2,detallecompra.getCantidad());
            cs.setDouble(3,detallecompra.getSubtotal());
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
    
  
    
       //Insertar un Cliente
    public int ActualizarFacturaCompra(DetalleCompra detallecompra ) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call ActualizarUltimaFacturaCompra(?,?)}");
            //parametros de entrada
            cs.setDouble(1,detallecompra.getPrecioFinal());
            cs.setString(2,_mensaje);
            //parametros de salida
            cs.registerOutParameter(2,Types.VARCHAR);
            //ejecuta
            resultado=cs.executeUpdate();
            // leer partametros de salida
            _mensaje=cs.getString(2);
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
    
    
    
    
    
    
    
    
    
    
      //listar Clientes
    public List<DetalleCompra> ListarDetalleCompra_list(String condicion) throws Exception{
        ResultSet rs=null;
        DetalleCompra detallecompra;
        List<DetalleCompra> lista = new ArrayList();
        Connection _conexion=null;
        try {
            //abrir la coneccion
            _conexion=ClaseConexion.getcConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "SELECT ID, IDFACTURACOMPRA, IDREFACCION, CANTIDAD, SUBTOTAL FROM TEMPCargaDetallesCompra";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs=stm.executeQuery(sentencia);
            while(rs.next()){
                detallecompra = new DetalleCompra(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getDouble(5));
                lista.add(detallecompra);
            }
        } catch (Exception ex) {throw ex;}
        finally{
            if(!_conexion.equals(null)){
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
    }//ListarClientes_List
 
     
 
     
        // obtener un cliente
public DetalleCompra ObtenerDetalleCompra(String condicion)throws SQLException{
    DetalleCompra detalleCompra = new DetalleCompra();
    ResultSet rs=null;
    try {
        Statement stm=_cnn.createStatement();
        String sentencia="SELECT ID, CANTIDAD, SUBTOTAL FROM TEMPCargaDetallesCompra";
        if (!condicion.equals("")) {
            sentencia= String.format("%s where %s",sentencia,condicion);
        }
        rs= stm.executeQuery(sentencia);
        if (rs.next()) {
            detalleCompra.setIdDetalleCompra(rs.getInt(1));
            detalleCompra.setCantidad(rs.getInt(2));
            detalleCompra.setSubtotal(rs.getDouble(3));
;   
        }
    } catch (Exception e) {throw e;}
    finally{_cnn=null;}
    return detalleCompra;
}// final obtener un cliente

    

public int EliminarDetalle(DetalleCompra detalleCompra)throws Exception {
        
       CallableStatement CS= null;
       int resultado = -1;
       Connection _conexion=null;
        try {
            _conexion=ClaseConexion.getcConnection();
            // registrar paraamtros
            CS = _conexion.prepareCall("{call EliminarDetalle(?,?)}");
            CS.setInt(1,detalleCompra.getIdDetalleCompra());
            CS.setString(2,_mensaje);
            // parametros de salida
            CS.registerOutParameter(2,Types.VARCHAR);
            // ejecutar sentencia
            resultado =CS.executeUpdate();
            // leer parametros de salida
            _mensaje=CS.getString(2);
            
        } catch (Exception ex) {throw ex;}
            finally{
                    if (_conexion!=null) {
                        ClaseConexion.close(_conexion); 
                    }
                 }
        return resultado;
        }// fina eliminar cliente


}// final detalle compra
