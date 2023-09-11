package Entidades;
/**
 *
 * @author Jafet
 */
public class Administrador  extends Super_Persona {

// atributos
    private int idAdministrador;
   
    // constructor con parametros
    public Administrador(int idAdministrador, String nombre, String telefono, String cedula, String correo,boolean existe) {
        super(nombre, telefono, cedula, correo, existe);
        this.idAdministrador = idAdministrador;
    }
    
    // constructor con parametros
    public Administrador(int idAdministrador, String nombre, String telefono, String cedula, String correo) {
        super(nombre, telefono, cedula, correo);
        this.idAdministrador = idAdministrador;
    }
    
  public Administrador() {
        // Llamando al constructor de la clase padre (Persona)
        super();
        this.idAdministrador = 0; 
    }
  
  // get y set
  
    public int getIdAdministrador() {
        return idAdministrador;
    }

   
    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }
}// final de la clase Administrador
