package com.example.gabozang.controller;

import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreReSInfo;
import com.example.gabozang.service.StoreService;
import java.io.IOException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    /**
     * Store 저장
     */
    @PostMapping("/store")
    public ResponseEntity<String> InsertStore(@RequestBody StoreReqInfo storeReqInfo) throws IOException {
        return ResponseEntity.ok(storeService.insertStore(storeReqInfo));
    }

    /**
     * 모든 Store 조회 (이름, 위치, 총 매출)
     */
    @GetMapping("/store")
    public ResponseEntity<List<StoreReSInfo>> SelectAllStore() throws IOException {
        return ResponseEntity.ok(storeService.selectAllStore());
    }

    /**
     *  Id로 특정 Store 조회
     */
    @GetMapping("/store/{storeId}")
    public ResponseEntity<StoreReSInfo> SelectStoreById(@PathVariable int storeId) throws IOException {
        return ResponseEntity.ok(storeService.selectStoreById(storeId));
    }

    /**
     * 매출 순위 Top 3 조회
     */



}
