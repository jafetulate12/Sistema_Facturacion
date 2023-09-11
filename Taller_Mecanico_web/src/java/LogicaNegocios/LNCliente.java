package LogicaNegocios;

import AccesoDatos.ADCliente;
import Entidades.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LNCliente {

    //Atributos
    private String _mensaje;
    
    public String getMensaje() {
        return _mensaje;
    }
    //llamar insertar de acceso a datos
    public int InsertarCliente(Cliente cliente) throws Exception{
        int id=-1;
        ADCliente adcliente;
        try {
            adcliente= new ADCliente();
            id=adcliente.InsertarCliente(cliente);
            _mensaje=adcliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }//Fin Insertar Cliente
    

    public List<Cliente> ListarClientes_List(String condicion) throws Exception{
        List<Cliente> resultado = new ArrayList();
        ADCliente adcliente;
        try {
            adcliente=new ADCliente();
            resultado = adcliente.ListarClientes_List(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//ListarClientes_Rs
    
    //obtener un cliente
    public Cliente ObtenerCliente(String condicion) throws Exception{
        Cliente cliente;
        ADCliente adcliente;
        try {
            adcliente=new ADCliente();
            cliente=adcliente.ObtenerCliente(condicion);
            if(cliente.isExiste()){
                _mensaje="Cliente Recuperado";
            }else{
                _mensaje="Cliente no existe en la BD";
            }
        } catch (Exception e) {
            throw e;
        }
        return cliente;
    }//ObtenerCliente
    
    /*//Modificar un cliente
    public int ModificarCliente(Cliente cliente) throws Exception{
        ADCliente adcliente;
        int resultado =-1;
        try {
            adcliente=new ADCliente();
            resultado=adcliente.ModificarCliente(cliente);
            _mensaje=adcliente.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//ModificarCliente*/
    
    //ELIMINAR un cliente
    public int EliminarCliente(Cliente cliente) throws Exception{
        ADCliente adcliente;
        int resultado =-1;
        try {
            adcliente=new ADCliente();
            resultado=adcliente.EliminarCliente(cliente);
            _mensaje=adcliente.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//EliminarCliente
    
    //Eliminar Cliente con SP
//    public int Eliminar_Cliente_SP(Cliente cliente) throws Exception{
//        int res=-1;
//        ADCliente adcliente;
//        try {
//            adcliente=new ADCliente();
//            res= adcliente.Eliminar_Cliente_SP(cliente);
//            _mensaje=adcliente.getMensaje();
//        } catch (Exception e) {
//            throw e;
//        }
//        return res;
//    }// Fin eliminar Cliente con SP
    
}//Fin Clase
