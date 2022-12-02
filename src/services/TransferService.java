package services;

import java.util.Optional;

import DTO.*;
import models.Cuenta;
import models.Transferencia;
import utilities.WrapperResponse;

/**
* TransferService es una clase utilizada como servicio para realizar una transferencia entre dos cuentas existentes en el banco

@author Carlos May

*/
public class TransferService {

	
	Cuenta cuenta = new Cuenta();

	/**
	 * Método que realiza la transferencia, modifica los saldos de las cuentas y crea la transferencia, si alguna cuenta no existe o 
	 no tiene los fondos suficientes devuelve un WrapperResponse con un mensaje predeterminado, además de un booleano que define 
	 el estado de la operación

	 * @param transfer Objeto de TransferRequestDTO con la información del número de cuenta emisora, receptora, el monto y el concepto de
	 la transferencia
	 * @return Devuelve WrapperResponse con un booleano definiendo el estado de la operación y un mensaje describiendo la situación
	 */
	
    public WrapperResponse<Boolean> transfer(TransferRequestDTO transfer){

		Optional <Cuenta> cuentaEmisoraOptional = cuenta.findAccountByAccountNumber(transfer.getNumeroCuentaEmisora());
		Optional <Cuenta> cuentaReceptoraOptional = cuenta.findAccountByAccountNumber(transfer.getNumeroCuentaDestino());

		boolean ok = false;
		String mensaje;


		Transferencia transferencia = new Transferencia(transfer.getNumeroCuentaEmisora(), transfer.getNumeroCuentaDestino(), transfer.getMonto(), transfer.getConcepto());
		transferencia.saveTransferencia();

        if ((cuentaEmisoraOptional.isPresent())){
			if ((cuentaReceptoraOptional.isPresent())){

				Cuenta cuentaEmisora = cuentaEmisoraOptional.get();
				Cuenta cuentaReceptora =  cuentaReceptoraOptional.get();

				if(cuentaEmisora.getSaldo()>=transfer.getMonto()){			
					cuentaEmisora.setSaldo(cuentaEmisora.getSaldo()-transfer.getMonto());
					cuentaReceptora.setSaldo(cuentaReceptora.getSaldo()+transfer.getMonto());

					cuentaEmisora.saveCuenta();
					cuentaReceptora.saveCuenta();

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

		return new WrapperResponse<Boolean>(ok, mensaje, null);

    }

	// POR IMPLEMENTAR EN Cuenta: 

	// Constructor vacio
	// Optional<Cuenta> findAccountByAccountNumber(String numeroDeCuenta)
	// void setSaldo(double saldo)
	// void saveCuenta () Para guardar el objeto de la cuenta

	//POR IMPLEMENTAR EN MODELO TRANSFERENCIA

	// void saveTransferencia () Para guardar la transferencia

}
