package com.bitcafe.order.domain;

import com.bitcafe.member.domain.Member;
import com.bitcafe.store.domain.Store;
import com.bitcafe.global.domain.BaseTimeEntity;
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
public class Orders extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderPrice;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Store store;
}
