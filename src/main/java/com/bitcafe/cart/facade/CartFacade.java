package com.bitcafe.cart.facade;

import com.bitcafe.cart.domain.Cart;
import com.bitcafe.cart.dto.CartRequest;
import com.bitcafe.cart.dto.CartResponse;
import com.bitcafe.cart.service.CartService;
import com.bitcafe.member.domain.Member;
import com.bitcafe.member.service.MemberService;
import com.bitcafe.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartFacade {

    private final CartService cartService;
    private final MemberService memberService;
    private final MenuService menuService;

    @Transactional
    public void addToCart(Long id, CartRequest cartRequest) {
        Member member = memberService.getMember(id);
        Cart cart = Cart.builder()
                .member(member)
                .menu(menuService.getMenuEntity(cartRequest.getMenuId()))
                .qty(cartRequest.getQty())
                .build();
        cartService.save(cart);
    }

    public List<CartResponse> getCartList(Long id) {
        return cartService.findAllByMemberId(id)
                .stream()
                .map(CartResponse::from)
                .collect(Collectors.toList());
    }
}
