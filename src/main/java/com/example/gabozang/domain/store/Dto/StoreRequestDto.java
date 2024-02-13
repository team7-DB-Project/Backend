package com.example.gabozang.domain.store.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoreRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreInfo {
        private String name;
        private String location;
        private int maximumCapacity;
        private double rating;
        private String imageUrl;
        private String phoneNumber;
        private int totalSales;
    }
}
