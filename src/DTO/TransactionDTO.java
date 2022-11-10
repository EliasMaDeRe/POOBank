package DTO;

public class TransactionDTO {
	
	private String numeroDeCuenta;

	public TransactionDTO() {}

	public TransactionDTO(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

    public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}
    
}