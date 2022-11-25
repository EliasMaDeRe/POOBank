package DTO;

public class DepositResponseDTO {
    
    private Deposit_WithdrawalDTO transaction;
	private Boolean verificador;

    public DepositResponseDTO() {} //constructor vacio

    public DepositResponseDTO(Deposit_WithdrawalDTO transaction, Boolean verificador) {
		this.transaction = transaction;
	}
	
	public Deposit_WithdrawalDTO getTransactionDTO(){
		return this.transaction;
	}

	public void setTransactionDTO(Deposit_WithdrawalDTO transaction){
		this.transaction = transaction;
	}

	public Boolean getToken(){
		return this.verificador;
	}

	public void setToken(Boolean verificador){
		this.verificador = verificador;
	}

}
