package com.bitcafe.domain;

import com.bitcafe.domain.baseEntity.BaseImageEntity;
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
    private double lat;
    @Column(nullable = false)
    private double lng;
    @Column(unique = true, nullable = false)
    private String storePhone;
}
