package Entidades;
import java.sql.Date;
import java.math.BigDecimal;
/**
 *
 * @author Jafet
 */
public class Servicios {

    
    private int idServicios;
    private int idMecanico;
    private String nombreServicio;
    private Date fechaServicio;
    public String campoServicio;
    private double  precioServicio;
    private boolean existe;
    
    
    
    public Servicios(int idServicios, int idMecanico, String nombreServicio, Date fechaServicio,String campoServicio, double precioServicio,boolean existe) {
        this.idServicios = idServicios;
        this.idMecanico = idMecanico;
        this.nombreServicio = nombreServicio;
        this.fechaServicio = fechaServicio;
        this.campoServicio = campoServicio;
        this.precioServicio = precioServicio;
        this.existe = existe;
    }
    
    public Servicios(int idServicios, int idMecanico, String nombreServicio, Date fechaServicio,String campoServicio, double precioServicio) {
        this.idServicios = idServicios;
        this.idMecanico = idMecanico;
        this.nombreServicio = nombreServicio;
        this.fechaServicio = fechaServicio;
        this.campoServicio = campoServicio;
        this.precioServicio = precioServicio;
    }
    
    
    public Servicios(){
        this.idServicios = 0;
        this.idMecanico = 0;
        this.nombreServicio = "";
        this.fechaServicio = Date.valueOf("2023-08-20"); // Inicializar a la fecha 20 de agosto de 2023
        this.campoServicio = "";
        this.precioServicio = 0;
        this.existe = false;
   }
    
    
    public int getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(int idServicios) {
        this.idServicios = idServicios;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }
    public String getCampoServicio() {
        return campoServicio;
    }

    public void setCampoServicio(String campoServicio) {
        this.campoServicio = campoServicio;
    }
    
    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
}// final de la clase Servicios

