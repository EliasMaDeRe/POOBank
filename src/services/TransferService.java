package services;

import java.util.Optional;

import DTO.*;
import models.Cuenta;
import models.Transferencia;
import utilities.WrapperResponse;
public class TransferService {

	
	Cuenta cuenta = new Cuenta();
	
    public WrapperResponse<Transferencia> transfer(TransferRequestDTO transfer){

		Optional <Cuenta> cuentaEmisoraOptional = cuenta.findAccountByAccountNumber(transfer.getNumeroCuentaEmisora());
		Optional <Cuenta> cuentaReceptoraOptional = cuenta.findAccountByAccountNumber(transfer.getNumeroCuentaDestino());

		boolean ok = false;
		String mensaje;


		Transferencia transferencia = new Transferencia(transfer.getNumeroCuentaEmisora(), transfer.getNumeroCuentaDestino(), transfer.getMonto(), transfer.getConcepto());

        if ((cuentaEmisoraOptional.isPresent())){ //Checa si existe la cuenta emisora
			if ((cuentaReceptoraOptional.isPresent())){	//Checa si existe ela cuenta receptora

				Cuenta cuentaEmisora = cuentaEmisoraOptional.get();
				Cuenta cuentaReceptora =  cuentaReceptoraOptional.get();

				if(cuentaEmisora.getSaldo()>=transfer.getMonto()){	//Checa si tiene suficiente dinero la emisora					
					cuentaEmisora.setSaldo(sustraerMonto(transfer.getMonto(), cuentaEmisora.getSaldo()));
					cuentaReceptora.setSaldo(agregarMonto(transfer.getMonto(), cuentaReceptora.getSaldo())); // GUARDAR MODELO DESPUES DE MODIFICARLO

					ok = true;
					mensaje = "Transferencia exitosa";
				} else {
					mensaje = "No se pudo sustraer el monto de la cuenta emisora";
				}
			} else {
				mensaje = "La cuenta receptora no existe";
			}
        } else {
			mensaje = "La cuenta emisora no existe";
		}

		return new WrapperResponse<Transferencia>(ok, mensaje, transferencia); // GUARDAR TRANSFERENCIA EN LA BASE DE DATOS

    }

	public double sustraerMonto(double monto, double saldo){
		return saldo-monto;	
	}

	public double agregarMonto (double monto, double saldo){
		return saldo+monto;
	}

	// POR IMPLEMENTAR EN Cuenta: 

	// Constructor vacio
	// Optional<Cuenta> findAccountByAccountNumber(String numeroDeCuenta)
	// void setSaldo(double saldo)

}
