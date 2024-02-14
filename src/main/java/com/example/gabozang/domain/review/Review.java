package com.example.gabozang.domain.review;

import java.time.LocalDateTime;

public class Review {
    private int reviewId;
    private int storeId;
    private String content;
    private double rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
