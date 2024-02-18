package com.example.gabozang.controller;

import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreResInfo;
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
    public ResponseEntity<List<StoreResInfo>> SelectAllStore() throws IOException {
        return ResponseEntity.ok(storeService.selectAllStore());
    }

    /**
     *  Id로 특정 Store 조회
     */
    @GetMapping("/store/{storeId}")
    public ResponseEntity<StoreResInfo> SelectStoreById(@PathVariable int storeId) throws IOException {
        return ResponseEntity.ok(storeService.selectStoreById(storeId));
    }

    /**
     * 특정 점포 정보 수정
     */
    @PostMapping("/store/{storeId}")
    public ResponseEntity<Integer> updateStoreById(@PathVariable int storeId, @RequestBody StoreReqInfo storeReqInfo) {
        return ResponseEntity.ok(storeService.updateStoreById(storeId, storeReqInfo));
    }

    /**
     * 평점이 좋은 Top3 점포 출력
     */
    @GetMapping("/store/top3")
    public ResponseEntity<List<StoreResInfo>> selectStoreByIdTop3() {
        return ResponseEntity.ok(storeService.selectAllStoreTop3());
    }





}
