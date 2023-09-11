/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LogicaNegocios;

/**
 *
 * @author Usuario
 */
import AccesoDatos.ADInforme;

import Entidades.Informe;
import java.util.ArrayList;
import java.util.List;
public class LNinforme {
    
    
     //atributos
        private String _mensaje;
        
        // get
    public String getMensaje() {
        return _mensaje;
    }
    
    public List<Informe> ListarInforme_List(String condicion) throws Exception{
        List<Informe> resultado = new ArrayList();
        ADInforme adinforme;
        try {
            adinforme=new ADInforme();
            resultado = adinforme.Listarinformes_List(condicion);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }//ListarClientes_Rs
}
