package services;
import java.util.Optional;
import DTO.*;
import models.Cuenta;
import utilities.WrapperResponse;

public class DepositService {

    private Cuenta cuentaMetodos = new Cuenta();

    public DepositService() {}

    public WrapperResponse<DepositResponseDTO> Deposit(DepositRequestDTO deposito) {

        Boolean ok = false;

        String mensaje;

        DepositResponseDTO depositResponse;

        Optional<Cuenta> cuentaOptional = cuentaMetodos.findAccountByAccountNumber(deposito.getNumeroDeCuenta());
        
        if (cuentaOptional.isPresent()) {

            Cuenta cuenta = cuentaOptional.get();
			
            cuenta.setSaldo(cuenta.getSaldo() + deposito.getMonto());

            ok = true;

            mensaje = "El depósito se realizó con éxito.";

            depositResponse = new DepositResponseDTO(new Deposit_WithdrawalDTO(deposito.getNumeroDeCuenta(),deposito.getMonto()), true);

		} else {

            ok = false;

            mensaje = "El número de cuenta no existe.";

            depositResponse = null;
        }

        return new WrapperResponse<DepositResponseDTO>(ok, mensaje, depositResponse);
    }
}