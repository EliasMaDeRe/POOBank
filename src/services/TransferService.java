package services;

import DTO.*;
import models.Cuenta;
import models.Transferencia;
import utilities.WrapperResponse;
public class TransferService {

	
	Cuenta cuenta = new Cuenta();
	
    public WrapperResponse<TransferResponseDTO> transfer(TransferRequestDTO transfer){

		cuentaEmisora = cuenta.findAccountByAccountNumber(transfer.getNumeroDeCuentaEmisora());
		cuentaReceptora = cuenta.findAccountByAccountNumber(transfer.getDestino());

        if ((cuentaEmisora.isPresent())){ //Checa si existe la cuenta emisora
			if ((cuentaReceptora.isPresent())){	//Checa si existe ela cuenta receptora
				if(cuentaEmisora.getSaldo()>=transfer.getMonto()){	//Checa si tiene suficiente dinero la emisora					
					cuentaEmisora.setSaldo(sustraerMonto(transfer.getMonto(), cuentaEmisora.getSaldo()));
					cuentaReceptora.setSaldo(agregarMonto(transfer.getMonto(), cuentaReceptora.getSaldo()));
					return new WrapperResponse<TransferResponseDTO>(true, "Transferencia exitosa", new transferResponseDTO(transfer.getNumeroDeCuentaEmisora(), transfer.getDestino(), transfer.getMonto(), transfer.getConcepto())); //Devuelve los valores nuevos
				} else {
					return new WrapperResponse<TransferResponseDTO>(false, "No se pudo sustraer el monto de la cuenta emisora", null);
				}
			} else {
				return new WrapperResponse<TransferResponseDTO>(false, "La cuenta receptora no existe", null);
			}
        } else {
            return new WrapperResponse<TransferResponseDTO>(false, "La cuenta emisora no existe", null);
		}

		Transferencia transferencia = new Transferencia(transfer.getNumeroDeCuenta(), transfer.getDestino(), transfer.getMonto(), transfer.getConcepto())

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
