package com.example.gabozang.service;


import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreResInfo;
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

    public List<StoreResInfo> selectAllStore() {
        return storeRepository.selectAllStore();
    }

    public StoreResInfo selectStoreById(int storeId) {
        return storeRepository.selectStoreById(storeId);
    }
    public int updateStoreById(int storeId, StoreReqInfo storeReqInfo) {
        return storeRepository.updateStoreInfo(storeId, storeReqInfo);
    }
    public List<StoreResInfo> selectAllStoreTop3() {
        return storeRepository.selectStoreTop3();
    }

}
