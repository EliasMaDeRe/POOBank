package repositories;

import java.util.Optional;

import models.UserModel;

public interface UserRepository {
	
	public Optional<UserModel> findUserById(Integer id);
	public Optional<UserModel> findUserByUsername(String username);
}
