package Entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Jafet
 */
public class FacturaCompra {
    
    public int idFacturaCompra;
    public int idAdministrador;
    private Date fecha;
    private BigDecimal totalCompra;
    private boolean existe;
   

    public FacturaCompra(int idFacturaCompra, int idAdministrador, Date fecha, BigDecimal totalCompra, boolean existe) {
        this.idFacturaCompra = idFacturaCompra;
        this.idAdministrador = idAdministrador;
        this.fecha = fecha;
        this.totalCompra = totalCompra;
        this.existe = existe;
    }
    public FacturaCompra(int idFacturaCompra, int idAdministrador, Date fecha, BigDecimal totalCompra) {
        this.idFacturaCompra = idFacturaCompra;
        this.idAdministrador = idAdministrador;
        this.fecha = fecha;
        this.totalCompra = totalCompra;
    }

        public FacturaCompra() {
        this.idFacturaCompra = 0;
        this.idAdministrador = 0;
         this.fecha= Date.valueOf(LocalDate.MAX); 
        this.totalCompra = BigDecimal.ZERO;
        this.existe = false;
    }

    
    public int getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(int idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
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
    

    
    
    
    
    
    
    
    
    
    
}// final de clase Factura compra
