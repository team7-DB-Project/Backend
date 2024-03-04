package com.example.gabozang.domain.bonus.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class BonusRequestDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BonusReqInfo {
        private int employeeId;
        private double bonusRate;
        private int rewardVacationDays;
        private int bonusAmount;
    }
}
