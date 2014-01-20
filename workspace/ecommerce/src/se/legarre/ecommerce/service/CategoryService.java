package se.legarre.ecommerce.service;

import java.util.List;

import se.legarre.ecommerce.model.CategoryModel;
import se.legarre.ecommerce.repository.CategoryRepository;

public final class CategoryService
{
	private CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository)
	{
		this.categoryRepository = categoryRepository;
	}

	public String saveCategory(CategoryModel category)
	{
		return categoryRepository.saveCategory(category);
	}

	public List<CategoryModel> getAllCategories()
	{
		return categoryRepository.getAllCategories();
	}

	public CategoryModel getCategory(String id)
	{
		return categoryRepository.getCategory(id);
	}

	public List<CategoryModel> searchCategoryByDesc(String desc)
	{
		return categoryRepository.searchCategoryByDesc(desc);
	}

	public void removeCategory(String id)
	{
		categoryRepository.removeCategory(id);
	}
}
