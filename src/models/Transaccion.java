package models;
import java.io.*;
import utilities.Utileria;

public abstract class Transaccion {

    protected String id;
    protected String fecha;
    protected double monto;
    protected String numeroDeCuenta;

    protected Transaccion(String numeroDeCuenta, double monto) {
        this.id = Utileria.generarId();
        this.fecha = Utileria.generarFecha();
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
    }
    
}