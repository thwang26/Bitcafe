package com.bitcafe.store.dto;

public interface StoreResponse {
    Long getId();
    String getStoreName();
    String getStoreAddr();
    String getStorePhone();
    String getImagePath();
    Double getDistance();

}
