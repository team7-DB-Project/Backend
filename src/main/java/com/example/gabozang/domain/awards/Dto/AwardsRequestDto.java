package com.example.gabozang.domain.awards.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AwardsRequestDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AwardsReqInfo {
        private int storeId;
        private int ranking;
    }
}
