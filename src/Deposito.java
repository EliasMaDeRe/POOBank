public class Deposito extends Transaccion {

    public Deposito(String numeroDeCuenta, double monto) {
        super(numeroDeCuenta, monto);

        guardarTransaccion();
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + " - Deposito: " + id + " - Monto: $" + monto + " - A la cuenta: " + numeroDeCuenta + "\n";
    }
}
