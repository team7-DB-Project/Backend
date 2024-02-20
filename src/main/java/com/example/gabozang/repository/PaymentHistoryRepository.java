package com.example.gabozang.repository;

import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryRequestDto;
import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryResponseDto;
import com.example.gabozang.domain.review.Dto.ReviewRequestDto;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PaymentHistoryRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertPaymentHistory(PaymentHistoryRequestDto.PaymentHistoryReqInfo paymentHistoryReqInfo){
        String createPaymentHistoryQuery = "insert into payment_history (sales, payment_id) VALUES (?,?)"; // 실행될 동적 쿼리문
        Object[] createPaymentHistoryParams = new Object[]{paymentHistoryReqInfo.getSales(), paymentHistoryReqInfo.getPaymentId()};
        this.jdbcTemplate.update(createPaymentHistoryQuery, createPaymentHistoryParams);
        return "리뷰 정보 저장 완료";
    }

    public List<PaymentHistoryResponseDto.PaymentHistoryResInfo> selectAllPaymentHistory() {
        String selectPaymentHistoryQuery = "select * from payment_history";
        return this.jdbcTemplate.query(selectPaymentHistoryQuery,
                (rs, rowNum) -> new PaymentHistoryResponseDto.PaymentHistoryResInfo(
                        rs.getInt("payment_history_id"),
                        rs.getInt("store_id"),
                        rs.getInt("sales"),
                        rs.getInt("payment_id"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ));
    }

    public PaymentHistoryResponseDto.PaymentHistoryResInfo selectPaymentHistoryById(int payment_history_id) {
        String selectPaymentHistoryQuery = "select * from payment_history where payment_history_id = ?";
        return this.jdbcTemplate.queryForObject(selectPaymentHistoryQuery,
                (rs, rowNum) -> new PaymentHistoryResponseDto.PaymentHistoryResInfo(
                        rs.getInt("payment_history_id"),
                        rs.getInt("store_id"),
                        rs.getInt("sales"),
                        rs.getInt("payment_id"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()),
                payment_history_id
        );
    }
}
