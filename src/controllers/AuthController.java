package controllers;

import DTO.*;
import services.AuthService;
import utilities.WrapperResponse;

public class AuthController {

	private AuthService authService = new AuthService();
	
	// Aquí va el controlador de
	// - Inicio de sesión
	// - Registro de nuevo usuario

	// Controlador: Lo unico que hace es llamar a un servicio. NO LLEVA IMPLEMENTACIÓN!!!
	// EL SERVICIO ES EL QUE TIENE LA IMPLEMENTACIÓN!!!

	// Todos los controladores deben retornar este tipo de dato (WrapperResponse) para tener estandarizadas las respuestas).
	// El controlador retorna la llamada al método del servicio y el servicio es el encargado de responder el WrapperResponse

	//public WrapperResponse<LoginResponseDTO> login(LoginRequestDTO user) {
		// return authService.login(user);
	// }
}
