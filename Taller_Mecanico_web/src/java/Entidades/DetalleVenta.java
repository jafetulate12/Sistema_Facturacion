
package Entidades;

import java.math.BigDecimal;

/**
 *
 * @author Jafet
 */
public class DetalleVenta {
    
    
    private int idDetalleVenta;
    private int idFacturaVenta;
    private int idRefaccion;
    private String nombreRefaccion;
    private int cantidad;
    private double subtotal;
    private int idServicios;
    private String nombreServicios;
    private boolean existe;
    private double precioFinal;
    
    
      
      public DetalleVenta() {
        this.idDetalleVenta = 0;
        this.idFacturaVenta = 0;
        this.idRefaccion = 0;
        this.nombreRefaccion = "";
        this.idServicios = 0;
        this.nombreServicios = "";
        this.cantidad = 0;
        this.subtotal = 0;
    }
    
    public DetalleVenta(int idDetalleVenta, int idFacturaVenta, int idRefaccion, String nombreRefaccion, int cantidad, double subtotal, int idServicios, String nombreServicios, boolean existe, double precioFinal) {
        this.idDetalleVenta = idDetalleVenta;
        this.idFacturaVenta = idFacturaVenta;
        this.idRefaccion = idRefaccion;
        this.nombreRefaccion = nombreRefaccion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.idServicios = idServicios;
        this.nombreServicios = nombreServicios;
        this.existe = existe;
        this.precioFinal = precioFinal;
    }

    
        public DetalleVenta(int idDetalleVenta, int idFacturaVenta, int idRefaccion, String nombreRefaccion, int cantidad, double subtotal, int idServicios, String nombreServicios) {
        this.idDetalleVenta = idDetalleVenta;
        this.idFacturaVenta = idFacturaVenta;
        this.idRefaccion = idRefaccion;
        this.nombreRefaccion = nombreRefaccion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.idServicios = idServicios;
        this.nombreServicios = nombreServicios;

    }

    
        public DetalleVenta(int idDetalleVenta, int idFacturaVenta, int idRefaccion,  int cantidad, int idServicios ,double subtotal) {
        this.idDetalleVenta = idDetalleVenta;
        this.idFacturaVenta = idFacturaVenta;
        this.idRefaccion = idRefaccion;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.idServicios = idServicios;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
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

    public int getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(int idServicios) {
        this.idServicios = idServicios;
    }

    public String getNombreServicios() {
        return nombreServicios;
    }

    public void setNombreServicios(String nombreServicios) {
        this.nombreServicios = nombreServicios;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }



    

    
    
    
}// final de la entidad detalle venta
