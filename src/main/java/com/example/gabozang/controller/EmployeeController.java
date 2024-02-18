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
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("")
    public ResponseEntity<String> InsertEmployee(@RequestBody EmployeeRequestDto.EmployeeReqInfo employeeReqInfo) throws IOException {
        return ResponseEntity.ok(employeeService.insertEmployee(employeeReqInfo));
    }

    @GetMapping("")
    public ResponseEntity<List<EmployeeResponseDto.EmployeeResInfo>> SelectAllEmployee() throws IOException {
        return ResponseEntity.ok(employeeService.selectAllEmployee());
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto.EmployeeResInfo> SelectEmployeeById(@PathVariable int employeeId) throws IOException {
        return ResponseEntity.ok(employeeService.selectEmployeeById(employeeId));
    }

    @PostMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployeeById(@PathVariable int employeeId, @RequestBody EmployeeRequestDto.EmployeeReqInfo employeeReqInfo) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeReqInfo));
    }

    /**
     *  총 직원 수
     */
    @GetMapping("/count")
    public ResponseEntity<Integer> countAllEmployee() {
        return ResponseEntity.ok(employeeService.countAllEmployee());
    }


}
