package services;

import java.util.Optional;
import DTO.*;
import models.Cuenta;
import utilities.WrapperResponse;

/**
 * DepositService es una clase auxiliar donde se realiza un deposito a una cuenta que 
 * se encuentre en el banco.
 * 
 * @author José Carlos Leo
 */

public class DepositService {

    private Cuenta cuentaMetodos = new Cuenta();

    /** 
     * Método donde se realiza el deposito a la cuenta, primero verifica si una cuenta es existente, si esto se cumple
     * el deposito se realiza y se aumenta el monto que se depistó a la cuenta.
     * 
     * @param deposito Es un objeto creado de DepositRequestDTO con la información del número de cuenta y el monto que se
     * depositará en la cuenta.
     * 
     * @return Devuelve un WrapperResponse con un booleano definiendo el estado de la operación y un mensaje describiendo
     * dicha operación.
     */

    public DepositService() {}

    public WrapperResponse<Boolean> Deposit(DepositRequestDTO deposito) {

        Boolean ok = false;

        String mensaje;

        Optional<Cuenta> cuentaOptional = cuentaMetodos.findAccountByAccountNumber(deposito.getNumeroDeCuenta());
        
        if (cuentaOptional.isPresent()) {

            Cuenta cuenta = new Deposito(deposito.getNumeroDeCuenta(), deposito.getMonto());
			
            cuenta.setSaldo(cuenta.getSaldo() + deposito.getMonto());

            cuenta.saveCuenta();

            ok = true;

            mensaje = "El depósito se realizó con éxito.";

            deposit.saveDeposit();

		} else {

            mensaje = "El número de cuenta no existe.";
        }

        return new WrapperResponse<Boolean>(ok, mensaje, null);
    }
}