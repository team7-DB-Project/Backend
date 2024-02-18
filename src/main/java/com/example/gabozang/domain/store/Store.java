package com.example.gabozang.domain.store;

import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;

public class Store {
    private int storeId;
    private String name;
    private String location;
    private int maximumCapacity;
    private double rating;
    private String imageUrl;
    private String phoneNumber;
    private int totalSales;
}
