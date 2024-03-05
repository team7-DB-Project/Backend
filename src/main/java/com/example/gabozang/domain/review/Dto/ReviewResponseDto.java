package com.example.gabozang.domain.review.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewResInfo {
        private int reviewId;
        private int storeId;
        private String content;
        private double rating;
        private List<String> imageUrls;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewRatingInfo {
        private int rating;
        private int count;
    }
}
