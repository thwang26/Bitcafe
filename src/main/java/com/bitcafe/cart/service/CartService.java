package com.bitcafe.cart.service;

import com.bitcafe.cart.domain.Cart;
import com.bitcafe.cart.dto.CartRequest;
import com.bitcafe.cart.dto.CartResponse;
import com.bitcafe.cart.repository.CartRepository;
import com.bitcafe.member.domain.Member;
import com.bitcafe.member.service.MemberService;
import com.bitcafe.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final MemberService memberService;
    private final MenuService menuService;
    private final CartRepository cartRepository;

    @Transactional
    public void addToCart(String email, CartRequest cartRequest) {
        Member member = memberService.getMember(email);
        Cart cart = Cart.builder()
                .member(member)
                .menu(menuService.getMenuEntity(cartRequest.getMenuId()))
                .qty(cartRequest.getQty())
                .build();
        cartRepository.save(cart);
    }

    public List<CartResponse> getCartList(String email) {
        return cartRepository.findAllByMemberEmail(email)
                .stream()
                .map(CartResponse::from)
                .collect(Collectors.toList());
    }
}
