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
        member.addToCart(cart);
        cartRepository.save(cart);
    }

    public List<CartResponse> getCartList(String email) {
//        return memberService.getMember(email)
//                .getCartList()
//                .stream()
//                .map(CartResponse::from)
//                .collect(Collectors.toList());
// 쿼리 2개 / member 조회 후 member와 연관된 cart를 불러옴
        // 최소 13ms
        return cartRepository.findAllByMemberEmail(email)
                .stream()
                .map(CartResponse::from)
                .collect(Collectors.toList());
        // 쿼리 3개 / member와 연관된 cart를 불러온 후
        // member id로 member를 불러옴?
        // menu와 연관된 카테고리를 불러옴
        // 최소 13ms
        // 무슨 차이?
    }
}
