package com.example.gabozang.controller;

import com.example.gabozang.domain.review.Dto.ReviewRequestDto.ReviewReqInfo;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto.ReviewResInfo;
import com.example.gabozang.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<String> InsertReview(@RequestBody ReviewReqInfo reviewReqInfo) throws IOException {
        return ResponseEntity.ok(reviewService.insertReview(reviewReqInfo));
    }

    @GetMapping("/review")
    public ResponseEntity<List<ReviewResInfo>> SelectAllReview() throws IOException {
        return ResponseEntity.ok(reviewService.selectAllReview());
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity<ReviewResInfo> SelectReviewById(@PathVariable int reviewId) throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewById(reviewId));
    }

    @GetMapping("review/{storeId}")
    public ResponseEntity<ReviewResInfo> SelectReviewByStoreId(@PathVariable int storeId) throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewByStoreId(storeId));
    }

}
