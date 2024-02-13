package com.example.gabozang.repository;

import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class StoreRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertStore(StoreInfo storeInfo){
        String createUserQuery = "insert into store (name, location, maximum_capacity, rating,image_url, phone_number, total_sales) VALUES (?,?,?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createUserParams = new Object[]{storeInfo.getName(), storeInfo.getLocation(), storeInfo.getMaximumCapacity(), storeInfo.getRating(), storeInfo.getImageUrl(),
                storeInfo.getPhoneNumber(), storeInfo.getTotalSales()};
        this.jdbcTemplate.update(createUserQuery, createUserParams);
        return "점포 정보 저장 완료";
    }
}
