package se.legarre.ecommerce.model;

public final class ProductIdQuantityModel
{
	private final String productId;
	private final int quantity;

	public ProductIdQuantityModel(String productId, int quantity)
	{
		this.productId = productId;
		this.quantity = quantity;
	}

	public ProductIdQuantityModel(ProductIdQuantityModel other)
	{
		this.productId = other.productId;
		this.quantity = other.quantity;
	}

	public String getProductId()
	{
		return productId;
	}

	public int getQuantity()
	{
		return quantity;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj instanceof ProductIdQuantityModel)
		{
			ProductIdQuantityModel other = (ProductIdQuantityModel) obj;
			return this.productId.equals(other.productId);
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return 41 * this.productId.hashCode();
	}

	@Override
	public String toString()
	{
		return String.format("ProductId: %s, Quantity: %s", productId, quantity);
	}
}
