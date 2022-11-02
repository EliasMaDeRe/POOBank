package services;

import DTO.*;
import models.UserModel;
import utilities.WrapperResponse;

public class AuthService {

	private UserModel userModel = new UserModel();

	public AuthService() {}

	public WrapperResponse<LoginResponseDTO> login(LoginRequestDTO user) {

		if (!(userModel.findUserByUsername(user.getUsername()).isPresent())) {
			// Aquí va si no se encuentra el usuario.
			return new WrapperResponse<>(false, "Inicio de sesión incorrecto.", null);
		}
		//falta verificar que la contraseña es correcta
		//falta guardar token en base de datos
		String token = "123";
		return new WrapperResponse<>(true, "Inicio de sesión correcto.", new LoginResponseDTO(new UserDTO(user.getUsername()),token));
	}

	public WrapperResponse<Boolean> logout(LogoutRequestDTO user){

		return new WrapperResponse<Boolean>(true, "Cierre de sesión correcto", true);

	}
}
