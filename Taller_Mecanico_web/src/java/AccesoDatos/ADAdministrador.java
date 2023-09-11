/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;
import java.sql.*;
import java.util.*;
import Entidades.Administrador;

import static AccesoDatos.ClaseConexion.getcConnection;

public class ADAdministrador {
     //Atributos
    private String _mensaje;
    
    //Propiedades
    public String getMensaje(){
        return _mensaje;
    }
    //constructor
    public ADAdministrador(){
        _mensaje="";
    }
    
    
    
    //listar Clientes
    public List<Administrador> ListarAdministrador_List(String condicion) throws Exception{
        ResultSet rs=null;
        Administrador administrador;
        List<Administrador> lista = new ArrayList();
        Connection _conexion=null;
        try {
            //abrir la coneccion
            _conexion=ClaseConexion.getcConnection();
            Statement stm = _conexion.createStatement();
          String sentencia="SELECT IDADMINISTRADOR, NOMBREADMINISTRADOR, TELEFONOADMINISTRADOR, CEDULAADMINISTRADOR, CORREOADMINISTRADOR FROM ADMINISTRADOR";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs=stm.executeQuery(sentencia);
            while(rs.next()){
                administrador = new Administrador(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                lista.add(administrador);
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
    public int InsertarAdministrador(Administrador administrador) throws Exception{
        int resultado = -1;
        CallableStatement cs = null;
        Connection _conexion =null;
        try {
            _conexion=getcConnection();
            cs=_conexion.prepareCall("{call GUARDARADMISTRADOR(?,?,?,?,?,?)}");
            //parametros de entrada
            cs.setInt(1, administrador.getIdAdministrador());
            cs.setString(2,administrador.getNombre());
            cs.setString(3,administrador.getTelefono());
            cs.setString(4,administrador.getCedula());
            cs.setString(5,administrador.getCorreo());
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
    
    
    
    //Obtener un admin
    //Falta Implementar
    public Administrador ObteneraAdministrador(String condicion) throws Exception {
      ResultSet rs=null;
      Administrador administrador = new Administrador();
      String sentencia;
        Connection _conexion = null;
        try {
            _conexion=getcConnection();
            Statement st= _conexion.createStatement();
             sentencia="SELECT IDADMINISTRADOR, NOMBREADMINISTRADOR, TELEFONOADMINISTRADOR, CEDULAADMINISTRADOR, CORREOADMINISTRADOR FROM ADMINISTRADOR";
            if (!condicion.equals("")) {
                sentencia = String.format("%s where %s",sentencia,condicion);
            }
            rs=st.executeQuery(sentencia);
            if (rs.next()) {
                administrador.setIdAdministrador(rs.getInt(1));
                administrador.setNombre(rs.getString(2));
                administrador.setTelefono(rs.getString(3));
                administrador.setCedula(rs.getString(4));
                administrador.setCorreo(rs.getString(5));
                administrador.setExiste(true);
            }else{
                administrador.setExiste(false);
            }
            
        
        } catch (Exception ex) {
            throw ex;
        }
        finally{
            if (!_conexion.equals(null)) {
                ClaseConexion.close(_conexion);
            }
        }
        return administrador;
    }
    

    //EliminarCliente Cliente
    //Falta Implementar
    public int EliminarAdministrador(Administrador administrador)throws Exception {
        
       CallableStatement CS= null;
       int resultado = -1;
       Connection _conexion=null;
        try {
            _conexion=ClaseConexion.getcConnection();
            // registrar paraamtros
            CS = _conexion.prepareCall("{call Eliminar_A(?,?)}");
            CS.setInt(1,administrador.getIdAdministrador());
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
    
    
    
    
    
    
    
    
    
    
}// final de todo;
