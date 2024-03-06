package com.example.gabozang.controller;

import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryRequestDto;
import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryResponseDto;
import com.example.gabozang.service.PaymentHistoryService;
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

    @GetMapping("/year/sums")
    @Operation(summary = "금년 총 매출액")
    public ResponseEntity<Integer> selectAllYearSum() {
        return ResponseEntity.ok(paymentHistoryService.selectYearAllSum());
    }

    @GetMapping("/lastYear/sums")
    @Operation(summary = "작년 총 매출액")
    public ResponseEntity<Integer> selectLastAllYearSum() {
        return ResponseEntity.ok(paymentHistoryService.selectLastYearAllSum());
    }

    @GetMapping("/today/sum")
    @Operation(summary = "금일 총 매출액")
    public ResponseEntity<Integer> selectTodaySum() {
        return ResponseEntity.ok(paymentHistoryService.selectTodaySum());
    }

    @GetMapping("/yesterday/sum")
    @Operation(summary = "익일 총 매출액")
    public ResponseEntity<Integer> selectYesterdaySum() {
        return ResponseEntity.ok(paymentHistoryService.selectYesterdaySum());
    }

    @GetMapping("/period/sums")
    @Operation(summary = "기간 동안 면적당 매출 순위")
    public ResponseEntity<List<PaymentHistoryResponseDto.PaymentHistoryAll>> selectSumPaymentByDateAndSales(@RequestBody PaymentHistoryRequestDto.PaymentHistoryAllInfo paymentHistoryAllInfo){
        return ResponseEntity.ok(paymentHistoryService.selectSumPaymentByDateAndSales(paymentHistoryAllInfo.getStartDate(), paymentHistoryAllInfo.getLastDate()));
    }

    @GetMapping("/period/card")
    @Operation(summary = "기간 동안 카드 순위")
    public ResponseEntity <List<PaymentHistoryResponseDto.PaymentHistoryCardResInfo>> selectCard(@RequestBody PaymentHistoryRequestDto.PaymentHistoryAllInfo paymentHistoryAllInfo) {
        return ResponseEntity.ok(paymentHistoryService.selectCard(paymentHistoryAllInfo.getStartDate(), paymentHistoryAllInfo.getLastDate()));
    }
}
