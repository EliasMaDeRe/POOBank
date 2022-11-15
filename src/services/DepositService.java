package services;
import DTO.*;
import models.Deposito;
import utilities.WrapperResponse;

public class DepositService {
    
    // Agregar monto a una cuenta

    // Necesito: Verificar si existe la cuenta
    //           Agregar monto a la cuenta

    private Cuenta cuenta = new Cuenta();

    public DepositService() {}

    public WrapperResponse<DepositResponseDTO> Deposit(DepositRequestDTO deposito) {

        if (cuenta.findUserByAccountNumber(deposito.getnumeroDeCuenta().isPresent())) {
			
            cuenta.getNumeroDeCuenta().setSaldo() = deposito.getSaldo() + deposito.getMonto();

            return new WrapperResponse<DepositResponseDTO>(true, "El depósito se realizó con éxito.", new DepositResponseDTO(new TransactionDTO(deposito.getnumeroDeCuenta()), deposito.getSaldo(), deposito.getMonto()));

		} else {

            return new WrapperResponse<DepositResponseDTO>(false, "El número de cuenta no existe.", null);
        }
    }

    private Deposito deposito = new Deposito();
}
