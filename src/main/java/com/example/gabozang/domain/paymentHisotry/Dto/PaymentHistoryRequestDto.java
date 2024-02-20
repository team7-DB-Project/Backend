package com.example.gabozang.domain.paymentHisotry.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PaymentHistoryRequestDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentHistoryReqInfo {
        private int sales;
        private int paymentId;
        private int storeId;
    }
}
