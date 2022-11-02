package DTO;

public class LogoutRequestDTO {

    private String token;

	public LogoutRequestDTO() {}

	public LogoutRequestDTO(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
