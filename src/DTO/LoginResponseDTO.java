package DTO;

public class LoginResponseDTO {
	
	private UserDTO user;
	private String token;

	public LoginResponseDTO() {}

	public LoginResponseDTO(UserDTO user, String token) {
		this.user = user;
		this.token = token;
	}
	
	public UserDTO getUserDTO(){
		return this.user;
	}
	public void setUserDTO(UserDTO user){
		this.user = user;
	}
	public String getToken(){
		return this.token;
	}
	public void setToken(String token){
		this.token = token;
	}
	// get set
}