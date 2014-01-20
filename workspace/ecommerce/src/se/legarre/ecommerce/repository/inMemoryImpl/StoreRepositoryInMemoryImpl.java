package se.legarre.ecommerce.repository.inMemoryImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.legarre.ecommerce.model.ProductIdQuantityModel;
import se.legarre.ecommerce.repository.StoreRepository;

public final class StoreRepositoryInMemoryImpl implements StoreRepository
{
	private Map<String, ProductIdQuantityModel> store;

	public StoreRepositoryInMemoryImpl()
	{
		store = new HashMap<String, ProductIdQuantityModel>();
	}

	@Override
	public boolean addProductQuantity(String productId, int quantity)
	{
		if (quantity < 0)
		{
			return false;
		}

		int newQuantity = getProductQuantity(productId) + quantity;

		store.put(productId, new ProductIdQuantityModel(productId, newQuantity));

		return true;
	}

	@Override
	public boolean subtractProductQuantity(String productId, int quantity)
	{
		if ((quantity < 0) || isNotProductInStore(productId))
		{
			return false;
		}

		int newQuantity = getProductQuantity(productId) - quantity;

		if (newQuantity < 0)
		{
			return false;
		}

		store.put(productId, new ProductIdQuantityModel(productId, newQuantity));

		return true;
	}

	private boolean isNotProductInStore(String productId)
	{
		return store.get(productId) == null;
	}

	@Override
	public int getProductQuantity(String productId)
	{
		return (store.get(productId) == null) ? 0 : store.get(productId).getQuantity();
	}

	@Override
	public List<ProductIdQuantityModel> getListStoredProducts()
	{
		List<ProductIdQuantityModel> listProductsInStock = new ArrayList<ProductIdQuantityModel>();

		for (ProductIdQuantityModel productStock : store.values())
		{
			listProductsInStock.add(new ProductIdQuantityModel(productStock));
		}

		return listProductsInStock;
	}
}
