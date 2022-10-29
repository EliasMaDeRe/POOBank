package DTO;

public class LoginResponseDTO {
	
	private UserDTO user;
	private String token;

	public LoginResponseDTO() {}

	public LoginResponseDTO(UserDTO user, String token) {
		this.user = user;
		this.token = token;
	}
}