package services;

import DTO.*;
import models.Retiro;
import utilities.WrapperResponse;

public class WithdrawalService {

    private Retiro retiro = new Retiro();

    public WithdrawalService() {}

    public WrapperResponse<WithdrawalResponseDTO> Withdrawal(WithdrawalRequestDTO retiro){

        if(retiro.findUserByAccountNumber(retiro.getnumeroDeCuenta().isPresent())){
            if(retiro.getSaldo() >= retiro.getMonto()){
                retiro.getNumeroDeCuenta().setSaldo() = retiro.getSaldo() - retiro.getMonto();
                return new WrapperResponse<WithdrawalResponseDTO>(true, "El retiro se realizó con éxito.", new WithdrawalResponseDTO(new TransactionDTO(retiro.getnumeroDeCuenta()), retiro.getSaldo(), retiro.getMonto()));
            }else{
                return new WrapperResponse<WithdrawalResponseDTO>(false, "No hay saldo suficiente para lo que se desea retirar.", null);
            }
        } else{
            return new WrapperResponse<WithdrawalResponseDTO>(false, "El número de cuenta no existe.", null);
        }

    }

    
}
