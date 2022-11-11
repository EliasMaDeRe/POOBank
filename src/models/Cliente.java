package models;

import java.sql.SQLException;

public class Cliente {
    private DB_query nube = new DB_query();

    private int Id;
    private String nombre;
    private String apellido;
    private String CURP;
    private Cuenta[] cuentas = new Cuenta[3];

    public Cliente(String nombre, String apellido, String CURP) throws ClassNotFoundException, SQLException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.CURP = CURP;
        int no_cunetas =this.cuentas.length;
        //subimos a la nuevo y damos el nuevo id generado
        Id = nube.NuevoCliente(nombre, apellido, CURP, no_cunetas); 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String cURP) {
        CURP = cURP;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    public int getID() {
        return Id;
    }

    public int NumberOfCuentas() {
        return this.cuentas.length;
    }
}
