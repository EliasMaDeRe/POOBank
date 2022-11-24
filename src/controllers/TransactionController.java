package controllers;
import DTO.*;
import models.Transferencia;
import services.WithdrawalService;
import services.DepositService;
import services.TransferService;
import utilities.WrapperResponse;

/**
 * TransactionController es una clase que se encarga de controlar el flujo de información 
 * entre la vista y los servicios
 * @author Fernando Joachín Prieto 
 */

public class TransactionController {
    private WithdrawalService withdrawalService = new WithdrawalService();
    private DepositService depositService = new DepositService();
    private TransferService transferService = new TransferService();

    /**
     * Método que se encarga de controlar el flujo de información entre la vista y el servicio retiro.
     * @param withdrawal Es un DTO del retiro.
     * @return Devuelve un WrapperResponse del servicio retiro.
     */
    public WrapperResponse<WithdrawalResponseDTO> withdrawal(WithdrawalRequestDTO withdrawal) {
      return withdrawalService.Withdrawal(withdrawal);
	  }

    /**
     * Método que se encarga de controlar el flujo de información entre la vista y el servicio depósito.
     * @param deposit Es un DTO del depósito.
     * @return  Devuelve un WrapperResponse del servicio depósito.
     */
    public WrapperResponse<DepositResponseDTO> depositService(DepositRequestDTO deposit) {
      return depositService.Deposit(deposit);
	  }

    /**
     * Método que se encarga de control el flujo de información entre la vista y el servicio transferencia.
     * @param transfer Es un DTO transferencia.
     * @return Devuelve un WrapperResponse del servicio transferencia.
     */
    public WrapperResponse<Transferencia> transfer(TransferRequestDTO transfer) {
      return transferService.transfer(transfer);
	  }
}
