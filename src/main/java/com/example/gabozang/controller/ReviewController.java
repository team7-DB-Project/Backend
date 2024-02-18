package com.example.gabozang.controller;

import com.example.gabozang.domain.review.Dto.ReviewRequestDto.ReviewReqInfo;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto.ReviewResInfo;
import com.example.gabozang.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("")
    @Operation(summary = "리뷰 입력")
    public ResponseEntity<String> InsertReview(@RequestBody ReviewReqInfo reviewReqInfo) throws IOException {
        return ResponseEntity.ok(reviewService.insertReview(reviewReqInfo));
    }

    @GetMapping("")
    @Operation(summary = "모든 리뷰 조회")
    public ResponseEntity<List<ReviewResInfo>> SelectAllReview() throws IOException {
        return ResponseEntity.ok(reviewService.selectAllReview());
    }

    @GetMapping("/{reviewId}")
    @Operation(summary = "특정 리뷰 아이디로 조회")
    public ResponseEntity<ReviewResInfo> SelectReviewById(@PathVariable int reviewId) throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewById(reviewId));
    }

    @GetMapping("/{storeId}")
    @Operation(summary = "특정 점포 리뷰 조회")
    public ResponseEntity<ReviewResInfo> SelectReviewByStoreId(@PathVariable int storeId) throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewByStoreId(storeId));
    }

}
