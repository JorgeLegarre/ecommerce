package se.legarre.ecommerce.model;

public final class ClientModel extends UserModel
{
	private AddressModel deliveryAddress;
	private AddressModel billingAddress;
	private ShoppingCartModel shoppingCart;

	public ClientModel(String username, String password, String name,
			String lastName, String email, String telefon,
			AddressModel deliveryAddress, AddressModel billingAddress)
	{

		super(username, password, name, lastName, email, telefon);

		this.deliveryAddress = deliveryAddress;
		this.billingAddress = billingAddress;
		this.shoppingCart = new ShoppingCartModel();
	}

	public ClientModel(String username, String password, String name,
			String lastName, String email, String telefon,
			AddressModel deliveryAddress)
	{
		this(username, password, name, lastName, email, telefon, deliveryAddress, deliveryAddress);
	}

	public ClientModel(ClientModel other)
	{
		super(other);
		this.deliveryAddress = new AddressModel(other.deliveryAddress);
		this.billingAddress = new AddressModel(other.billingAddress);
		this.shoppingCart = new ShoppingCartModel(other.shoppingCart);
	}

	public AddressModel getDeliveryAddress()
	{
		return deliveryAddress;
	}

	public void setDeliveryAddress(AddressModel deliveryAddress)
	{
		this.deliveryAddress = deliveryAddress;
	}

	public AddressModel getBillingAddress()
	{
		return billingAddress;
	}

	public void setBillingAddress(AddressModel billingAddress)
	{
		this.billingAddress = billingAddress;
	}

	public ShoppingCartModel getShoppingCart()
	{
		return shoppingCart;
	}

	@Override
	public String toString()
	{
		return String
				.format("%s, deliveryAddress: %s, billingAddress: %s, shoppingCart: %s",
						super.toString(), deliveryAddress.toString(),
						billingAddress.toString(), shoppingCart.toString());
	}
}
