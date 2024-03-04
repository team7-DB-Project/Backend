package com.example.gabozang.repository;

import com.example.gabozang.domain.awards.Dto.AwardsRequestDto.AwardsReqInfo;
import com.example.gabozang.domain.awards.Dto.AwardsResponseDto.AwardsResInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AwardsRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertAwards(AwardsReqInfo awardsReqInfo) {
        String createAwardsQuery = "insert into awards (store_id, ranking, created_at, updated_at) VALUES (?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createAwardsParams = new Object[]{awardsReqInfo.getStoreId(),awardsReqInfo.getRanking(),LocalDateTime.now(),LocalDateTime.now()};
        this.jdbcTemplate.update(createAwardsQuery, createAwardsParams);
        return "수상 기록 저장 완료";
    }

    public List<AwardsResInfo> selectAllAwards() {
        String selectAwardsQuery = "select * from awards";
        return this.jdbcTemplate.query(selectAwardsQuery,
                (rs, rowNum) -> new AwardsResInfo(
                        rs.getInt("awards_id"),
                        rs.getInt("store_id"),
                        rs.getInt("ranking"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ));
    }
}
