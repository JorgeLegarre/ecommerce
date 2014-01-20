package se.legarre.ecommerce.repository.inMemoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.legarre.ecommerce.model.ClientModel;
import se.legarre.ecommerce.model.EmployeeModel;
import se.legarre.ecommerce.model.UserModel;
import se.legarre.ecommerce.repository.UserRepository;

public final class UserRepositoryInMemoryImpl implements UserRepository
{

	private Map<String, UserModel> users;

	public UserRepositoryInMemoryImpl()
	{
		users = new HashMap<String, UserModel>();
	}

	@Override
	public void saveUser(UserModel user)
	{
		UserModel newUser = getCopyUser(user);

		users.put(user.getUsername(), newUser);
	}

	@Override
	public List<UserModel> getAllUsers()
	{
		List<UserModel> listUsers = new ArrayList<UserModel>();

		for (UserModel userModel : users.values())
		{
			listUsers.add(getCopyUser(userModel));
		}

		return listUsers;
	}

	@Override
	public UserModel getUser(String username)
	{
		UserModel user = users.get(username);

		return (user == null) ? null : getCopyUser(user);
	}

	@Override
	public void removeUser(String username)
	{
		users.remove(username);
	}

	private UserModel getCopyUser(UserModel user)
	{
		UserModel copyUser = null;
		if (user instanceof ClientModel)
		{
			copyUser = new ClientModel((ClientModel) user);
		}
		else
		{
			copyUser = new EmployeeModel((EmployeeModel) user);
		}
		return copyUser;
	}

}
