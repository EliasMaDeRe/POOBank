package services;

import DTO.*;
import models.Cuenta;
import models.Transferencia;
import utilities.WrapperResponse;
public class TransferService {

	
	Cuenta cuenta = new Cuenta();
	
    public WrapperResponse<Transferencia> transfer(TransferRequestDTO transfer){

		cuentaEmisora = cuenta.findAccountByAccountNumber(transfer.getNumeroDeCuentaEmisora());
		cuentaReceptora = cuenta.findAccountByAccountNumber(transfer.getDestino());

		boolean ok;
		String mensaje;

		Transferencia transferencia = new Transferencia(transfer.getNumeroDeCuenta(), transfer.getDestino(), transfer.getMonto(), transfer.getConcepto())

        if ((cuentaEmisora.isPresent())){ //Checa si existe la cuenta emisora
			if ((cuentaReceptora.isPresent())){	//Checa si existe ela cuenta receptora
				if(cuentaEmisora.getSaldo()>=transfer.getMonto()){	//Checa si tiene suficiente dinero la emisora					
					cuentaEmisora.setSaldo(sustraerMonto(transfer.getMonto(), cuentaEmisora.getSaldo()));
					cuentaReceptora.setSaldo(agregarMonto(transfer.getMonto(), cuentaReceptora.getSaldo()));

					ok = true;
					mensaje = "Transferencia exitosa";
				} else {
					ok = false;
					mensaje = "No se pudo sustraer el monto de la cuenta emisora";
				}
			} else {
				ok = false;
				mensaje = "La cuenta receptora no existe";
			}
        } else {
			ok = false;
			mensaje = "La cuenta emisora no existe";
		}

		return new WrapperResponse<Transferencia>(ok, mensaje, transferencia);

    }

	public double sustraerMonto(double monto, double saldo){
		return saldo-monto;	
	}

	public double agregarMonto (double monto, double saldo){
		return saldo+monto;
	}

	// POR IMPLEMENTAR EN Cuenta: 

	// Optional<Cuenta> findAccountByAccountNumber(String numeroDeCuenta)
	// void setSaldo(double saldo)

}
