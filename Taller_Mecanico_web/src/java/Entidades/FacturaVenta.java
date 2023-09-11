package Entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
    * @author Jafet 
 */
public class FacturaVenta {

    
     private int idFacturaVenta;
    private int idAdministrador;
    private int idCliente;
    private Date fecha;
    private BigDecimal totalCompra;
    private boolean existe;
    
    public FacturaVenta() {
        this.idFacturaVenta = 0;
        this.idAdministrador = 0;
        this.idCliente = 0;
        this.fecha= Date.valueOf(LocalDate.now()); 
        this.totalCompra = BigDecimal.ZERO;
        this.existe = false;
    }
    
    
    
    public FacturaVenta(int idFacturaVenta, int idAdministrador, int idCliente, Date fecha, BigDecimal totalCompra, boolean existe) {
        this.idFacturaVenta = idFacturaVenta;
        this.idAdministrador = idAdministrador;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.totalCompra = totalCompra;
        this.existe = existe;
    }

    public FacturaVenta(int idFacturaVenta, int idAdministrador, int idCliente, Date fecha, BigDecimal totalCompra) {
        this.idFacturaVenta = idFacturaVenta;
        this.idAdministrador = idAdministrador;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.totalCompra = totalCompra;
    }

    public int getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    

    
}// final Factura Venta
