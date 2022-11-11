package models;

public class Transferencia extends Transaccion {
    
    private String destino;
    private String concepto;

    public Transferencia(){} // Constructor vacio

    public Transferencia(String numeroDeCuenta, String destino, double monto, String concepto) {
        super(numeroDeCuenta, monto);
    }

    public String getDestino() {
        return destino;
    }

    public String getConcepto() {
        return concepto;
    }
}
