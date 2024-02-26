package com.spendwise.service;

import com.spendwise.dto.CategoryDTO;
import com.spendwise.entity.Category;
import com.spendwise.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDTO> findAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<CategoryDTO> findAllCategoriesForUser(Long userId) {
        List<Category> categories = categoryRepository.findAll(); // This should be modified to filter by userId
        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryId(category.getCategoryId());
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        return dto;
    }

    // Additional service methods
}
