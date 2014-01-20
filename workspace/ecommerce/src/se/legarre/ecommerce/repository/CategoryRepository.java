package se.legarre.ecommerce.repository;

import java.util.List;

import se.legarre.ecommerce.model.CategoryModel;

public interface CategoryRepository
{
	public String saveCategory(CategoryModel category);

	public List<CategoryModel> getAllCategories();

	public CategoryModel getCategory(String categoryId);

	public List<CategoryModel> searchCategoryByDesc(String categoryDesc);

	public void removeCategory(String categoryId);
}
