package DTO;

public class TransferRequestDTO {
    private String numeroCuentaDestino;
    private String numeroCuentaEmisora;
    private String concepto;
    private double monto;

	public TransferRequestDTO() {}

	public TransferRequestDTO(String numeroCuentaDestino, String numeroCuentaEmisora, String concepto, double monto) {
		this.numeroCuentaDestino = numeroCuentaDestino;   
        this.numeroCuentaEmisora = numeroCuentaEmisora;
        this.concepto = concepto;
        this.monto = monto;
	}

    public String getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(String numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public String getNumeroCuentaEmisora() {
        return numeroCuentaEmisora;
    }

    public void setNumeroCuentaEmisora(String numeroCuentaEmisora) {
        this.numeroCuentaEmisora = numeroCuentaEmisora;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
