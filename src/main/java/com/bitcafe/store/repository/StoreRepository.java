package com.bitcafe.store.repository;

import com.bitcafe.store.domain.Store;
import com.bitcafe.store.dto.StoreResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query(value = "SELECT ROUND((6371 * ACOS(COS(RADIANS(:lat)) * COS" +
            "(RADIANS(lat)) * COS(RADIANS(lng) - RADIANS(:lng)) + SIN(RADIANS" +
            "(:lat)) * SIN(RADIANS(lat))" +
            ")), 3) as distance," +
            "       id," +
            "       image_path as imagePath," +
            "       store_addr as storeAddr," +
            "       store_name as storeName," +
            "       store_phone as storePhone " +
            "FROM store " +
            "HAVING distance <= 3.0 " +
            "ORDER BY distance ASC", nativeQuery = true)
    List<StoreResponse> getStoreList(@Param("lat") Double lat,
                                     @Param("lng") Double lng);
}
