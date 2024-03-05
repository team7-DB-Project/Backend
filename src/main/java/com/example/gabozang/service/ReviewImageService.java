package com.example.gabozang.service;

import com.example.gabozang.config.s3.S3Service;
import com.example.gabozang.config.s3.dto.S3Result;
import com.example.gabozang.domain.reviewImage.Dto.ReviewImageRequestDto.ReviewImageReqInfo;
import com.example.gabozang.domain.store.Dto.StoreRequestDto;
import com.example.gabozang.repository.ReviewImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewImageService {
    private final ReviewImageRepository reviewImageRepository;
    private final S3Service s3Service;
}
