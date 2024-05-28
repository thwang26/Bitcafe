package com.bitcafe.cart.controller;

import com.bitcafe.cart.dto.CartRequest;
import com.bitcafe.cart.dto.CartResponse;
import com.bitcafe.cart.facade.CartFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartFacade cartFacade;

    @PostMapping("")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> addToCart(@AuthenticationPrincipal UserDetails userDetails,
                                            @RequestBody CartRequest cartRequest) throws InterruptedException {
        cartFacade.addToCart(Long.parseLong(userDetails.getUsername()), cartRequest);
        return ResponseEntity.ok("장바구니 등록을 성공하였습니다.");
    }

    @GetMapping("")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<CartResponse>> getCartList(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(cartFacade.getCartList(Long.parseLong(userDetails.getUsername())));
    }
}
