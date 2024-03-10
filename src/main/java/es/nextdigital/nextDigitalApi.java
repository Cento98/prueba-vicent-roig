package es.nextdigital;

import java.util.ArrayList;
import java.util.List;
import es.nextdigital.demo.models.Cuenta;

public class nextDigitalApi {

    private final String INGRESO = "ING";
    private final String RETIRO = "RET";
    private final String COMISION = "COMI";
    private final String TRANSFERENCIAE = "ENT";
    private final String TRANSFERENCIAS = "SAL";
    
    private List<String> consultarMovimientos (Cuenta cuenta, String codigo){
        List<String> salida = new ArrayList<String>();
        if(codigo.equals(INGRESO)){
            salida = movimientosToString(cuenta.getMovimientos().getListaIngresos(), "Ingreso: ");
        }
        else if (codigo.equals(RETIRO)){
            salida = movimientosToString(cuenta.getMovimientos().getListaRetiros(), "Retiro: ");
        }
        else if (codigo.equals(COMISION)){
            salida = movimientosToString(cuenta.getMovimientos().getListaComisiones(), "Comision: ");
        }
        else if (codigo.equals(TRANSFERENCIAE)){
            salida = movimientosToString(cuenta.getMovimientos().getListaTransferenciaEntrantes(), "Transferencias Entrantes: ");
        }
        else if (codigo.equals(TRANSFERENCIAS)){
            salida = movimientosToString(cuenta.getMovimientos().getListaTransferenciaSalientes(), "Transferencias Salientes: ");
        }
        return salida;
    }

    private List<String> movimientosToString(List<Double> movimientos, String texto){
        List<String> salida = new ArrayList<String>();
        for (Double item : movimientos) {
            salida.add(texto + item.toString());
        }
        return salida;
    }
}
