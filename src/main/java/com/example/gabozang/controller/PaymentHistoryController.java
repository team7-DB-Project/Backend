package com.example.gabozang.controller;

import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryRequestDto;
import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryResponseDto;
import com.example.gabozang.domain.paymentHisotry.PaymentHistory;
import com.example.gabozang.domain.review.Dto.ReviewRequestDto;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto;
import com.example.gabozang.service.PaymentHistoryService;
import com.example.gabozang.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paymentHistory")
public class PaymentHistoryController {
    private final PaymentHistoryService paymentHistoryService;

    @PostMapping("")
    @Operation(summary = "매출 정보 입력")
    public ResponseEntity<String> PaymentHistoryReview(@RequestBody PaymentHistoryRequestDto.PaymentHistoryReqInfo paymentHistoryReqInfo) throws IOException {
        return ResponseEntity.ok(paymentHistoryService.insertPaymentHistory(paymentHistoryReqInfo));
    }

    @GetMapping("")
    @Operation(summary = "모든 매출 정보 조회")
    public ResponseEntity<List<PaymentHistoryResponseDto.PaymentHistoryResInfo>> SelectAllPaymentHistory() throws IOException {
        return ResponseEntity.ok(paymentHistoryService.selectAllPaymentHistory());
    }

    @GetMapping("/{paymentHistoryId}")
    @Operation(summary = "특정 매출 정보 ID로 조회")
    public ResponseEntity<PaymentHistoryResponseDto.PaymentHistoryResInfo> SelectPaymentHistoryById(@PathVariable int paymentHistoryId) throws IOException {
        return ResponseEntity.ok(paymentHistoryService.selectPaymentHistoryById(paymentHistoryId));
    }

    @GetMapping("sums")
    @Operation(summary = "총 매출액")
    public ResponseEntity<Integer> selectAllSum() {
        return ResponseEntity.ok(paymentHistoryService.selectAllSum());
    }
}
