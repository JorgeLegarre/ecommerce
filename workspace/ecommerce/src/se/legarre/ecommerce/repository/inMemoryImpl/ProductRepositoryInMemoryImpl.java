package se.legarre.ecommerce.repository.inMemoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.legarre.ecommerce.model.ProductModel;
import se.legarre.ecommerce.repository.ProductRepository;

public final class ProductRepositoryInMemoryImpl implements ProductRepository
{
	private static int idCounter = 1000;

	private Map<String, ProductModel> products;

	public ProductRepositoryInMemoryImpl()
	{
		products = new HashMap<String, ProductModel>();
	}

	@Override
	public String saveProduct(ProductModel product)
	{
		String idToSave = isNewProduct(product.getId()) ? getNextId() : product.getId();

		products.put(idToSave, new ProductModel(idToSave, product));

		return idToSave;
	}

	@Override
	public List<ProductModel> getAllProducts()
	{
		List<ProductModel> listProducts = new ArrayList<ProductModel>();

		for (ProductModel product : products.values())
		{
			listProducts.add(new ProductModel(product));
		}

		return listProducts;
	}

	@Override
	public ProductModel getProduct(String productId)
	{
		ProductModel product = products.get(productId);

		return (product == null) ? null : new ProductModel(product);
	}

	@Override
	public List<ProductModel> searchProductByName(String productName)
	{
		if (productName == null) return null;

		List<ProductModel> returnProducts = new ArrayList<ProductModel>();

		for (ProductModel product : products.values())
		{
			if (productName.equals(product.getName()))
			{
				returnProducts.add(new ProductModel(product));
			}
		}
		return returnProducts;
	}

	@Override
	public void removeProduct(String productId)
	{
		products.remove(productId);
	}

	private String getNextId()
	{
		idCounter++;
		return "P" + idCounter;
	}

	private boolean isNewProduct(String id)
	{
		return ProductModel.DEFAULT_ID.equals(id);
	}
}
