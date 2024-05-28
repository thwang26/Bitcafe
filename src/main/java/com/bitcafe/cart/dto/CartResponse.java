package com.bitcafe.cart.dto;

import com.bitcafe.cart.domain.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class CartResponse {
    private Long id;
    private String menuName;
    private String menuContent;
    private String imagePath;
    private Integer menuPrice;
    private Long qty;

    public static CartResponse from(Cart cart) {
        return CartResponse.builder()
                .id(cart.getId())
                .menuName(cart.getMenu().getMenuName())
                .menuContent(cart.getMenu().getMenuContent())
                .imagePath(cart.getMenu().getImagePath())
                .menuPrice(cart.getMenu().getMenuPrice())
                .qty(cart.getQty())
                .build();
    }
}
