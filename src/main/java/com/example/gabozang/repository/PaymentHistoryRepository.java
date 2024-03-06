package com.example.gabozang.repository;

import com.example.gabozang.domain.paymentHisotry.Dto.*;
import com.example.gabozang.domain.paymentHisotry.Dto.*;
import com.example.gabozang.domain.review.Dto.ReviewRequestDto;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PaymentHistoryRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertPaymentHistory(PaymentHistoryRequestDto.PaymentHistoryReqInfo paymentHistoryReqInfo){
        String createPaymentHistoryQuery = "insert into payment_history (sales, payment_id, store_id,created_at, updated_at) VALUES (?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createPaymentHistoryParams = new Object[]{paymentHistoryReqInfo.getSales(), paymentHistoryReqInfo.getPaymentId(),paymentHistoryReqInfo.getStoreId(), LocalDateTime.now(),LocalDateTime.now()};
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

    public Integer selectAllSum() {
        String selectAllSum = "select SUM(sales) FROM payment_history";
        return this.jdbcTemplate.queryForObject(selectAllSum, Integer.class);
    }

    public Integer selectYearAllSum() {
        String selectYearAllSum = "SELECT SUM(sales) FROM payment_history "
                + "WHERE YEAR(created_at) = YEAR(NOW()) ";
        return this.jdbcTemplate.queryForObject(selectYearAllSum, Integer.class);
    }
    public Integer selectLastYearAllSum() {
        String selectYearAllSum = "SELECT SUM(sales) FROM payment_history "
                + "WHERE YEAR(created_at) = YEAR(NOW()) - 1 ";
        return this.jdbcTemplate.queryForObject(selectYearAllSum, Integer.class);
    }

    public Integer selectTodaySum() {
        String selectTodaySum = "SELECT sum(sales) FROM payment_history "
                + "WHERE DAY(created_at) = DAY(NOW()) ";
        return this.jdbcTemplate.queryForObject(selectTodaySum, Integer.class);
    }

    public Integer selectYesterdaySum() {
        String selectTodaySum = "SELECT sum(sales) FROM payment_history "
                + "WHERE DAY(created_at) = DAY(NOW()) - 1";
        return this.jdbcTemplate.queryForObject(selectTodaySum, Integer.class);
    }

    /**
     * 단위 면적 당 총 매출
     */
    public List<PaymentHistoryResponseDto.PaymentHistoryAll> selectSumPaymentByDateAndSales(String startDate, String lastDate) {
        String selectPaymentByDateAndSales = "SELECT s.name, (SUM(ph.sales)/s.maximum_capacity) as sum_sales " +
                "FROM payment_history as ph JOIN store as s " +
                "ON ph.store_id = s.store_id " +
                "WHERE ph.created_at between date(?) and date(?) " +
                "GROUP BY ph.store_id " +
                "ORDER BY SUM(ph.sales)/s.maximum_capacity DESC";
        return this.jdbcTemplate.query(selectPaymentByDateAndSales,
                (rs, rowNum) -> new PaymentHistoryResponseDto.PaymentHistoryAll(
                        rs.getString("name"),
                        rs.getDouble("sum_sales")
                ),startDate,lastDate);
    }

    /**
     * 카드회사별
     */
    public List<PaymentHistoryResponseDto.PaymentHistoryCardResInfo> selectCard(String startDate, String lastDate) {
        String selectQuery = "select p.classification_value as name , sum(ph.sales) as sales_sum , count(*) as card_count " +
        "from payment_history as ph, payment as p " +
        "where ph.payment_id=p.payment_id " +
        "and created_at BETWEEN date(?) and date(?) " +
        "group by ph.payment_id " +
        "order by sales_sum desc, card_count desc; ";

        return this.jdbcTemplate.query(selectQuery,
                (rs, rowNum) -> new PaymentHistoryResponseDto.PaymentHistoryCardResInfo(
                        rs.getString("name"),
                        rs.getInt("sales_sum"),
                        rs.getInt("card_count")
                ),startDate,lastDate);
    }

}
