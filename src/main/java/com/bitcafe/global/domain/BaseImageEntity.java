package com.bitcafe.global.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseImageEntity extends BaseTimeEntity {
    private String imagePath;
}
