package com.bitcafe.cart.repository;


import com.bitcafe.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("select c from Cart c join fetch c.menu where c.member.id = :id")
    List<Cart> findAllByMemberId(@Param("id") Long id);
}
