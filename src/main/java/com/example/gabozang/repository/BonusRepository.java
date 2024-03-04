package com.example.gabozang.repository;

import com.example.gabozang.domain.awards.Dto.AwardsResponseDto;
import com.example.gabozang.domain.bonus.Dto.BonusRequestDto.BonusReqInfo;
import com.example.gabozang.domain.bonus.Dto.BonusResponseDto.BonusResInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BonusRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertBonus(BonusReqInfo bonusReqInfo) {
        String createBonusQuery = "insert into bonus (employee_id, bonus_rate, reward_vacation_days, bonus_amount, created_at, updated_at) VALUES (?,?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createBonusParams = new Object[]{bonusReqInfo.getEmployeeId(), bonusReqInfo.getBonusRate(), bonusReqInfo.getRewardVacationDays(), bonusReqInfo.getBonusRate(), LocalDateTime.now(),LocalDateTime.now()};
        this.jdbcTemplate.update(createBonusQuery, createBonusParams);
        return "수상 기록 저장 완료";
    }

    public List<BonusResInfo> selectAllBonus() {
        String selectBonusQuery = "select * from bonus";
        return this.jdbcTemplate.query(selectBonusQuery,
                (rs, rowNum) -> new BonusResInfo(
                        rs.getInt("bonus_id"),
                        rs.getInt("employee_id"),
                        rs.getDouble("bonus_rate"),
                        rs.getInt("reward_vacation_days"),
                        rs.getInt("bonus_amount"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ));
    }
}
