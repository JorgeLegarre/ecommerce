package se.legarre.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import se.legarre.ecommerce.model.CategoryModel;
import se.legarre.ecommerce.model.ProductIdQuantityModel;
import se.legarre.ecommerce.model.DetailModel;
import se.legarre.ecommerce.model.OrderModel;
import se.legarre.ecommerce.model.ProductModel;
import se.legarre.ecommerce.model.UserModel;
import se.legarre.ecommerce.repository.inMemoryImpl.CategoryRepositoryInMemoryImpl;
import se.legarre.ecommerce.repository.inMemoryImpl.OrderRepositoryInMemoryImpl;
import se.legarre.ecommerce.repository.inMemoryImpl.ProductRepositoryInMemoryImpl;
import se.legarre.ecommerce.repository.inMemoryImpl.StoreRepositoryInMemoryImpl;
import se.legarre.ecommerce.repository.inMemoryImpl.UserRepositoryInMemoryImpl;

public final class EcommerceService
{
	// Initialization of our services
	private CategoryService categoryService = new CategoryService(new CategoryRepositoryInMemoryImpl());
	private ProductService productService = new ProductService(new ProductRepositoryInMemoryImpl());
	private StoreService storeService = new StoreService(new StoreRepositoryInMemoryImpl());
	private UserService userService = new UserService(new UserRepositoryInMemoryImpl());
	private OrderService orderService = new OrderService(new OrderRepositoryInMemoryImpl());

	public EcommerceService()
	{
		categoryService = new CategoryService(new CategoryRepositoryInMemoryImpl());
		productService = new ProductService(new ProductRepositoryInMemoryImpl());
		storeService = new StoreService(new StoreRepositoryInMemoryImpl());
		userService = new UserService(new UserRepositoryInMemoryImpl());
		orderService = new OrderService(new OrderRepositoryInMemoryImpl());
	}

	/** public CATEGORY methods in EcommerceService */
	public String saveCategory(CategoryModel category)
	{
		return categoryService.saveCategory(category);
	}

	public List<CategoryModel> getAllCategories()
	{
		return categoryService.getAllCategories();
	}

	public List<CategoryModel> searchCategoryByDesc(String desc)
	{
		return categoryService.searchCategoryByDesc(desc);
	}

	/** public PRODUCT methods in EcommerceService */
	public void saveProduct(ProductModel product)
	{
		productService.saveProduct(product);
	}

	public List<ProductModel> getAllProducts()
	{
		return productService.getAllProducts();
	}

	public ProductModel getProduct(String productId)
	{
		return productService.getProduct(productId);
	}

	/** public STORE methods in EcommerceService */
	public void addProductQuantity(String productId, int quantity)
	{
		storeService.addProductQuantity(productId, quantity);

	}

	public List<ProductIdQuantityModel> getListStoredProducts()
	{
		return storeService.getListStoredProducts();
	}

	/** public USER methods in EcommerceService */
	public void saveUser(UserModel user)
	{
		userService.saveUser(user);
	}

	public List<UserModel> getAllUsers()
	{
		return userService.getAllUsers();
	}

	public UserModel getUser(String userName)
	{
		return userService.getUser(userName);
	}

	public List<ProductModel> searchProductByName(String name)
	{
		return productService.searchProductByName(name);
	}

	/** public ORDER methods in EcommerceService */
	public boolean placeOrder(OrderModel order)
	{
		List<DetailModel> listProductsWithoutEnoughStock = getProductsWithoutEnoughStock(order.getDetails());

		// if we have products that we can not satisfy, we cancel the order
		if (listProductsWithoutEnoughStock.size() > 0)
		{
			return false;
		}

		reduceProductsStock(order.getDetails());

		orderService.placeOrder(order);
		return true;
	}

	public List<DetailModel> getProductsWithoutEnoughStock(List<DetailModel> shoppingCartDetails)
	{
		List<DetailModel> listProductsWithoutEnoughStock = new ArrayList<DetailModel>();

		for (DetailModel detail : shoppingCartDetails)
		{
			String productId = detail.getProductId();
			int productStock = storeService.getProductQuantity(productId);

			if (productStock < detail.getQuantity())
			{
				listProductsWithoutEnoughStock.add(new DetailModel(productId, productStock, detail.getUnitPrice()));
			}

		}

		return listProductsWithoutEnoughStock;
	}

	private void reduceProductsStock(List<DetailModel> shoppingCartDetails)
	{
		for (DetailModel detail : shoppingCartDetails)
		{
			storeService.subtractProductQuantity(detail.getProductId(), detail.getQuantity());
		}
	}

	public List<OrderModel> getAllOrders()
	{
		return orderService.getAllOrders();
	}

}
