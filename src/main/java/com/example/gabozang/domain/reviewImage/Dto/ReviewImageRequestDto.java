package com.example.gabozang.domain.reviewImage.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewImageRequestDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewImageReqInfo {
        private int reviewId;
        private String imageUrl;
    }
}
