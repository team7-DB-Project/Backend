package com.example.gabozang.repository;

import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreResInfo;
import jakarta.transaction.Transactional;
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
        String createStoreQuery = "insert into store (name, location, maximum_capacity, rating,image_url, phone_number) VALUES (?,?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createUserParams = new Object[]{storeReqInfo.getName(), storeReqInfo.getLocation(), storeReqInfo.getMaximumCapacity(), storeReqInfo.getRating(), storeReqInfo.getImageUrl(),
                storeReqInfo.getPhoneNumber()};
        this.jdbcTemplate.update(createStoreQuery, createUserParams);
        return "점포 정보 저장 완료";
    }

    public List<StoreResInfo> selectAllStore() {
        String selectStoreQuery = "select * from store";
        return this.jdbcTemplate.query(selectStoreQuery,
                (rs, rowNum) -> new StoreResInfo(
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("maximum_capacity"),
                        rs.getDouble("rating"),
                        rs.getString("image_url"),
                        rs.getString("phone_number")
                ));
    }

    public StoreResInfo selectStoreById(int store_id) {
        String selectStoreQuery = "select * from store where store_id = ?";
        return this.jdbcTemplate.queryForObject(selectStoreQuery,
                (rs, rowNum) -> new StoreResInfo(
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("maximum_capacity"),
                        rs.getDouble("rating"),
                        rs.getString("image_url"),
                        rs.getString("phone_number")),
                    store_id
                );
    }

    @Transactional
    public int updateStoreInfo(int storeId, StoreReqInfo storeReqInfo) {
        String updateStoreQuery = "update store set name = ?, location = ?, maximum_capacity = ?, rating = ?, image_url = ?," +
                " phone_number = ? where store_id = ?";
        Object[] modifyStoreIdParams = new Object[]{storeReqInfo.getName(), storeReqInfo.getLocation(),
                storeReqInfo.getMaximumCapacity(), storeReqInfo.getRating(), storeReqInfo.getImageUrl(),
                storeReqInfo.getPhoneNumber(), storeId};

        return this.jdbcTemplate.update(updateStoreQuery, modifyStoreIdParams);
    }

    public List<StoreResInfo> selectStoreTop3() {
        String selectStoreQuery = "select * from store order by rating desc limit 3";
        return this.jdbcTemplate.query(selectStoreQuery,
                (rs, rowNum) -> new StoreResInfo(
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getInt("maximum_capacity"),
                        rs.getDouble("rating"),
                        rs.getString("image_url"),
                        rs.getString("phone_number")
                ));
    }

}
