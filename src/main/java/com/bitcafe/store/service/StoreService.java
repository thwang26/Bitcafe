package com.bitcafe.store.service;

import com.bitcafe.store.dto.StoreResponse;
import com.bitcafe.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public List<StoreResponse> getStoreList(Double lat, Double lng) {
        return storeRepository.getStoreList(lat, lng);
    }
}
