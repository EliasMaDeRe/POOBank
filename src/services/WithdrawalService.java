package services;

import DTO.*;
import models.Cuenta;
import models.Retiro;
import utilities.WrapperResponse;

public class WithdrawalService {

    private Cuenta cuenta = new Cuenta();

    public WithdrawalService() {}

    public WrapperResponse<WithdrawalResponseDTO> Withdrawal(WithdrawalRequestDTO retiro){

        boolean ok;
        String mensaje;
        WithdrawalResponseDTO withRequest;

        if(cuenta.findAccountByAccountNumber(retiro.getnumeroDeCuenta().isPresent())){
            if(cuenta.getSaldo() >= retiro.getMonto()){

                cuenta.getNumeroDeCuenta().setSaldo(cuenta.getSaldo()-retiro.getMonto());
                ok = true;
                mensaje = "El retiro se realizó con éxito";
                withRequest = new WithdrawalResponseDTO(new TransactionDTO(retiro.getnumeroDeCuenta()), retiro.getSaldo(), retiro.getMonto());

            }else{
                ok = false;
                mensaje = "No hay saldo suficiente para lo que se desea retirar";
                withRequest = null;
            }
        } else{
            ok = false;
            mensaje = "El número de cuenta no existe";
            withRequest = null;
        }

        return new WrapperResponse<WithdrawalResponseDTO>(ok, mensaje, withRequest);

    }

    
}
