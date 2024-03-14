package com.bitcafe.category.service;

import com.bitcafe.category.domain.Category;
import com.bitcafe.category.dto.CategoryResponse;
import com.bitcafe.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> getCategoryList() {
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList.stream()
                .map(CategoryResponse::from)
                .collect(Collectors.toList());
    }
}
