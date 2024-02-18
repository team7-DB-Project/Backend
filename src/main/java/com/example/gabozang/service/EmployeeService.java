package com.example.gabozang.service;

import com.example.gabozang.domain.employee.Dto.EmployeeRequestDto.EmployeeReqInfo;
import com.example.gabozang.domain.employee.Dto.EmployeeResponseDto.EmployeeResInfo;
import com.example.gabozang.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public String insertEmployee(EmployeeReqInfo employeeReqInfo) {
        return employeeRepository.insertEmployee(employeeReqInfo);
    }

    public List<EmployeeResInfo> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    public EmployeeResInfo selectEmployeeById(int employeeId) {
        return employeeRepository.selectEmployeeById(employeeId);
    }

    public String updateEmployeeById(int employeeId, EmployeeReqInfo employeeReqInfo) {
        return employeeRepository.updateEmployeeById(employeeId,employeeReqInfo);
    }

    public Integer countAllEmployee() {
        return employeeRepository.countAllEmployee();
    }

    public List<EmployeeResInfo> selectEmployeeTop3() {
        return employeeRepository.selectEmployeeTop3();
    }
}
