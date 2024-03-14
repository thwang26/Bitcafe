package com.bitcafe.menu.domain;

import com.bitcafe.global.domain.BaseImageEntity;
import com.bitcafe.category.domain.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Menu extends BaseImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String menuName;
    private String menuContent;
    private Integer menuPrice;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
