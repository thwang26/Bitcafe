package com.bitcafe.category.controller;

import com.bitcafe.category.dto.CategoryResponse;
import com.bitcafe.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping()
    ResponseEntity<List<CategoryResponse>> getCategory() {
        return ResponseEntity.ok(categoryService.getCategoryList());
    }
}
