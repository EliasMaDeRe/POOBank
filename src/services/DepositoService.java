package services;
import DTO.*;
import models.Deposito;
import utilities.WrapperResponse;

public class DepositoService {
    
    // Agregar monto a una cuenta

    // Necesito: Verificar si existe la cuenta
    //           Agregar monto a la cuenta

    private Deposito deposito = new Deposito();

    public WrapperResponse<DepositoResponse> deposito(DepositoRequestDTO deposito) {

        if (!(userModel.findUserByUsername(user.getUsername()).isPresent())) { // No Existe el usuario
			
			return new WrapperResponse<LoginResponseDTO>(false, "No existe el usuario.", null);
		}

        // Aquí sigo el código
    }
}
