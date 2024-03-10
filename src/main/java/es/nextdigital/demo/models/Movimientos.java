package es.nextdigital.demo.models;

import java.util.ArrayList;
import java.util.List;

public class Movimientos {
    
    private List<Double> listaIngresos;
    private List<Double> listaRetiros;
    private List<Double> listaComisiones;
    private List<Double> listaTransferenciaEntrantes;
    private List<Double> listaTransferenciaSalientes;

    public Movimientos(){
        this.listaIngresos = new ArrayList<Double>();
        this.listaRetiros = new ArrayList<Double>();
        this.listaComisiones = new ArrayList<Double>();
        this.listaTransferenciaEntrantes = new ArrayList<Double>();
        this.listaTransferenciaSalientes = new ArrayList<Double>();
    }

    public List<Double> getListaIngresos() {
        return listaIngresos;
    }

    public void setIngreso(Double ingreso) {
        listaIngresos.add(ingreso);
    }

    public List<Double> getListaRetiros() {
        return listaRetiros;
    }

    public void setRetiro(Double retiro) {
        listaRetiros.add(retiro);
    }

    public List<Double> getListaComisiones() {
        return listaComisiones;
    }

    public void setComision(Double comision) {
        listaComisiones.add(comision);
    }

    public List<Double> getListaTransferenciaEntrantes() {
        return listaTransferenciaEntrantes;
    }

    public void setTransferenciaEntrante(Double transferenciaEntrante) {
        listaTransferenciaEntrantes.add(transferenciaEntrante);
    }

    public List<Double> getListaTransferenciaSalientes() {
        return listaTransferenciaSalientes;
    }

    public void setTransferenciaSaliente(Double transferenciaSaliente) {
        listaTransferenciaSalientes.add(transferenciaSaliente);
    }


}
