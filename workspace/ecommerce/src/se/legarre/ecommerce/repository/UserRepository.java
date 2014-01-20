package se.legarre.ecommerce.repository;

import java.util.List;

import se.legarre.ecommerce.model.UserModel;

public interface UserRepository
{
	public void saveUser(UserModel user);

	public List<UserModel> getAllUsers();

	public UserModel getUser(String username);

	public void removeUser(String username);
}
