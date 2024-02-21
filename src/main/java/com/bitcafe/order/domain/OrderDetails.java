package com.bitcafe.order.domain;

import com.bitcafe.global.domain.BaseTimeEntity;
import com.bitcafe.menu.domain.Menu;
import com.bitcafe.order.domain.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderDetails extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Menu menu;
}
