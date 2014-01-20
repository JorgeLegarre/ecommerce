package se.legarre.ecommerce.service;

import java.util.List;

import se.legarre.ecommerce.model.ProductIdQuantityModel;
import se.legarre.ecommerce.repository.StoreRepository;

public final class StoreService
{
	private StoreRepository storeRepository;

	public StoreService(StoreRepository storeRepository)
	{
		this.storeRepository = storeRepository;
	}

	public boolean addProductQuantity(String productId, int quantity)
	{
		return storeRepository.addProductQuantity(productId, quantity);
	}

	public boolean subtractProductQuantity(String productId, int quantity)
	{
		return storeRepository.subtractProductQuantity(productId, quantity);
	}

	public int getProductQuantity(String productId)
	{
		return storeRepository.getProductQuantity(productId);
	}

	public List<ProductIdQuantityModel> getListStoredProducts()
	{
		return storeRepository.getListStoredProducts();
	}
}
