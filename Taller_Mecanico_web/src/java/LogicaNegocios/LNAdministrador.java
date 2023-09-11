
package LogicaNegocios;
import AccesoDatos.ADAdministrador;
import AccesoDatos.ADAdministrador;
import Entidades.Administrador;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class LNAdministrador {
    //Atributos
    private String _mensaje;
    
    public String getMensaje() {
        return _mensaje;
    }
    //llamar insertar de acceso a datos
    public int InsertarAdministrador(Administrador administrador) throws Exception{
        int id=-1;
        ADAdministrador adadministrador;
        try {
            adadministrador= new ADAdministrador();
            id=adadministrador.InsertarAdministrador(administrador);
            _mensaje=adadministrador.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }//Fin Insertar Cliente

    public List<Administrador> ListarAdministrador_List(String condicion) throws Exception{
        List<Administrador> resultado = new ArrayList();
        ADAdministrador adadministrador;
        try {
            adadministrador=new ADAdministrador();
            resultado = adadministrador.ListarAdministrador_List(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//ListarClientes_Rs
    
    //obtener un cliente
    public Administrador ObtenerAdministrador(String condicion) throws Exception{
        Administrador administrador;
        ADAdministrador adadministrador;
        try {
            adadministrador=new ADAdministrador();
            administrador=adadministrador.ObteneraAdministrador(condicion);
            if(administrador.isExiste()){
                _mensaje="administrador Recuperado";
            }else{
                _mensaje="administrador no existe en la BD";
            }
        } catch (Exception e) {
            throw e;
        }
        return administrador;
    }//ObtenerCliente
    

    
    //ELIMINAR un cliente
    public int EliminarCliente(Administrador administrador) throws Exception{
        ADAdministrador adadministrador;
        int resultado =-1;
        try {
            adadministrador=new ADAdministrador();
            resultado=adadministrador.EliminarAdministrador(administrador);
            _mensaje=adadministrador.getMensaje();
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//EliminarCliente
}// final de todo
