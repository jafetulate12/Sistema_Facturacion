package Entidades;

/**
 *
 * @author jafet
 */

// clase que va heredar a clientes y a productos

public class Super_Persona {

    public String nombre;
    public String telefono;
    public String cedula;
    public String correo;
    public boolean  existe;
    
    
    public Super_Persona(String nombre, String telefono, String cedula,String  correo,boolean  existe) {
          this.nombre = nombre;
          this.telefono = telefono;
          this.cedula = cedula;
          this.correo = correo;
          this.existe = existe;
       }
    
    public Super_Persona(String nombre, String telefono, String cedula,String  correo) {
          this.nombre = nombre;
          this.telefono = telefono;
          this.cedula = cedula;
          this.correo = correo;
       }
    
    public Super_Persona() {
              nombre="";
              telefono="";
              cedula="";
              correo="";
              existe=false;
     }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
