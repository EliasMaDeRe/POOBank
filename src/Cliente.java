import java.util.Arrays;

public class Cliente {

    private String nombre;
    private String apellido;
    private String CURP;
    
    private Cuenta[] cuentas = new Cuenta[3];

    public Cliente(String nombre, String apellido, String CURP) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CURP = CURP;
    }

    public String getNombreCompleto() {
        return nombre + apellido;
    }

    public String getNumeroDeCliente() {
        return CURP;
    }

    public void agregarCuenta(Cuenta nuevaCuenta) {
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = nuevaCuenta;
                return;
            }
        }
    }
    
    @Override
    public String toString() {
        return "Cliente: " + nombre + " " + apellido + "\n" + 
               "Numero de cliente: " + CURP + "\n" + 
               "Cuentas: " + Arrays.toString(cuentas) + "\n";
    }
}
