package com.example.gabozang.domain.reviewImage.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewImageResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewImageResInfo {
        private int reviewImageId;
        private int reviewId;
        private String imageUrl;
    }
}
