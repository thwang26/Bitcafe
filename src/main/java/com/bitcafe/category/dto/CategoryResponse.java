package com.bitcafe.category.dto;

import com.bitcafe.category.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class CategoryResponse {
    private Long id;
    private String categoryName;
    private String categoryContent;
    private String imagePath;

    public static CategoryResponse from(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .categoryName(category.getCategoryName())
                .categoryContent(category.getCategoryContent())
                .imagePath(category.getImagePath())
                .build();
    }
}

