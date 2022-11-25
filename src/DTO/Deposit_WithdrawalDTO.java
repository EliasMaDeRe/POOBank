package DTO;

public class Deposit_WithdrawalDTO {
	
	private String numeroDeCuenta;
	double monto;

	public Deposit_WithdrawalDTO() {}

	public Deposit_WithdrawalDTO(String numeroDeCuenta, double monto) {
		this.numeroDeCuenta = numeroDeCuenta;
		this.monto = monto;
	}

    public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void setNumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
    
}