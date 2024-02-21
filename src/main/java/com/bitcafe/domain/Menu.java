package com.bitcafe.domain;

import com.bitcafe.domain.baseEntity.BaseImageEntity;
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
    private Category category;
}
