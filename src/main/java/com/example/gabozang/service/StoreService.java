package com.example.gabozang.service;


import com.example.gabozang.config.s3.S3Service;
import com.example.gabozang.config.s3.dto.S3Result;
import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo;
import com.example.gabozang.domain.store.Dto.StoreRequestDto.StoreReqInfo2;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreRankInfo;
import com.example.gabozang.domain.store.Dto.StoreResponseDto.StoreResInfo;
import com.example.gabozang.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final S3Service s3Service;

    public String insertStore(List<MultipartFile> multipartFile, StoreReqInfo storeReqInfo) {
        List<S3Result> s3Results = s3Service.uploadFile(multipartFile);
        return storeRepository.insertStore(s3Results.get(0).getImgUrl(), storeReqInfo);
    }

    public List<StoreResInfo> selectAllStore() {
        return storeRepository.selectAllStore();
    }

    public StoreResInfo selectStoreById(int storeId) {
        return storeRepository.selectStoreById(storeId);
    }
    public int updateStoreById(int storeId, StoreReqInfo2 storeReqInfo) {
        return storeRepository.updateStoreInfo(storeId, storeReqInfo);
    }
    public List<StoreResInfo> selectAllStoreTop3() {
        return storeRepository.selectStoreTop3();
    }

    public List<StoreRankInfo> selectSalesRankStore() {
        return storeRepository.selectSalesRankStore();
    }
}
