package com.example.gabozang.controller;

import com.example.gabozang.domain.employee.Dto.EmployeeRequestDto.EmployeeReqInfo;
import com.example.gabozang.domain.employee.Dto.EmployeeResponseDto.EmployeeResInfo;
import com.example.gabozang.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "직원 입력")
    public ResponseEntity<String> InsertEmployee(@RequestBody EmployeeReqInfo employeeReqInfo) throws IOException {
        return ResponseEntity.ok(employeeService.insertEmployee(employeeReqInfo));
    }

    @GetMapping("")
    @Operation(summary = "모든 직원 조회")
    public ResponseEntity<List<EmployeeResInfo>> SelectAllEmployee() throws IOException {
        return ResponseEntity.ok(employeeService.selectAllEmployee());
    }

    @GetMapping("/{employeeId}")
    @Operation(summary = "특정 직원 ID로 조회")
    public ResponseEntity<EmployeeResInfo> SelectEmployeeById(@PathVariable int employeeId) throws IOException {
        return ResponseEntity.ok(employeeService.selectEmployeeById(employeeId));
    }

    @PostMapping("/{employeeId}")
    @Operation(summary = "특정 직원 정보 수정")
    public ResponseEntity<String> updateEmployeeById(@PathVariable int employeeId, @RequestBody EmployeeReqInfo employeeReqInfo) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId,employeeReqInfo));
    }

    /**
     *  총 직원 수
     */
    @GetMapping("/count")
    @Operation(summary = "총 직원 수 조회")
    public ResponseEntity<Integer> countAllEmployee() {
        return ResponseEntity.ok(employeeService.countAllEmployee());
    }

    /**
     * 이번 달 우수 사원(TOP3)
     */
    @GetMapping("/top3")
    @Operation(summary = "이번 달 우수 사원 조회")
    public ResponseEntity<List<EmployeeResInfo>> selectEmployeeTop3() {
        return ResponseEntity.ok(employeeService.selectEmployeeTop3());
    }

}
