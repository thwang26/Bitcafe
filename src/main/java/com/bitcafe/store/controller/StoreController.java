package com.bitcafe.store.controller;

import com.bitcafe.store.dto.StoreResponse;
import com.bitcafe.store.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @GetMapping("/store-list")
    ResponseEntity<List<StoreResponse>> getStoreList(
            @RequestParam(value = "lat") Double lat,
            @RequestParam(value = "lng") Double lng
    ) {
        return ResponseEntity.ok(storeService.getStoreList(lat, lng));
    }

    // 3km 이내의 매장만 가져옴
    // 가까운 순
    // TODO: 매장 즐겨찾기
}
