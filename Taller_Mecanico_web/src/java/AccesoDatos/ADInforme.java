/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoDatos;

/**
 *
 * @author Usuario
 */
import static AccesoDatos.ClaseConexion.getcConnection;
import Entidades.Informe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ADInforme {
      // atributos
    private Connection _cnn;
    private String _mensaje;
    
    public String getMensaje(){
        return _mensaje;
        
    }
    
    
     public ADInforme() throws Exception{

            _mensaje="";

    }// final cosntructor
    
      //listar Clientes
    public List<Informe> Listarinformes_List(String condicion) throws Exception{
        ResultSet rs=null;
        Informe informe;
        List<Informe> lista = new ArrayList();
        Connection _conexion=null;
        try {
            //abrir la coneccion 
           _conexion=ClaseConexion.getcConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "SELECT A.NOMBREADMINISTRADOR AS Administrador, C.NOMBRECLIENTE AS Cliente,  \n" +
"       F.FECHA AS Fecha, F.TOTALVENTA AS TotalVenta\n" +
"FROM FACTURAVENTA F \n" +
"INNER JOIN ADMINISTRADOR A ON F.IDADMINISTRADOR = A.IDADMINISTRADOR \n" +
"INNER JOIN CLIENTE C ON F.IDCLIENTE = C.IDCLIENTE\n" +
"WHERE F.TOTALVENTA IS NOT NULL";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s" , sentencia, condicion);
            }
            rs=stm.executeQuery(sentencia);
            while(rs.next()){
                informe = new Informe(rs.getString(1),rs.getString(2),rs.getDate(3),rs.getDouble(4));
                lista.add(informe);
            }
        } catch (Exception ex) {throw ex;}
        finally{
            if(!_conexion.equals(null)){
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
    }//ListarClientes_List
     
     
     
}
