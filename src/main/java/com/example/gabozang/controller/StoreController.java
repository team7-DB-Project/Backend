package com.example.gabozang.controller;

import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreRankInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreResInfo;
import com.example.gabozang.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import java.io.IOException;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    /**
     * Store 저장
     */
    @PostMapping("")
    @Operation(summary = "점포 입력")
    public ResponseEntity<String> InsertStore(@RequestBody StoreReqInfo storeReqInfo) throws IOException {
        return ResponseEntity.ok(storeService.insertStore(storeReqInfo));

    }

    /**
     * 모든 Store 조회 (이름, 위치, 총 매출)
     */
    @GetMapping("")
    @Operation(summary = "모든 점포 조회")
    public ResponseEntity<List<StoreResInfo>> SelectAllStore() throws IOException {
        return ResponseEntity.ok(storeService.selectAllStore());
    }

    /**
     *  Id로 특정 Store 조회
     */
    @GetMapping("/{storeId}")
    @Operation(summary = "특정 점포 ID로 조회")
    public ResponseEntity<StoreResInfo> SelectStoreById(@PathVariable int storeId) throws IOException {
        return ResponseEntity.ok(storeService.selectStoreById(storeId));
    }

    /**
     * 특정 점포 정보 수정
     */
    @PostMapping("/{storeId}")
    @Operation(summary = "특정 점포 정보 수정")
    public ResponseEntity<Integer> updateStoreById(@PathVariable int storeId, @RequestBody StoreReqInfo storeReqInfo) {
        return ResponseEntity.ok(storeService.updateStoreById(storeId, storeReqInfo));
    }

    /**
     * 평점이 좋은 Top3 점포 출력
     */
    @GetMapping("/top3")
    @Operation(summary = "평점이 좋은 점포 Top3")
    public ResponseEntity<List<StoreResInfo>> selectStoreByIdTop3() {
        return ResponseEntity.ok(storeService.selectAllStoreTop3());
    }

    /**
     * 올해 점포 매출 순위
     */
    @GetMapping("/sales/rank")
    @Operation(summary = "올해 점포 매출 순위")
    public ResponseEntity<List<StoreRankInfo>> selectSalesRankStore() {
        return ResponseEntity.ok(storeService.selectSalesRankStore());
    }


}
