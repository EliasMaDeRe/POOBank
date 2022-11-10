package DTO;

public class DepositRequestDTO {
    
    private String numeroDeCuenta;
    private double monto; 
    
    public DepositRequestDTO() {}

	public DepositRequestDTO(String numeroDeCuenta, double monto) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
	}

    public String numeroDeCuenta() {
		return numeroDeCuenta;
	}

	public void numeroDeCuenta(String numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}
    
	public double getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

}
