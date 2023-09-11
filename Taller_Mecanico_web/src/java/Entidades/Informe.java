/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Informe {

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String Admin) {
        this.Admin = Admin;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private String Admin;
    private String Cliente;
    private Date Fecha;
    private double total;

    public Informe(String Admin, String Cliente, Date Fecha, double total) {
        this.Admin = Admin;
        this.Cliente = Cliente;
        this.Fecha = Fecha;
        this.total = total;
    }

    public Informe() {
        this.Admin="" ;
        this.Cliente = "";
        this.Fecha = Date.valueOf(LocalDate.MAX);
        this.total =0;
    }
    
}
