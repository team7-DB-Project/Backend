package com.example.gabozang.controller;

import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreInfo;
import com.example.gabozang.service.StoreService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    /**
     * Store 저장
     */
    @PostMapping("/store")
    public ResponseEntity<String> EatMedicine(@RequestBody StoreInfo storeInfo) throws IOException {
        return ResponseEntity.ok(storeService.insertStore(storeInfo));
    }

}
