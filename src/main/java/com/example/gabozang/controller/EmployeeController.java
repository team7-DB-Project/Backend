package com.example.gabozang.controller;

import com.example.gabozang.domain.employee.Dto.EmployeeRequestDto;
import com.example.gabozang.domain.employee.Dto.EmployeeResponseDto;
import com.example.gabozang.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<String> InsertEmployee(@RequestBody EmployeeRequestDto.EmployeeReqInfo employeeReqInfo) throws IOException {
        return ResponseEntity.ok(employeeService.insertEmployee(employeeReqInfo));
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeResponseDto.EmployeeResInfo>> SelectAllEmployee() throws IOException {
        return ResponseEntity.ok(employeeService.selectAllEmployee());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeResponseDto.EmployeeResInfo> SelectEmployeeById(@PathVariable int employeeId) throws IOException {
        return ResponseEntity.ok(employeeService.selectEmployeeById(employeeId));
    }

    @PostMapping("/employee/{employeeId}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable int employeeId, @RequestBody EmployeeRequestDto.EmployeeReqInfo employeeReqInfo) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeReqInfo));
    }
}
