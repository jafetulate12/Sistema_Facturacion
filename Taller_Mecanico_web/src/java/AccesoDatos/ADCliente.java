
package AccesoDatos;

import Entidades.Cliente;
import java.sql.*;
import java.util.*;

//importar los metodos de la ClaseConesion
import static AccesoDatos.ClaseConexion.getcConnection;

public class ADCliente {
    //Atributos
    private String _mensaje;
    
    //Propiedades
    public String getMensaje(){
        return _mensaje;
    }
    //constructor
    public ADCliente(){
        _mensaje="";
    }
    
    //listar Clientes
    public List<Cliente> ListarClientes_List(String condicion) throws Exception{
        ResultSet rs=null;
        Cliente cliente;
        List<Cliente> lista = new ArrayList();
        Connection _conexion=null;
        try {
            //abrir la coneccion
            _conexion=ClaseConexion.getcConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "SELECT IDCLIENTE, NOMBRECLIENTE, TELEFONOCLIENTE, CEDULACLIENTE, CORREOCLIENTE FROM CLIENTE";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs=stm.executeQuery(sentencia);
            while(rs.next()){
                cliente = new Cliente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(cliente);
            }
        } catch (Exception ex) {throw ex;}
        finally{
            if(!_conexion.equals(null)){
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
    }//ListarClientes_List

    //Insertar un Cliente
    public int InsertarCliente(Cliente cliente) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call GUARDARCLIENTE(?,?,?,?,?,?)}");
            //parametros de entrada
            cs.setInt(1, cliente.getIdCliente());
            cs.setString(2,cliente.getNombre());
            cs.setString(3,cliente.getTelefono());
            cs.setString(4,cliente.getCedula());
            cs.setString(5,cliente.getCorreo());
            cs.setString(6,_mensaje);
            //parametros de salida
            cs.registerOutParameter(6,Types.VARCHAR);
            //ejecuta
            resultado=cs.executeUpdate();
            // leer partametros de salida
            _mensaje=cs.getString(6);
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
    
    
    
    //Obtener un Cliente
    //Falta Implementar
    public Cliente ObtenerCliente(String condicion) throws Exception {
      ResultSet rs=null;
      Cliente cliente = new Cliente();
      String sentencia;
        Connection _conexion = null;
        try {
            _conexion=getcConnection();
            Statement st= _conexion.createStatement();
             sentencia="SELECT IDCLIENTE, NOMBRECLIENTE, TELEFONOCLIENTE, CEDULACLIENTE, CORREOCLIENTE FROM CLIENTE";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs=st.executeQuery(sentencia);
            if (rs.next()) {
                cliente.setIdCliente(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setTelefono(rs.getString(3));
                cliente.setCedula(rs.getString(4));
                cliente.setCorreo(rs.getString(5));
                cliente.setExiste(true);
            }else{
                cliente.setExiste(false);
            }
            
        
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if (!_conexion.equals(null)) {
                ClaseConexion.close(_conexion);
            }
        }
        return cliente;
    }
    
    
    
    
   /* //ModificarCliente Cliente

    public int ModificarCliente(Cliente cliente) throws Exception  {
      
        int resultado=-1;
        Connection _conexion = null;
        try {
            _conexion=getcConnection();
            PreparedStatement ps = _conexion.prepareStatement("UPDATE CLIENTES"+"SET NOMBRE=?, TELEFONO=?, DIRECCION=? WHERE ID_CLIENTE=?");
            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getTelefono());
            ps.setString(3,cliente.getDireccion());
            ps.setInt(4,cliente.getId_cliente());
            resultado=ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if (!_conexion.equals(null)) {
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;
    }// final de actualizar*/
    
    
    
    
    
    
    
    //EliminarCliente Cliente
    //Falta Implementar
    public int EliminarCliente(Cliente cliente)throws Exception {
        
       CallableStatement CS= null;
       int resultado = -1;
       Connection _conexion=null;
        try {
            _conexion=ClaseConexion.getcConnection();
            // registrar paraamtros
            CS = _conexion.prepareCall("{call Eliminar(?,?)}");
            CS.setInt(1,cliente.getIdCliente());
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

}// final todo
