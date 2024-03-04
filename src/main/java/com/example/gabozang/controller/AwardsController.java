package com.example.gabozang.controller;

import com.example.gabozang.domain.awards.Dto.AwardsRequestDto.AwardsReqInfo;
import com.example.gabozang.domain.awards.Dto.AwardsResponseDto.AwardsResInfo;
import com.example.gabozang.service.AwardsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/awards")
public class AwardsController {
    private final AwardsService awardsService;

    @PostMapping("")
    @Operation(summary = "수상 기록 입력")
    public ResponseEntity<String> InsertAwards(@RequestBody AwardsReqInfo awardsReqInfo) throws IOException {
        return ResponseEntity.ok(awardsService.insertAwards(awardsReqInfo));
    }

    @GetMapping("")
    @Operation(summary = "모든 수상 기록 조회")
    public ResponseEntity<List<AwardsResInfo>> SelectAllAwards() throws IOException {
        return ResponseEntity.ok(awardsService.selectAllAwards());
    }
}
