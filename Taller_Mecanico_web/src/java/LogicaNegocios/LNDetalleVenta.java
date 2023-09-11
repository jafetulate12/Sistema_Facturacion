
package LogicaNegocios;

import AccesoDatos.ADDetalleCompra;
import AccesoDatos.ADDetalleVenta;
import Entidades.DetalleCompra;
import Entidades.DetalleVenta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jafet
 */
public class LNDetalleVenta {
    
    
     
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
    
      // LLAMA A INSERTAR
    // llamar a insertar de acceso a datos
    public int InsertarDetalleVenta(DetalleVenta detalleVenta) throws Exception{
        int id=-1;
        ADDetalleVenta addetalleventa;
        try {
            addetalleventa= new ADDetalleVenta();
            id=addetalleventa.InsertarVentaCompraTEMP(detalleVenta);
            _mensaje=addetalleventa.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }
    
    
    
       // LLAMA A INSERTAR
    // llamar a insertar de acceso a datos
    public int InsertarDetalleVentaSer(DetalleVenta detalleVenta) throws Exception{
        int id=-1;
        ADDetalleVenta addetalleventa;
        try {
            addetalleventa= new ADDetalleVenta();
            id=addetalleventa.InsertarVentaSerCompraTEMP(detalleVenta);
            _mensaje=addetalleventa.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }
    
      // llamar a insertar de acceso a datos
    public int actualizarIdFacVenta(DetalleVenta detalleVenta) throws Exception{
        int id=-1;
        ADDetalleVenta addetalleventa;
        try {
            addetalleventa= new ADDetalleVenta();
            id=addetalleventa.ActualizarFacturaCompra(detalleVenta);
            _mensaje=addetalleventa.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }
    
    
    
     public List<DetalleVenta> ListarDetalleVenta_list(String condicion) throws Exception{
        List<DetalleVenta> resultado = new ArrayList();
       ADDetalleVenta addetalleventa;
        try {
            addetalleventa=new ADDetalleVenta();
            resultado = addetalleventa.ListarDetalleVenta_list(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//ListarClientes_Rs
     
     
         public int EliminarDetalleVenta(DetalleVenta detalleventa) throws Exception{
        ADDetalleVenta addetalleventa;
        int resultado =-1;
        try {
            addetalleventa=new ADDetalleVenta();
            resultado=addetalleventa.EliminarDetalle(detalleventa);
            _mensaje=addetalleventa.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//EliminarCliente
     

     
}// final
