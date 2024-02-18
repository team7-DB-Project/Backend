package com.example.gabozang.service;

import com.example.gabozang.domain.review.Dto.ReviewRequestDto.ReviewReqInfo;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto.ReviewResInfo;
import com.example.gabozang.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public String insertReview(ReviewReqInfo reviewReqInfo) {
        return reviewRepository.insertReview(reviewReqInfo);
    }

    public List<ReviewResInfo> selectAllReview() {
        return reviewRepository.selectAllReview();
    }

    public ReviewResInfo selectReviewById(int reviewId) {
        return reviewRepository.selectReviewById(reviewId);
    }

    public ReviewResInfo selectReviewByStoreId(int storeId) { return reviewRepository.selectReviewByStoreId(storeId); }
}
