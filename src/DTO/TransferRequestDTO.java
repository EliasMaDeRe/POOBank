package DTO;

public class TransferRequestDTO {
    private String destino;
    private String numeroDeCuenta;
    private double saldoEmisor;
    private double saldoDestino;
    private String concepto;
    private double monto;

	public TransferRequestDTO() {}

	public TransferRequestDTO(String destino, String numeroDeCuenta, double saldoEmisor, double saldoDestino, String concepto, double monto) {
		this.destino = destino;   
        this.numeroDeCuenta = numeroDeCuenta;
        this.saldoEmisor = saldoEmisor;
        this.saldoDestino = saldoDestino;
        this.concepto = concepto;
        this.monto = monto;
	}

    public String getDestino() {
        return destino;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public double getSaldoEmisor() {
        return saldoEmisor;
    }

    public void setSaldoEmisor(double saldoEmisor) {
        this.saldoEmisor = saldoEmisor;
    }

    public double getSaldoDestino() {
        return saldoDestino;
    }

    public void setSaldoDestino(double saldoDestino) {
        this.saldoDestino = saldoDestino;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getMonto() {
        return monto;
    }
    
}
