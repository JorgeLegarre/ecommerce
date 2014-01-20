package se.legarre.ecommerce.repository;

import java.util.List;

import se.legarre.ecommerce.model.ProductModel;

public interface ProductRepository
{
	public String saveProduct(ProductModel product);

	public List<ProductModel> getAllProducts();

	public ProductModel getProduct(String productId);

	public List<ProductModel> searchProductByName(String productName);

	public void removeProduct(String productId);
}
