package Entidades;

/**
 *
 * @author Jafet
 */
public class Carro {
    
    private int idCarro;
    private int idCliente;
    private String marca;
    private String placa;
    private boolean existe;
    
    
    public Carro(int idCarro, int idCliente, String marca, String placa, boolean existe) {
        this.idCarro = idCarro;
        this.idCliente = idCliente;
        this.marca = marca;
        this.placa = placa;
        this.existe = existe;
    }
    
    
    // sobrecarga
      public Carro(int idCarro, int idCliente, String marca, String placa) {
        this.idCarro = idCarro;
        this.idCliente = idCliente;
        this.marca = marca;
        this.placa = placa;
    }
    
       
    public Carro() {
        this.idCarro = 0;
        this.idCliente = 0;
        this.marca = "";
        this.placa = "";
        this.existe = false;
    }
    
    
    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }


}// final de carro