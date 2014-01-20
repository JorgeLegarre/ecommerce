package se.legarre.ecommerce.model;

public final class ProductModel
{
	public static final String DEFAULT_ID = "";

	private final String id;
	private String name;
	private String description;
	private String category;
	private double price;

	private ProductModel(String id, String name, String description, String category,
			double price)
	{
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
	}

	public ProductModel(String name, String description, String category, double price)
	{
		this(DEFAULT_ID, name, description, category, price);
	}

	public ProductModel(String productId, ProductModel other)
	{
		this(productId, other.name, other.description, other.category, other.price);
	}
	
	public ProductModel(ProductModel other)
	{
		this(other.id, other);
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getPrice()
	{
		return price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj instanceof ProductModel)
		{
			ProductModel other = (ProductModel) obj;

			return this.id.equals(other.id);
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return 31 * id.hashCode();
	}

	@Override
	public String toString()
	{
		return String.format(
				"id: %s, name: %s, description: %s, Category: %s, price: %s:-",
				id, name, description, category, price);
	}
}
