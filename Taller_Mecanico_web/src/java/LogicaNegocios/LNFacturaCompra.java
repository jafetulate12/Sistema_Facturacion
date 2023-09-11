/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocios;



import AccesoDatos.ADFacturaCompra;

import Entidades.FacturaCompra;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class LNFacturaCompra {
      //atributos
        private String _mensaje;
        
        // get
    public String getMensaje() {
        return _mensaje;
    }
     // LLAMA A INSERTAR
    // llamar a insertar de acceso a datos
   //llamar insertar de acceso a datos
    public int InsertarFacturaCompra(FacturaCompra facturacompra) throws Exception{
        int id=-1;
        ADFacturaCompra  adfacturacompra;
        try {
            adfacturacompra= new ADFacturaCompra();
            id=adfacturacompra.InsertarFacturaCompra(facturacompra);
            _mensaje=adfacturacompra.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }//Fin Insertar Cliente
    
 // LLAMA A LISTAR CLIENTES
    public ResultSet MostrarIdCompra_RS(String condicion, String orden) throws Exception{
        ResultSet resultado;
        ADFacturaCompra adfacturacompra;
        try {
            adfacturacompra=new ADFacturaCompra();
            resultado = adfacturacompra.MostrarIdCompra_RS(condicion, orden);
         
        } catch (Exception e) {
            throw e;
        }return resultado;
    }// final listar cliente
    
     public FacturaCompra ObtenerFacturaCompra(String condicion) throws Exception{
        FacturaCompra facturaCompra;
        ADFacturaCompra adfacturacompra;
        try {
            adfacturacompra= new ADFacturaCompra();
            facturaCompra=adfacturacompra.ObtenerFacturaCompra(condicion);
            if (facturaCompra.isExiste()) {
                _mensaje="factura recuperada";
            } else{
                 _mensaje="la factura no existe en la base de datos ";
            }
        } catch (Exception e) {
            throw e;
        }
        return facturaCompra;
    }// fin obtener cliente
    
      
}
