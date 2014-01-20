package se.legarre.ecommerce.model;

public final class EmployeeModel extends UserModel
{
	private boolean isAdmin;

	public EmployeeModel(String username, String password, String name,
			String lastName, String email, String telefon, boolean isAdmin)
	{
		super(username, password, name, lastName, email, telefon);
		this.isAdmin = isAdmin;
	}

	public EmployeeModel(EmployeeModel other)
	{
		super(other);
		this.isAdmin = other.isAdmin;
	}

	public boolean isAdmin()
	{
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString()
	{
		return String.format("%s, isAdmin: %s", super.toString(), isAdmin());
	}

}
