public class Transferencia extends Transaccion {
    
    private String destino;
    private String concepto;

    public Transferencia(String numeroDeCuenta, String destino, double monto, String concepto) {
        super(numeroDeCuenta, monto);
        this.destino = destino;
        this.concepto = concepto;

        guardarTransaccion();
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + " - Transferencia: " + id + " - Monto: $" + monto + " - Concepto: " + concepto + " - Cuenta de origen: " + numeroDeCuenta + " - Cuenta de destino: " + destino + "\n";
    }
}
