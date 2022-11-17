package DTO;

public class WithdrawalRequestDTO {
    
    private String numeroDeCuenta;
    private double monto; 
    
    public WithdrawalRequestDTO() {}

	public WithdrawalRequestDTO(String numeroDeCuenta, double monto) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
	}

    public String getNumeroDeCuenta() {
		return this.numeroDeCuenta;
	}

	public void setNnumeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}
    
	public double getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

}
