package com.example.gabozang.controller;

import com.example.gabozang.domain.bonus.Dto.BonusRequestDto.BonusReqInfo;
import com.example.gabozang.domain.bonus.Dto.BonusResponseDto.BonusResInfo;
import com.example.gabozang.service.BonusService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bonus")
public class BonusController {
    private final BonusService bonusService;

    @PostMapping("")
    @Operation(summary = "보너스 입력")
    public ResponseEntity<String> InsertBonus(@RequestBody BonusReqInfo bonusReqInfo) throws IOException {
        return ResponseEntity.ok(bonusService.insertBonus(bonusReqInfo));
    }

    @GetMapping("")
    @Operation(summary = "모든 보너스 조회")
    public ResponseEntity<List<BonusResInfo>> SelectAllBonus() throws IOException {
        return ResponseEntity.ok(bonusService.selectAllBonus());
    }
}
