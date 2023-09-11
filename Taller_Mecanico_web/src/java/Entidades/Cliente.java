package Entidades;
/**
 *
 * @author Jafet
 */
public class Cliente extends Super_Persona{

  // atributos
    private int idCliente;
   
    // constructor con parametros
    public Cliente(int idCliente, String nombre, String telefono, String cedula, String correo,boolean existe) {
        super(nombre, telefono, cedula, correo, existe);
        this.idCliente = idCliente;
    }
    
    // constructor con parametros
    public Cliente(int idCliente, String nombre, String telefono, String cedula, String correo) {
        super(nombre, telefono, cedula, correo);
        this.idCliente = idCliente;
    }
    
  public Cliente() {
        // Llamando al constructor de la clase padre (Persona)
        super();
        this.idCliente = 0; 
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
