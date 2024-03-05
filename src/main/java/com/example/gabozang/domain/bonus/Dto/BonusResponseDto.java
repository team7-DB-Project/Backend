package com.example.gabozang.domain.bonus.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class BonusResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BonusResInfo {
        private int bonusId;
        private int employeeId;
        private double bonusRate;
        private int rewardVacationDays;
        private int bonusAmount;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
