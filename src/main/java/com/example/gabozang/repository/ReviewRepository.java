package com.example.gabozang.repository;

import com.example.gabozang.domain.review.Dto.ReviewRequestDto.ReviewReqInfo;
import com.example.gabozang.domain.review.Dto.ReviewRequestDto.ReviewReqDateInfo;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto.ReviewResInfo;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto.ReviewRatingInfo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
public class ReviewRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    public String insertReview(ReviewReqInfo reviewReqInfo){
        String createReviewQuery = "insert into review (store_id, content, rating, created_at, updated_at) VALUES (?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createReviewParams = new Object[]{reviewReqInfo.getStoreId(), reviewReqInfo.getContent(), reviewReqInfo.getRating(),LocalDateTime.now(),LocalDateTime.now()};
        this.jdbcTemplate.update(createReviewQuery, createReviewParams);
        String updateStoreRatingQuery="update store set rating=(select avg(rating) from review where store_id=?) where store_id=?";
        Object[] updateStoreRatingParams = new Object[]{reviewReqInfo.getStoreId(),reviewReqInfo.getStoreId()};
        this.jdbcTemplate.update(updateStoreRatingQuery,updateStoreRatingParams);
        return "리뷰 정보 저장 완료";
    }

    public List<ReviewResInfo> selectAllReview() {
        String selectReviewQuery = "select * from review";
        String selectReviewImageQuery = "select image_url from review_image where review_id = ?";
        return this.jdbcTemplate.query(selectReviewQuery,
                (rs, rowNum) -> new ReviewResInfo(
                        rs.getInt("review_id"),
                        rs.getInt("store_id"),
                        rs.getString("content"),
                        rs.getDouble("rating"),
                        this.jdbcTemplate.queryForList(selectReviewImageQuery,
                                new Object[]{rs.getInt("review_id")}, String.class),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ));
    }

    public ReviewResInfo selectReviewById(int review_id) {
        String selectReviewQuery = "select * from review where review_id = ?";
        String selectReviewImageQuery = "select image_url from review_image where review_id = ?";
        List<String> imageUrls = this.jdbcTemplate.queryForList(selectReviewImageQuery,
                new Object[]{review_id}, String.class);

        return this.jdbcTemplate.queryForObject(selectReviewQuery,
                (rs, rowNum) -> new ReviewResInfo(
                        rs.getInt("review_id"),
                        rs.getInt("store_id"),
                        rs.getString("content"),
                        rs.getDouble("rating"),
                        imageUrls,
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()),
                review_id
        );
    }

    public List<ReviewResInfo> selectReviewByStoreId(int storeId) {
        String selectReviewQuery = "select * from review where store_id = ?";
        String selectReviewImageQuery = "select image_url from review_image where review_id = ?";
        return this.jdbcTemplate.query(selectReviewQuery,
                (rs, rowNum) -> new ReviewResInfo(
                        rs.getInt("review_id"),
                        rs.getInt("store_id"),
                        rs.getString("content"),
                        rs.getDouble("rating"),
                        this.jdbcTemplate.queryForList(selectReviewImageQuery,
                                new Object[]{rs.getInt("review_id")}, String.class),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()),
                storeId
        );
    }

    public List<ReviewResInfo> selectReviewByRating(int rating) {
        String selectReviewQuery = "select * from review where rating = ?";
        String selectReviewImageQuery = "select image_url from review_image where review_id = ?";
        return this.jdbcTemplate.query(selectReviewQuery,
                (rs, rowNum) -> new ReviewResInfo(
                        rs.getInt("review_id"),
                        rs.getInt("store_id"),
                        rs.getString("content"),
                        rs.getDouble("rating"),
                        this.jdbcTemplate.queryForList(selectReviewImageQuery,
                                new Object[]{rs.getInt("review_id")}, String.class),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ), rating);
    }

    public List<ReviewRatingInfo> selectReviewGroupByRating() {
        String selectReviewQuery = "select rating, count(*) as count from review group by rating order by rating desc";
        return this.jdbcTemplate.query(selectReviewQuery,
                (rs, rowNum) -> new ReviewRatingInfo(
                        rs.getInt("rating"),
                        rs.getInt("count")
                ));
    }

    public List<ReviewResInfo> selectReviewByDate(ReviewReqDateInfo requestDateInfo) {
        String selectReviewQuery = "select * from review where created_at between date(?) and date(?)";
        String startDate=requestDateInfo.getStartDate();
        String endDate=requestDateInfo.getEndDate();
        String selectReviewImageQuery = "select image_url from review_image where review_id = ?";
        return this.jdbcTemplate.query(selectReviewQuery,
                (rs, rowNum) -> new ReviewResInfo(
                        rs.getInt("review_id"),
                        rs.getInt("store_id"),
                        rs.getString("content"),
                        rs.getDouble("rating"),
                        this.jdbcTemplate.queryForList(selectReviewImageQuery,
                                new Object[]{rs.getInt("review_id")}, String.class),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ), startDate,endDate);
    }

    public List<ReviewResInfo> selectReviewByDateDiff(int month) {
        String selectReviewQuery = "SELECT * FROM review WHERE created_at BETWEEN DATE_SUB(NOW(), INTERVAL ? MONTH ) AND NOW()";
        String selectReviewImageQuery = "select image_url from review_image where review_id = ?";
        return this.jdbcTemplate.query(selectReviewQuery,
                (rs, rowNum) -> new ReviewResInfo(
                        rs.getInt("review_id"),
                        rs.getInt("store_id"),
                        rs.getString("content"),
                        rs.getDouble("rating"),
                        this.jdbcTemplate.queryForList(selectReviewImageQuery,
                                new Object[]{rs.getInt("review_id")}, String.class),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ), month);
    }
}
