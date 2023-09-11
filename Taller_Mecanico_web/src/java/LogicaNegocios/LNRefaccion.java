
package LogicaNegocios;


import AccesoDatos.ADRefaccion;

import Entidades.Refaccion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jafet
 */
public class LNRefaccion {
    
     //atributos
        private String _mensaje;
        
        // get
    public String getMensaje() {
        return _mensaje;
    }
    
    
     public List<Refaccion> ListarRefaccion_List(String condicion) throws Exception{
        List<Refaccion> resultado = new ArrayList();
        ADRefaccion adrefaccion;
        try {
            adrefaccion=new ADRefaccion();
            resultado = adrefaccion.ListarClientes_List(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//ListarClientes_Rs
    
    
    //LLAMADO A OBTENER 
    //llamar a obtener un client
    public Refaccion ObtenerRefaccion(String condicion) throws Exception{
        Refaccion refaccion;
        ADRefaccion adrefaccion;
        try {
            adrefaccion= new ADRefaccion();
            refaccion=adrefaccion.ObtenerRefaccion(condicion);
            if (refaccion.isExiste()) {
                _mensaje="mecanico recuperado";
            } else{
                 _mensaje="mecanico no existe en la base de datos ";
            }
        } catch (Exception e) {
            throw e;
        }
        return refaccion;
    }
}
    
    
    
    
    
   
