package com.example.gabozang.domain.employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class EmployeeRequestDto {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EmployeeReqInfo {
        private int storeId;
        private String name;
        private String phoneNumber;
        private int yearsOfService;
        private String employmentType;
        private int salary;
        private int managerId;
    }
}
