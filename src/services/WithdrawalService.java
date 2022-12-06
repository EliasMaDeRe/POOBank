package services;

import java.util.Optional;
import DTO.*;
import models.Cuenta;
import models.Retiro;
import utilities.WrapperResponse;

/**
 * WithdrawalService es una clase auxiliar donde realiza un retiro de una cuenta que 
 * se encuentre en el banco.
 * 
 * @author Valentina Ortiz
 * */

public class WithdrawalService {

    private Cuenta cuentaMetodos = new Cuenta();

    /** Método donde se realiza el retiro de la cuenta, primero verifica si una cuenta es existente, si esto se cumple
     * verifica si el saldo que contiene la cuenta es suficiente al monto que se desea retirar, si cumple con ambos campos,
     * el retiro se realiza y se descuenta el monto que se retiró de la cuenta.
     * 
     * @param retiro Es un objeto creado de WithdrawalRequestDTO con la información del número de cuenta y el monto que se necesita
     * para hacer el retiro.
     * 
     * @return Devuelve un WrapperResponse con un booleano definiendo el estado de la operación y un mensaje describiendo
     * dicha operación
     */

    public WrapperResponse<Boolean> Withdrawal(WithdrawalRequestDTO retiro){

        boolean ok = false;
        String mensaje;
        
        Retiro withdrawal = new Retiro(retiro.getNumeroDeCuenta(), retiro.getMonto());
        withdrawal.saveRetiro();
    
        Optional<Cuenta> cuentaOptional = cuentaMetodos.findAccountByAccountNumber(retiro.getNumeroDeCuenta());

        if(cuentaOptional.isPresent()){

            Cuenta cuenta = cuentaOptional.get();

            if(cuenta.getSaldo() >= retiro.getMonto()){

                cuenta.setSaldo(cuenta.getSaldo()-retiro.getMonto());
                cuenta.saveCuenta();

                ok = true;
                mensaje = "El retiro se realizó con éxito";
                  
            }else{
                mensaje = "No hay saldo suficiente para lo que se desea retirar";
            }
        } else{
            mensaje = "El número de cuenta no existe";
        
        }

        return new WrapperResponse<Boolean>(ok, mensaje, null);

    }

    
}
