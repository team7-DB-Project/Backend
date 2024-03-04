package com.example.gabozang.controller;
import com.example.gabozang.domain.reviewImage.Dto.ReviewImageRequestDto;
import com.example.gabozang.domain.reviewImage.Dto.ReviewImageRequestDto.ReviewImageReqInfo;
import com.example.gabozang.domain.reviewImage.Dto.ReviewImageResponseDto.ReviewImageResInfo;
import com.example.gabozang.domain.store.Dto.StoreRequestDto;
import com.example.gabozang.service.ReviewImageService;
import io.swagger.v3.oas.annotations.Operation;
import java.io.IOException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviewImage")
public class ReviewImageController {
    private final ReviewImageService reviewImageService;

    /**
     * ReviewImage 저장
     */
    @PostMapping("")
    @Operation(summary = "리뷰 이미지 저장")
    public ResponseEntity<String> InsertReviewImage(@RequestBody ReviewImageRequestDto.ReviewImageReqInfo reviewImageReqInfo) throws IOException {
        return ResponseEntity.ok(reviewImageService.insertReviewImage(reviewImageReqInfo));

    }
}
