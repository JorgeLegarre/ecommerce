package se.legarre.ecommerce.service;

import java.util.List;

import se.legarre.ecommerce.model.ClientModel;
import se.legarre.ecommerce.model.UserModel;
import se.legarre.ecommerce.repository.UserRepository;

public final class UserService
{
	private UserRepository userRepository;

	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public void saveUser(UserModel user)
	{
		userRepository.saveUser(user);
	}

	public List<UserModel> getAllUsers()
	{
		return userRepository.getAllUsers();
	}

	public UserModel getUser(String username)
	{
		return userRepository.getUser(username);
	}

	public void removeUser(String username)
	{
		userRepository.removeUser(username);
	}

	public boolean isClient(UserModel user)
	{
		return user instanceof ClientModel;
	}
}
