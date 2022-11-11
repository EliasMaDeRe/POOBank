package models;
import java.io.*;
import java.sql.SQLException;

import utilities.Utileria;

public abstract class Transaccion {
    protected DB_query nube = new DB_query();
    protected String id;
    protected String fecha;
    protected double monto;
    protected String numeroDeCuenta;

    protected Transaccion() {  } //Constructor vacio

    protected Transaccion(String numeroDeCuenta, double monto) {
        this.id = Utileria.generarId();
        this.fecha = Utileria.generarFecha();
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
    }

    protected void Depositos(Deposito depo ) throws ClassNotFoundException, SQLException {  
        nube.GenerarDeposito(depo);
    }

    protected void Retiro(Retiro retiro ) throws ClassNotFoundException, SQLException {  
        nube.GenerarDeposito(retiro);
    }

    protected void Transferencia(Transferencia trans) throws ClassNotFoundException, SQLException {  
        nube.GenerarDeposito(trans);
    }


    
}