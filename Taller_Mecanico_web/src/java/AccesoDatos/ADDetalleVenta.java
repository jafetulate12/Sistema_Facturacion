/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

import static AccesoDatos.ClaseConexion.getcConnection;
import Entidades.DetalleVenta;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jafet
 */
public class ADDetalleVenta {
      // atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
    }
    
     // constructor
    
    public ADDetalleVenta() throws Exception{
            _mensaje="";
    }
    
 
    
    public int InsertarVentaCompraTEMP(DetalleVenta detalleVenta) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call InsertarDetalleVentaYActualizarInventario(?, ?, ?, ?)}");
            //parametros de entrada
            cs.setInt(1,detalleVenta.getIdRefaccion());
            cs.setInt(2,detalleVenta.getCantidad());
            cs.setDouble(3,detalleVenta.getSubtotal());
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
    public int ActualizarFacturaCompra(DetalleVenta detalleVenta ) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call ActualizarUltimaFacturaVenta(?,?)}");
            //parametros de entrada
            cs.setDouble(1,detalleVenta.getPrecioFinal());
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
    public List<DetalleVenta> ListarDetalleVenta_list(String condicion) throws Exception{
        ResultSet rs=null;
        DetalleVenta detalleventa;
        List<DetalleVenta> lista = new ArrayList();
        Connection _conexion=null;
        try {
            //abrir la coneccion
            _conexion=ClaseConexion.getcConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "SELECT IDDETALLEVENTA, IDFACTURAVENTA, IDREFACCION, CANTIDAD, IDSERVICIOS, SUBTOTAL FROM Temp_DETALLEVENTA";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs=stm.executeQuery(sentencia);
            while(rs.next()){
                detalleventa = new DetalleVenta(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getDouble(6));
                lista.add(detalleventa);
            }
        } catch (Exception ex) {throw ex;}
        finally{
            if(!_conexion.equals(null)){
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
    }//ListarClientes_List
 
    
    
    
    
    public int EliminarDetalle(DetalleVenta detalleventa)throws Exception {
        
       CallableStatement CS= null;
       int resultado = -1;
       Connection _conexion=null;
        try {
            _conexion=ClaseConexion.getcConnection();
            // registrar paraamtros
            CS = _conexion.prepareCall("{call EliminarDetalleVenta(?,?)}");
            CS.setInt(1,detalleventa.getIdDetalleVenta());
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
    
    
    
     public int InsertarVentaSerCompraTEMP(DetalleVenta detalleVenta) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call InsertarDetalleVentaSer(?, ?, ?)}");
            //parametros de entrada
            cs.setInt(1,detalleVenta.getIdServicios());
            cs.setDouble(2,detalleVenta.getSubtotal());
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
 
     

     

     


    
    
}// final ADdetalle venta
