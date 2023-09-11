package Entidades;

/**
 *
 * @author Jafet
 */
public class Mecanico extends Super_Persona{
    // atributos
    private int idMecanico;
   
    // constructor con parametros
    public Mecanico(int idMecanico, String nombre, String telefono, String cedula, String correo,boolean existe) {
        super(nombre, telefono, cedula, correo, existe);
        this.idMecanico = idMecanico;
    }
    
    // constructor con parametros
    public Mecanico(int idMecanico, String nombre, String telefono, String cedula, String correo) {
        super(nombre, telefono, cedula, correo);
        this.idMecanico = idMecanico;
    }
    
  public Mecanico() {
        // Llamando al constructor de la clase padre (Persona)
        super();
        this.idMecanico = 0; 
    }
  
  // get set
      public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }
}// final clase 
