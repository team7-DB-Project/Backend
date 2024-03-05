package com.example.gabozang.repository;

import com.example.gabozang.domain.reviewImage.Dto.ReviewImageRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewImageRepository {

    private JdbcTemplate jdbcTemplate;

}
