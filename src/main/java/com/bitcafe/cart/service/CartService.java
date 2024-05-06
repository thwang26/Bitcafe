package com.bitcafe.cart.service;

import com.bitcafe.cart.domain.Cart;
import com.bitcafe.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> findAllByMemberId(Long id) {
        return cartRepository.findAllByMemberId(id);
    }
}
