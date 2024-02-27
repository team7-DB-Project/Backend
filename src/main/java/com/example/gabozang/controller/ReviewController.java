package com.example.gabozang.controller;

import com.example.gabozang.domain.review.Dto.ReviewRequestDto.ReviewReqInfo;
import com.example.gabozang.domain.review.Dto.ReviewRequestDto.ReviewReqDateInfo;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto.ReviewResInfo;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto.ReviewRatingInfo;
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

    @GetMapping("/store/{storeId}")
    @Operation(summary = "특정 점포 리뷰 조회")
    public ResponseEntity<List<ReviewResInfo>> SelectReviewByStoreId(@PathVariable int storeId) throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewByStoreId(storeId));
    }

    @GetMapping("/rating/{rating}")
    @Operation(summary = "특정 점수 리뷰 조회")
    public ResponseEntity<List<ReviewResInfo>> SelectReviewByRating(@PathVariable int rating) throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewByRating(rating));
    }

    @GetMapping("/countByRating")
    @Operation(summary = "점수 별 리뷰 집계")
    public ResponseEntity<List<ReviewRatingInfo>> SelectReviewByRating() throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewGroupByRating());
    }

    @GetMapping("/reviewByDate")
    @Operation(summary = "기간 내 리뷰 검색")
    public ResponseEntity<List<ReviewResInfo>> SelectReviewByDate(@RequestBody ReviewReqDateInfo reviewReqDateInfo) throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewByDate(reviewReqDateInfo));
    }

    @GetMapping("/reviewByMonth/{month}")
    @Operation(summary = "단위 개월 내 리뷰 검색")
    public ResponseEntity<List<ReviewResInfo>> SelectReviewByDateDiff(@PathVariable int month) throws IOException {
        return ResponseEntity.ok(reviewService.selectReviewByDateDiff(month));
    }
}
