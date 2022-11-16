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

        Boolean ok;

        String mensaje;

        DepositResponseDTO depositResponse;
        
        if (cuenta.findAccountByAccountNumber(deposito.getnumeroDeCuenta().isPresent())) {
			
            cuenta.getNumeroDeCuenta().setSaldo() = deposito.getSaldo() + deposito.getMonto();

            ok = true;

            mensaje = "El depósito se realizó con éxito.";

            depositResponse =  new DepositResponseDTO(new TransactionDTO(deposito.getnumeroDeCuenta()), deposito.getSaldo(), deposito.getMonto());

		} else {

            ok = false;

            mensaje = "El número de cuenta no existe.";

            depositResponse = null;
        }

        return new WrapperResponse<DepositResponseDTO>(ok, mensaje, depositResponse);
    }
}