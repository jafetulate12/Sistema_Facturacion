package Entidades;

/**
 *
 * @author Jafet
 */

public class Refaccion {
    
  private int idRefaccion;
    private String codigo;
    private String nombre;
    private double  precio;


    
    private int cantidad;
    
    private boolean existe;
    
    public Refaccion(int idRefaccion, String codigo, String nombre, double precio, boolean existe) {
        this.idRefaccion = idRefaccion;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.existe = existe;
    }
    
        public Refaccion(int idRefaccion, String codigo, String nombre, double precio) {
        this.idRefaccion = idRefaccion;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
        public Refaccion() {
            this.idRefaccion = 0;
            this.codigo = "";
            this.nombre = "";
            this.precio = 0.0;
             this.existe = false;
                }
    

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
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
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
  
    }// final

    
    
    
    
    
    
    
    
    
    
    

