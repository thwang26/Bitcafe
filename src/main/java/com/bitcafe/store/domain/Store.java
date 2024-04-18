package com.bitcafe.store.domain;

import com.bitcafe.global.domain.BaseImageEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Store extends BaseImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String storeName;
    @Column(unique = true, nullable = false)
    private String storeAddr;
    @Column(nullable = false)
    private Double lat;
    @Column(nullable = false)
    private Double lng;
    @Column(nullable = false)
    private String storePhone;
}
