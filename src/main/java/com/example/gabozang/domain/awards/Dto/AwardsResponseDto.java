package com.example.gabozang.domain.awards.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class AwardsResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AwardsResInfo {
        private int awardId;
        private int storeId;
        private int ranking;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
