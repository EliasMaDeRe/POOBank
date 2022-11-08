package DTO;

public class UserDTO {
	
	private String username;

	public UserDTO() {}

	public UserDTO(String username) {
		this.username = username;
	}

	public	String getUsername(){
		return this.username;
	}

	public void setUsername(String username){
		this.username = username;
	}
	
}
