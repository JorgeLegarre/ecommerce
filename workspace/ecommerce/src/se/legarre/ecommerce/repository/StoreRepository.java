package se.legarre.ecommerce.repository;

import java.util.List;

import se.legarre.ecommerce.model.ProductIdQuantityModel;

public interface StoreRepository
{
	public boolean addProductQuantity(String productId, int quantity);

	public boolean subtractProductQuantity(String productId, int quantity);

	public int getProductQuantity(String productId);

	public List<ProductIdQuantityModel> getListStoredProducts();
}
