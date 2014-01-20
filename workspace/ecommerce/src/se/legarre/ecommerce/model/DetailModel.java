package se.legarre.ecommerce.model;

public final class DetailModel
{
	private final String productId;
	private int quantity;
	private double unitPrice;

	public DetailModel(String productId, int quantity, double unitPrice)
	{
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public DetailModel(DetailModel other)
	{
		this(other.productId, other.quantity, other.unitPrice);
	}

	public String getProductId()
	{
		return productId;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public double getUnitPrice()
	{
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice)
	{
		this.unitPrice = unitPrice;
	}

	public double getSubtotal()
	{
		return quantity * unitPrice;
	}

	/** Eclipse generated */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + quantity;
		long temp;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/** Eclipse generated */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		DetailModel other = (DetailModel) obj;
		if (productId == null)
		{
			if (other.productId != null) return false;
		}
		else if (!productId.equals(other.productId)) return false;
		if (quantity != other.quantity) return false;
		if (Double.doubleToLongBits(unitPrice) != Double.doubleToLongBits(other.unitPrice)) return false;
		return true;
	}

	@Override
	public String toString()
	{
		return String.format("productId: %s, quantity: %s, unitPrice: %s", productId, quantity, unitPrice);
	}

}
