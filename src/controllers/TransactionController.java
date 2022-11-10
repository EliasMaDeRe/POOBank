package controllers;
import DTO.*;
import services.WithdrawalService;
import services.DepositService;
import services.TransferService;
import utilities.WrapperResponse;

public class TransactionController {
    private WithdrawalService withdrawalhService = new WithdrawalService();
    private DepositService depositService = new DepositService();
    private TransferService transferService = new transferService();

    public WrapperResponse<WithdrawalResponseDTO> withdrawal(WithdrawalRequestDTO withdrawal) {
		return withdrawalService.withdrawal(withdrawal);
	}

    public WrapperResponse<DepositResponseDTO> depositService(DepositRequestDTO deposit) {
		return depositService.deposit(deposit);
	}

    public WrapperResponse<TransferResponseDTO> transfer(TransferRequestDTO transfer) {
		return transferService.transfer(transfer);
	}
}
