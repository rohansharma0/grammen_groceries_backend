package com.cognizant.backend.service;

import com.cognizant.backend.payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto , long categoryId);

    CategoryDto getCategoryById(long categoryId);

    List<CategoryDto> getAllCategories();

    void deleteCategory(long categoryId);
}
