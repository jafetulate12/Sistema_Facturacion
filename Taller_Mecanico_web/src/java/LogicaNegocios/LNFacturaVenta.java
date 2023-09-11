
package LogicaNegocios;


import AccesoDatos.ADFacturaVenta;

import Entidades.FacturaVenta;
import java.sql.ResultSet;

/**
 *
 * @author Jafet
 */
public class LNFacturaVenta {
        //atributos
        private String _mensaje;
        
        // get
    public String getMensaje() {
        return _mensaje;
    }
     // LLAMA A INSERTAR
    public int InsertarFacturaVenta(FacturaVenta facturaventa) throws Exception{
        int id=-1;
        ADFacturaVenta  adfacturaventa;
        try {
            adfacturaventa= new ADFacturaVenta();
            id=adfacturaventa.InsertarFacturaVenta(facturaventa);
            _mensaje=adfacturaventa.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }//Fin Insertar Cliente
    
 // LLAMA A LISTAR CLIENTES
    public ResultSet MostrarIdVenta_RS(String condicion, String orden) throws Exception{
        ResultSet resultado;
       ADFacturaVenta adfacturaventa;
        try {
            adfacturaventa=new ADFacturaVenta();
            resultado = adfacturaventa.MostrarIdVenta_RS(condicion, orden);
         
        } catch (Exception e) {
            throw e;
        }return resultado;
    }// final listar cliente
    
     public FacturaVenta ObtenerFacturaVenta(String condicion) throws Exception{
       FacturaVenta facturaVenta;
         ADFacturaVenta adfacturaventa;
        try {
            adfacturaventa= new ADFacturaVenta();
            facturaVenta=adfacturaventa.ObtenerFacturaVenta(condicion);
            if (facturaVenta.isExiste()) {
                _mensaje="factura recuperada";
            } else{
                 _mensaje="la factura no existe en la base de datos ";
            }
        } catch (Exception e) {
            throw e;
        }
        return facturaVenta;
    }// fin obtener cliente
    
     
      // LLAMA A LISTAR CLIENTES
    public ResultSet ListarIDVentas(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADFacturaVenta adfacturaventa;
        try {
            adfacturaventa=new ADFacturaVenta();
            resultado = adfacturaventa.ListarPorId(condicion, orden);
         
        } catch (Exception e) {
            throw e;
        }return resultado;
    }// final listar cliente
        
    
       // LLAMA A LISTAR CLIENTES
    public ResultSet ListarFecha(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADFacturaVenta adfacturaventa;
        try {
            adfacturaventa=new ADFacturaVenta();
            resultado = adfacturaventa.listaPorFecha(condicion, orden);
         
        } catch (Exception e) {
            throw e;
        }return resultado;
    }// final listar cliente
        
   
    public ResultSet MostrarFactura(String condicion, String orden) throws Exception{
        ResultSet resultado;
       ADFacturaVenta adfacturaventa;
        try {
            adfacturaventa=new ADFacturaVenta();
            resultado = adfacturaventa.MostraFactura(condicion, orden);
         
        } catch (Exception e) {
            throw e;
        }return resultado;
    }// final listar cliente
    
}//final
    
    
  


