package DTO;

public class DepositResponseDTO {
    
    private UserDTO user;
	private String token;

    public DepositResponseDTO() {} //constructor vacio

    public DepositResponseDTO(UserDTO user, String token) {
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

}
