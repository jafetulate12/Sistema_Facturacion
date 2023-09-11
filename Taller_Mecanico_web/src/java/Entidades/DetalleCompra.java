
package Entidades;

import java.math.BigDecimal;

/**
 *
 * @author Jafet
 */
public class DetalleCompra {
    
    
    private int idDetalleCompra;
    private int idFacturaCompra;
    private int idRefaccion;
    private String nombreRefaccion;
    private int cantidad;
    private double subtotal;
    private boolean existe;
    private double precioFinal;
    
    
    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
    


    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public int getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(int idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public int getIdRefaccion() {
        return idRefaccion;
    }

    public void setIdRefaccion(int idRefaccion) {
        this.idRefaccion = idRefaccion;
    }

    public String getNombreRefaccion() {
        return nombreRefaccion;
    }

    public void setNombreRefaccion(String nombreRefaccion) {
        this.nombreRefaccion = nombreRefaccion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public DetalleCompra(int idDetalleCompra, int idFacturaCompra, int idRefaccion, String nombreRefaccion, int cantidad, double subtotal, boolean existe) {
        this.idDetalleCompra = idDetalleCompra;
        this.idFacturaCompra = idFacturaCompra;
        this.idRefaccion = idRefaccion;
        this.nombreRefaccion = nombreRefaccion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.existe = existe;
    }

    
        public DetalleCompra() {
        this.idRefaccion = 0;
        this.cantidad = 0;
        this.subtotal = 0;
    }
 
    

            public DetalleCompra(int idDetalleCompra, int idFacturaCompra, int idRefaccion, int cantidad, double subtotal) {
        this.idDetalleCompra = idDetalleCompra;
        this.idFacturaCompra = idFacturaCompra;
        this.idRefaccion = idRefaccion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
 
        public DetalleCompra( int idRefaccion, int cantidad, double subtotal) {
        this.idRefaccion = idRefaccion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    
    
    
}// final
