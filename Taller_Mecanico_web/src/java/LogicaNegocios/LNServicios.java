
package LogicaNegocios;


import AccesoDatos.ADServicios;


import Entidades.Servicios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jafet
 */
public class LNServicios {
    
    //atributos
        private String _mensaje;
        
        // get
    public String getMensaje() {
        return _mensaje;
    }
  
        
        
        // LLAMA A LISTAR CLIENTES array list
    public List<Servicios> ListarServicios_List(String condicion) throws Exception{
        List<Servicios> resultado = new ArrayList();
         ADServicios adservicios;

        try {
            adservicios=new ADServicios();
            resultado = adservicios.listarServicios(condicion);
        } catch (Exception e) {
            throw e;
        }return resultado;
    }// final listar cliente array list
    
    

    }//ListarClientes_Rs
        
        
       
