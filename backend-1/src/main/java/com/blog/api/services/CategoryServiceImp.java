package com.blog.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.blog.api.Exceptions.NoUsersFound;
import com.blog.api.Exceptions.ResourceNotFound;
import com.blog.api.dto.CategoryDto;
import com.blog.api.entities.Category;
import com.blog.api.repos.CategoryRepo;
@Service
public class CategoryServiceImp implements CategoryService {
	private CategoryRepo cr;
	private ModelMapper mapper;

	public CategoryServiceImp(CategoryRepo cr, ModelMapper mapper) {
		this.cr = cr;
		this.mapper = mapper;
	}

	@Override
	public CategoryDto createACategory(CategoryDto cat) {
		return categoryToDto(cr.save(dtoToCategory(cat)));

	}

	@Override
	public CategoryDto updateCategory(CategoryDto cat,Long id) {
		Category foundCategory =
				cr.findById(id).orElseThrow(() -> new ResourceNotFound("Category", "id", id));
		foundCategory.setCategoryTitle(cat.getCategoryTitle());
		foundCategory.setCategoryDescription(cat.getCategoryDescription());
		cr.save(foundCategory);
		return categoryToDto(foundCategory);
	}

	@Override
	public void deleteCategory(Long id) {
        if(cr.existsById(id)) {
        	cr.deleteById(id);
        }
        else {
        	throw new ResourceNotFound("Category","id",id);
        	
        }
	}

	@Override
	public CategoryDto getCategory(Long id) {
        Category cat=cr.findById(id).orElseThrow(()->new ResourceNotFound("Category","id",id));
        return categoryToDto(cat);
	}

	@Override
	public List<CategoryDto> getAll() {
		List<Category> categories=cr.findAll();
		if(categories.isEmpty()) {
			throw new NoUsersFound("There are no categories to be listed");
		}
		return categories.stream().map(cat->categoryToDto(cat)).collect(Collectors.toList());
	}

	private Category dtoToCategory(CategoryDto c) {
		return mapper.map(c, Category.class);
	}

	private CategoryDto categoryToDto(Category c) {
		return mapper.map(c, CategoryDto.class);
	}
}
