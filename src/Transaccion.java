import java.io.*;

public abstract class Transaccion {

    protected String id;
    protected String fecha;
    protected double monto;
    protected String numeroDeCuenta;

    public Transaccion(String numeroDeCuenta, double monto) {
        this.id = Utileria.generarId();
        this.fecha = Utileria.generarFecha();
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
    }

    protected void guardarTransaccion() {

        final String path = "../TransaccionsFMAT.txt";
        
        File file = new File(path);

        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("El archivo de registro de las transacciones no se ha podido crear.");
            }
        }

        try {
            FileWriter writer = new FileWriter(path, true);

            for (int i = 0; i <= toString().length() - 1; i++) {
                writer.write(toString().charAt(i));
            }

            writer.close();
        } catch(Exception e) {
            System.out.println("No se ha podido escribir en el archivo de registro.");
        }
    }
}