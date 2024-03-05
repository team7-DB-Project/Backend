package com.example.gabozang.service;

import com.example.gabozang.domain.bonus.Dto.BonusRequestDto.BonusReqInfo;
import com.example.gabozang.domain.bonus.Dto.BonusResponseDto.BonusResInfo;
import com.example.gabozang.repository.BonusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BonusService {
    private final BonusRepository bonusRepository;
    public String insertBonus(BonusReqInfo bonusReqInfo) {
        return bonusRepository.insertBonus(bonusReqInfo);
    }

    public List<BonusResInfo> selectAllBonus() {
        return bonusRepository.selectAllBonus();
    }
}
