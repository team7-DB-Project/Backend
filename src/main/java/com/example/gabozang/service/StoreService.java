package com.example.gabozang.service;


import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreInfo;
import com.example.gabozang.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public String insertStore(StoreInfo storeInfo) {
       return storeRepository.insertStore(storeInfo);
    }
}
