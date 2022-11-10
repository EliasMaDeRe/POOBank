package services;

import DTO.*;
import models.Transferencia;
import utilities.WrapperResponse;
public class TransferService {

	private Transferencia Transferencia = new Transferencia();


    public WrapperResponse<TransferResponseDTO> transfer(TransferRequestDTO transfer){

        if ((Transferencia.findAccountAccountNumber(transfer.getNumeroDeCuenta()).isPresent())){ //Checa si existe el numero emisor
			if ((Transferencia.findAccountByAccountNumber(transfer.getDestino()).isPresent())){	//Checa si existe el numero receptor
				if(transfer.getSaldoEmisor()>=transfer.getMonto()){	//Checa si tiene suficiente dinero la emisora
					transfer.getNumeroDeCuenta().setSaldoEmisor() = sustraerMonto(transfer.getMonto(), transfer.getSaldoEmisor());
					transfer.getDestino().setSaldoDestino() = sustraerMonto(transfer.getMonto(), transfer.getSaldoDestino());
					return new WrapperResponse<TransferResponseDTO>(true, "Transferencia exitosa", new transferResponseDTO(transfer.getNumeroDeCuenta(), transfer.getDestino(), transfer.getMonto(),sustraerMonto(transfer.getMonto(), transfer.getSaldoEmisor()), agregarMonto(transfer.getMonto(), transfer.getSaldoDestino()), transfer.getConcepto())); //Devuelve los valores nuevos
				} else {
					return new WrapperResponse<TransferResponseDTO>(false, "No se pudo sustraer el monto de la cuenta emisora", null);
				}
			} else {
				return new WrapperResponse<TransferResponseDTO>(false, "La cuenta receptora no existe", null);
			}
        } else {
            return new WrapperResponse<TransferResponseDTO>(false, "La cuenta emisora no existe", null);
		}
    }

	public double sustraerMonto(double monto, double saldo){
		return saldo-monto;	
	}

	public double agregarMonto (double monto, double saldo){
		return saldo+monto;
	}

	// POR IMPLEMENTAR EN TRANSFER MODEL: 

	// Optional<TRANSFERMODEL> findAccountByAccountNumber(numeroDeCuenta)

}
