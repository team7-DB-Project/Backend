package com.example.gabozang.service;

import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryRequestDto;
import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryResponseDto;
import com.example.gabozang.domain.paymentHisotry.PaymentHistory;
import com.example.gabozang.domain.review.Dto.ReviewRequestDto;
import com.example.gabozang.domain.review.Dto.ReviewResponseDto;
import com.example.gabozang.repository.PaymentHistoryRepository;
import com.example.gabozang.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentHistoryService {

    private final PaymentHistoryRepository paymentHistoryRepository;
    public String insertPaymentHistory(PaymentHistoryRequestDto.PaymentHistoryReqInfo paymentHistoryReqInfo) {
        return paymentHistoryRepository.insertPaymentHistory(paymentHistoryReqInfo);
    }

    public List<PaymentHistoryResponseDto.PaymentHistoryResInfo> selectAllPaymentHistory() {
        return paymentHistoryRepository.selectAllPaymentHistory();
    }

    public PaymentHistoryResponseDto.PaymentHistoryResInfo selectPaymentHistoryById(int paymentHistoryId) {
        return paymentHistoryRepository.selectPaymentHistoryById(paymentHistoryId);
    }

    public Integer selectAllSum() {
        return paymentHistoryRepository.selectAllSum();
    }

    public Integer selectYearAllSum() {
        return paymentHistoryRepository.selectYearAllSum();
    }

    public Integer selectLastYearAllSum() {
        return paymentHistoryRepository.selectLastYearAllSum();
    }

    public Integer selectTodaySum() {
        return paymentHistoryRepository.selectTodaySum();
    }

    public Integer selectYesterdaySum() {
        return paymentHistoryRepository.selectYesterdaySum();
    }
 }
