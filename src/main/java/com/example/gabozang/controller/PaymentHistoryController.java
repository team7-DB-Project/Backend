package com.example.gabozang.controller;

import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryRequestDto;
import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryResponseDto;
import com.example.gabozang.domain.paymentHisotry.PaymentHistory;
import com.example.gabozang.domain.review.Dto.ReviewRequestDto;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto;
import com.example.gabozang.service.PaymentHistoryService;
import com.example.gabozang.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PaymentHistoryController {
    private final PaymentHistoryService paymentHistoryService;

    @PostMapping("/paymentHistory")
    public ResponseEntity<String> PaymentHistoryReview(@RequestBody PaymentHistoryRequestDto.PaymentHistoryReqInfo paymentHistoryReqInfo) throws IOException {
        return ResponseEntity.ok(paymentHistoryService.insertPaymentHistory(paymentHistoryReqInfo));
    }

    @GetMapping("/paymentHistory")
    public ResponseEntity<List<PaymentHistoryResponseDto.PaymentHistoryResInfo>> SelectAllPaymentHistory() throws IOException {
        return ResponseEntity.ok(paymentHistoryService.selectAllPaymentHistory());
    }

    @GetMapping("/paymentHistory/{paymentHistoryId}")
    public ResponseEntity<PaymentHistoryResponseDto.PaymentHistoryResInfo> SelectPaymentHistoryById(@PathVariable int paymentHistoryId) throws IOException {
        return ResponseEntity.ok(paymentHistoryService.selectPaymentHistoryById(paymentHistoryId));
    }
}
