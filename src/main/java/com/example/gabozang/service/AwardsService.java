package com.example.gabozang.service;

import com.example.gabozang.domain.awards.Dto.AwardsRequestDto.AwardsReqInfo;
import com.example.gabozang.domain.awards.Dto.AwardsResponseDto.AwardsResInfo;
import com.example.gabozang.repository.AwardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AwardsService {
    private final AwardsRepository awardsRepository;
    public String insertAwards(AwardsReqInfo awardsReqInfo) {
        return awardsRepository.insertAwards(awardsReqInfo);
    }

    public List<AwardsResInfo> selectAllAwards() {
        return awardsRepository.selectAllAwards();
    }
}
