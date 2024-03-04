package com.example.gabozang.domain.paymentHisotry.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class PaymentHistoryResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentHistoryResInfo {
        private int privateHistoryId;
        private int sales;
        private int paymentId;
        private int storeId;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentHistoryAll {
        private String storeName;
        private Double sumSales;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentHistoryAll {
        private String storeName;
        private Double sumSales;
    }
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentHistorySumResInfo {
        private String name;
        private int sum;
        private double perPerson;
    }
}
