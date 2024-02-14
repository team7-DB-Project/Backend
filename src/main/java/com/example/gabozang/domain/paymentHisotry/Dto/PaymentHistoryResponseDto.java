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
        private LocalDateTime date;
        private int sales;
        private int paymentId;
    }
}
