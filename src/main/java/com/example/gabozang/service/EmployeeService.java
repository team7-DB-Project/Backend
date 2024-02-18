package com.example.gabozang.service;

import com.example.gabozang.domain.employee.Dto.EmployeeRequestDto;
import com.example.gabozang.domain.employee.Dto.EmployeeResponseDto;
import com.example.gabozang.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public String insertEmployee(EmployeeRequestDto.EmployeeReqInfo employeeReqInfo) {
        return employeeRepository.insertEmployee(employeeReqInfo);
    }

    public List<EmployeeResponseDto.EmployeeResInfo> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    public EmployeeResponseDto.EmployeeResInfo selectEmployeeById(int employeeId) {
        return employeeRepository.selectEmployeeById(employeeId);
    }

    public String updateEmployeeById(int employeeId, EmployeeRequestDto.EmployeeReqInfo employeeReqInfo) {
        return employeeRepository.updateEmployeeById(employeeId,employeeReqInfo);
    }
}
