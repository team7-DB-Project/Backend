package com.example.gabozang.domain.review.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewRequestDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewReqInfo {
        private int storeId;
        private String content;
        private double rating;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewReqDateInfo {
        private String startDate;
        private String endDate;
    }

}
