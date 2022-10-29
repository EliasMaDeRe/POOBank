package models;

import utilities.Utileria;

public abstract class Cuenta {
    
    private String numeroDeCuenta;
    private String numeroDeCliente;
    private double saldo;
    
    protected Cuenta(String numeroDeCliente) {
        this.numeroDeCuenta = Utileria.generarId();
        this.numeroDeCliente = numeroDeCliente;
        this.saldo = 0;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public String getNumeroDeCliente() {
        return numeroDeCliente;
    }

    public double getSaldo() {
        return saldo;
    }
}