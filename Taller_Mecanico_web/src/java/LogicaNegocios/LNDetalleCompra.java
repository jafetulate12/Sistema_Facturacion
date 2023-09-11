
package LogicaNegocios;

import AccesoDatos.ADAdministrador;
import AccesoDatos.ADDetalleCompra;
import Entidades.Administrador;
import Entidades.DetalleCompra;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jafet
 */
public class LNDetalleCompra {
     
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
     //llamar insertar de acceso a datos
    public int InsertarDetalleCompra(DetalleCompra detalleCompra) throws Exception{
        int id=-1;
            ADDetalleCompra addetallecompra;
        try {
            addetallecompra= new ADDetalleCompra();
            id=addetallecompra.InsertarDetalleCompraTEMP(detalleCompra);
            _mensaje=addetallecompra.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }//Fin Insertar Cliente
     
    
      public int ActualizarFacturaCompra(DetalleCompra detalleCompra) throws Exception{
        int id=-1;
            ADDetalleCompra addetallecompra;
        try {
            addetallecompra= new ADDetalleCompra();
            id=addetallecompra.ActualizarFacturaCompra(detalleCompra);
            _mensaje=addetallecompra.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }//Fin Insertar Cliente
    
    
    
    
    
      public List<DetalleCompra> ListarDetalleCompra_list(String condicion) throws Exception{
        List<DetalleCompra> resultado = new ArrayList();
       ADDetalleCompra addetallecompra;
        try {
            addetallecompra=new ADDetalleCompra();
            resultado = addetallecompra.ListarDetalleCompra_list(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//ListarClientes_Rs
      
      
     
    
   
    
       //LLAMADO A OBTENER 
    //llamar a obtener un client
    public DetalleCompra ObtenerDetalle(String condicion) throws Exception{
        DetalleCompra detalleCompra;
        ADDetalleCompra addetallecompra;
        try {
            addetallecompra= new ADDetalleCompra();
            detalleCompra=addetallecompra.ObtenerDetalleCompra(condicion);
            if (detalleCompra.isExiste()) {
                _mensaje="Cliente recuperado";
            } else{
                 _mensaje="Cliente no existe en la base de datos ";
            }
        } catch (Exception e) {
            throw e;
        }
        return detalleCompra;
    }// fin obtener cliente
    
   //ELIMINAR un cliente
    public int EliminarDetalle(DetalleCompra detallecompra) throws Exception{
        ADDetalleCompra addetallecompra;
        int resultado =-1;
        try {
            addetallecompra=new ADDetalleCompra();
            resultado=addetallecompra.EliminarDetalle(detallecompra);
            _mensaje=addetallecompra.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//EliminarCliente
}// final
