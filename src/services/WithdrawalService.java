package services;

import java.util.Optional;

import DTO.*;
import models.Cuenta;
import models.Retiro;
import utilities.WrapperResponse;

public class WithdrawalService {

    private Cuenta cuentaMetodos = new Cuenta();

    public WithdrawalService() {}

    public WrapperResponse<WithdrawalResponseDTO> Withdrawal(WithdrawalRequestDTO retiro){

        boolean ok = false;
        String mensaje;
        WithdrawalResponseDTO withResponse;


        Optional<Cuenta> cuentaOptional = cuentaMetodos.findAccountByAccountNumber(retiro.getNumeroDeCuenta());

        if(cuentaOptional.isPresent()){

            Cuenta cuenta = cuentaOptional.get();

            if(cuenta.getSaldo() >= retiro.getMonto()){

                cuenta.setSaldo(cuenta.getSaldo()-retiro.getMonto());
                ok = true;
                mensaje = "El retiro se realizó con éxito";
                withResponse = new WithdrawalResponseDTO(new Deposit_WithdrawalDTO(retiro.getNumeroDeCuenta(),retiro.getMonto()), true);

            }else{
                mensaje = "No hay saldo suficiente para lo que se desea retirar";
                withResponse = null;
            }
        } else{
            mensaje = "El número de cuenta no existe";
            withResponse = null;
        }

        return new WrapperResponse<WithdrawalResponseDTO>(ok, mensaje, withResponse);

    }

    
}
