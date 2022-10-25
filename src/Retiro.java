public class Retiro extends Transaccion {

    public Retiro(String numeroDeCuenta, double monto) {
        super(numeroDeCuenta, monto);

        guardarTransaccion();
    }

    @Override
    public String toString() {
        return "Fecha: " + fecha + " - Retiro: " + id + " - Monto: $" + monto + " - Cuenta de origen: " + numeroDeCuenta + "\n";
    }
}
