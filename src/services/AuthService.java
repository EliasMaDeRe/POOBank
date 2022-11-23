package services;

import DTO.*;
import models.UserModel;
import utilities.WrapperResponse;

public class AuthService {

	private UserModel userModel = new UserModel(); // MODELO DE USUARIO -> MODELO DE CLIENTE

	public AuthService() {}

	public WrapperResponse<LoginResponseDTO> login(LoginRequestDTO user) {

		if (!(userModel.findUserByUsername(user.getUsername()).isPresent())) { // No Existe el usuario
			
			return new WrapperResponse<LoginResponseDTO>(false, "No existe el usuario.", null);
		}
		if (userModel.findUserByUsername(user.getUsername()).get().getPassword() != user.getPassword()){ // La contraseña no es correcta

			return new WrapperResponse<LoginResponseDTO>(false,"Contraseña incorrecta",null);

		}
		String token = "123"; // generar token // METOODO GENERAR ID
		userModel.findUserByUsername(user.getUsername()).get().setToken(token); // guardar token (falta implementar)
		return new WrapperResponse<LoginResponseDTO>(true, "Inicio de sesión correcto.", new LoginResponseDTO(new UserDTO(user.getUsername()),token));
	}

	public WrapperResponse<Boolean> logout(LogoutRequestDTO user){

		if(!userModel.findUserByToken(user.getToken()).isPresent()){ // Verifica el token existe

			return new WrapperResponse<Boolean>(true, "Cierre de sesión incorrecto", true);

		}
		userModel.findUserByToken(user.getToken()).get().setToken(null); // remueve el token				
		return new WrapperResponse<Boolean>(true, "Cierre de sesión correcto", true);

	} 

	// POR IMPLEMENTAR EN USER MODEL: 

	// Optional<UserModel> findUserByToken(String token)
	// void	setToken(String token)
}
