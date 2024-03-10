package es.nextdigital;

import java.util.ArrayList;
import java.util.List;
import es.nextdigital.demo.models.Cuenta;
import es.nextdigital.demo.models.Tarjeta;

public class nextDigitalApi {

    private final String INGRESO = "ING";
    private final String RETIRO = "RET";
    private final String COMISION = "COMI";
    private final String TRANSFERENCIAE = "ENT";
    private final String TRANSFERENCIAS = "SAL";
    private final String DEBITO = "DEB";

    private String realizarTransferencia(Cuenta cuentaOrigen, String iban, Double cantidad){

        String salida = "error";

        if(validarIban(iban)){
            Cuenta cuentaDestino = buscarCuenta(iban);
            if(cuentaOrigen.getCodBanco() == cuentaDestino.getCodBanco()){
                cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad);
                cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
                salida = "Transferencia realizada correctamente";
            }
            else{
                if(revisarComision(cuentaDestino.getCodBanco())){
                    //Buscar la comision pertinente en BBDD, en este caso hardcodeamos
                    Double comision = 10.0;
                    cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad - comision);
                    cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
                    salida = "Transferencia realizada correctamente";
                }
                else{
                    cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad);
                    cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
                    salida = "Transferencia realizada correctamente";
                }
            }
        }
        else{
            salida = "IBAN incorrecto";
        }

        return salida;
    }

    private boolean revisarComision(int codBanco){
        //Buscar en BBDD si el banco tiene comision
        return true;
    }

    private Cuenta buscarCuenta(String iban){
        //Busqueda en BBDD de la cuenta asociada al IBAN proporcionado
        Cuenta cuentaDestino = new Cuenta();
        return cuentaDestino;
    }

    private boolean validarIban(String iban){
        //Aquí va un algoritmo que verifique el IBAN
        boolean salida = true;
        return salida;
    }

    private String ingresarDinero(Tarjeta tarjeta, int cantidad, int entidadCajero){
        String salida = "error";
        if(entidadCajero != tarjeta.getCuenta().getCodBanco()){
            salida = "La entidad del cajero no correspone con la entidad de la cuenta";
        }
        else{
            tarjeta.getCuenta().setSaldo(tarjeta.getCuenta().getSaldo() + cantidad);
            salida = "El ingreso se ha completado correctamente";
        }

        return salida;
    }

    private String sacarDinero(Tarjeta tarjeta, int cantidad){

        String salida = "error";

        if(tarjeta.getTipo().equals(DEBITO)){
            if(comprobarSaldo(cantidad, tarjeta.getCuenta().getSaldo())){
                tarjeta.getCuenta().setSaldo(tarjeta.getCuenta().getSaldo()-Double.valueOf(cantidad));
                salida = "Se ha retirado dinero de su tarjeta de debito satisfactoriamente";
            }
        }
        else{
            if(comprobarMax(cantidad, tarjeta.getMax(), tarjeta.getCreditoEntregado())){
                tarjeta.getCuenta().setSaldo(tarjeta.getCuenta().getSaldo()-Double.valueOf(cantidad));
                salida = "Se ha retirado dinero de su tarjeta de credito satisfactoriamente";
            }
        }

        return salida;

    }

    private boolean comprobarMax(int cantidad, int max, int creditoEntregado){

        boolean comprobar = false;
        int saldoRestante = max - creditoEntregado;
        if(cantidad < saldoRestante){
            comprobar = true;
        }

        return comprobar;
    }

    private boolean comprobarSaldo(int cantidad, Double saldo){

        boolean comprobar = false;

        if(cantidad < saldo.intValue()){
            comprobar = true;
        }

        return comprobar;
    }
    
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
