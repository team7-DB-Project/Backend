package com.example.gabozang.repository;

import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreReSInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StoreRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertStore(StoreReqInfo storeReqInfo){
        String createStoreQuery = "insert into store (name, location, maximum_capacity, rating,image_url, phone_number, total_sales) VALUES (?,?,?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createUserParams = new Object[]{storeReqInfo.getName(), storeReqInfo.getLocation(), storeReqInfo.getMaximumCapacity(), storeReqInfo.getRating(), storeReqInfo.getImageUrl(),
                storeReqInfo.getPhoneNumber(), storeReqInfo.getTotalSales()};
        this.jdbcTemplate.update(createStoreQuery, createUserParams);
        return "점포 정보 저장 완료";
    }

    public List<StoreReSInfo> selectAllStore() {
        String selectStoreQuery = "select * from store";
        return this.jdbcTemplate.query(selectStoreQuery,
                (rs, rowNum) -> new StoreReSInfo(
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("maximum_capacity"),
                        rs.getDouble("rating"),
                        rs.getString("image_url"),
                        rs.getString("phone_number"),
                        rs.getInt("total_sales")
                ));
    }

    public StoreReSInfo selectStoreById(int store_id) {
        String selectStoreQuery = "select * from store where store_id = ?";
        return this.jdbcTemplate.queryForObject(selectStoreQuery,
                (rs, rowNum) -> new StoreReSInfo(
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("maximum_capacity"),
                        rs.getDouble("rating"),
                        rs.getString("image_url"),
                        rs.getString("phone_number"),
                        rs.getInt("total_sales")),
                    store_id
                );
    }

}
