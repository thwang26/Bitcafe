package com.bitcafe.menu.dto;

import com.bitcafe.menu.domain.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class MenuResponse {
    private Long id;
    private String menuName;
    private String menuContent;
    private Integer menuPrice;
    private String imagePath;

    public static MenuResponse from(Menu menu) {
        return MenuResponse.builder()
                .id(menu.getId())
                .menuName(menu.getMenuName())
                .menuContent(menu.getMenuContent())
                .menuPrice(menu.getMenuPrice())
                .imagePath(menu.getImagePath())
                .build();
    }
}
