package es.nextdigital.demo.models;

public class Tarjeta {
    
    private Cuenta cuenta;
    private String tipo;
    private int max;
    private int creditoEntregado;
    private int estado;
    
    public Cuenta getCuenta() {
        return cuenta;
    }
    public String getTipo() {
        return tipo;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public int getMax() {
        return max;
    }
    public int getCreditoEntregado() {
        return creditoEntregado;
    }
    public void setCreditoEntregado(int creditoEntregado) {
        this.creditoEntregado = creditoEntregado;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
