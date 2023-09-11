
package Entidades;

/**
 *
 * @author Jafet
 */
public class Inventario {

    private int idInventario;
    private int idRefaccion;
    private int cantidad;
    private double precioUnitario;
    private String nombre;
    private boolean existe;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    
    
    public Inventario(int idInventario, int idRefaccion, int cantidad, boolean existe) {
        this.idInventario = idInventario;
        this.idRefaccion = idRefaccion;
        this.cantidad = cantidad;
        this.existe = existe;
    }
        public Inventario(int idInventario, int idRefaccion, int cantidad) {
        this.idInventario = idInventario;
        this.idRefaccion = idRefaccion;
        this.cantidad = cantidad;
    }  
        
      public Inventario(int idInventario, int idRefaccion,String nombre , double precioUnitario, int cantidad) {
        this.idInventario = idInventario;
        this.idRefaccion = idRefaccion;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }
        
    public Inventario() {
        this.idInventario = 0;
        this.idRefaccion = 0;
        this.cantidad = 0;
        this.existe = false;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
        

    
    
    
    
}// final clase inventario
