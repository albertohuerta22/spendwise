package com.spendwise.controller;

import com.spendwise.dto.CategoryDTO;
import com.spendwise.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.findAllCategories();
    }
    // Additional endpoints
}
