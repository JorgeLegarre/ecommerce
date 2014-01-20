package se.legarre.ecommerce.service;

import java.util.List;

import se.legarre.ecommerce.model.ProductModel;
import se.legarre.ecommerce.repository.ProductRepository;

public final class ProductService
{
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository)
	{
		this.productRepository = productRepository;
	}

	public String saveProduct(ProductModel product)
	{
		return productRepository.saveProduct(product);
	}

	public List<ProductModel> getAllProducts()
	{
		return productRepository.getAllProducts();
	}

	public ProductModel getProduct(String productId)
	{
		return productRepository.getProduct(productId);
	}

	public List<ProductModel> searchProductByName(String name)
	{
		return productRepository.searchProductByName(name);
	}

	public void removeProduct(String productId)
	{
		productRepository.removeProduct(productId);
	}
}
