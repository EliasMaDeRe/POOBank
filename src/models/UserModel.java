package models;

import java.util.Optional;
import repositories.UserRepository;

public class UserModel implements UserRepository {
	
	private Integer id;
	private String username;
	private String password;

	public UserModel() {}

	public UserModel(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Optional<UserModel> findUserById(Integer id) {
		// Aquí va la implementación del equipo de data...

		// Este return no es final, es nomas para que se quite el problema xd.
		return Optional.empty();
	}

	@Override
	public Optional<UserModel> findUserByUsername(String username) {
		// Aquí va la implementación del equipo de data...

		// Este return no es final, es nomas para que se quite el problema xd.
		return Optional.empty();
	}
}
