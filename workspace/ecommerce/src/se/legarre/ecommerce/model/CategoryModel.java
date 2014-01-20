package se.legarre.ecommerce.model;

public final class CategoryModel
{
	public static final String DEFAULT_ID = "";
	public static final String DEFAULT_ROOT = "";

	private final String id;
	private String desc;
	private String rootCategory;

	private CategoryModel(String id, String desc, String rootCategory)
	{
		this.id = id;
		this.desc = desc;
		this.rootCategory = rootCategory;
	}

	public CategoryModel(String desc, String rootCategory)
	{
		this(DEFAULT_ID, desc, rootCategory);

	}

	public CategoryModel(String desc)
	{
		this(DEFAULT_ID, desc, DEFAULT_ROOT);
	}

	public CategoryModel(String id, CategoryModel other)
	{
		this(id, other.desc, other.rootCategory);
	}

	public CategoryModel(CategoryModel other)
	{
		this(other.id, other);
	}

	public String getId()
	{
		return id;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getRootCategory()
	{
		return rootCategory;
	}

	public void setRootCategory(String rootCategory)
	{
		this.rootCategory = rootCategory;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj instanceof CategoryModel)
		{
			CategoryModel other = (CategoryModel) obj;
			return this.equals(other.id);
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		return 27 * id.hashCode();
	}

	@Override
	public String toString()
	{
		return String.format("id: %s, desc: %s, rootCategory: %s", id, desc, rootCategory);
	}

}
