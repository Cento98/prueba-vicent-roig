package es.nextdigital.demo.models;

public class Cuenta {
    
    private Double saldo;
    private Movimientos movimientos;
    private int codBanco;
    private String iban;

    public int getCodBanco() {
        return codBanco;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public Movimientos getMovimientos() {
        return movimientos;
    }
    public String getIban() {
        return iban;
    }
}
