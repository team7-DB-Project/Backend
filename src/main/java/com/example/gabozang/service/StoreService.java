package com.example.gabozang.service;


import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreReSInfo;
import com.example.gabozang.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;

    public String insertStore(StoreReqInfo storeReqInfo) {
       return storeRepository.insertStore(storeReqInfo);
    }

    public List<StoreReSInfo> selectAllStore() {
        return storeRepository.selectAllStore();
    }

    public StoreReSInfo selectStoreById(int storeId) {
        return storeRepository.selectStoreById(storeId);
    }
}
