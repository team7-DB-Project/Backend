package com.example.gabozang.repository;

import com.example.gabozang.domain.employee.Dto.EmployeeRequestDto;
import com.example.gabozang.domain.employee.Dto.EmployeeResponseDto;
import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryRequestDto;
import com.example.gabozang.domain.paymentHisotry.Dto.PaymentHistoryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertEmployee(EmployeeRequestDto.EmployeeReqInfo employeeReqInfo){
        String createEmployeeQuery = "insert into employee (store_id, name, phone_number, years_of_service, employment_type, salary, manager_id) VALUES (?,?,?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createUserParams = new Object[]{employeeReqInfo.getStoreId(), employeeReqInfo.getName(), employeeReqInfo.getPhoneNumber(), employeeReqInfo.getYears_of_service(), employeeReqInfo.getEmploymentType(), employeeReqInfo.getSalary(), employeeReqInfo.getManagerId()};
        this.jdbcTemplate.update(createEmployeeQuery, createUserParams);
        return "사원 정보 저장 완료";
    }

    public List<EmployeeResponseDto.EmployeeResInfo> selectAllEmployee() {
        String selectEmployeeQuery = "select * from employee";
        return this.jdbcTemplate.query(selectEmployeeQuery,
                (rs, rowNum) -> new EmployeeResponseDto.EmployeeResInfo(
                        rs.getInt("employee_id"),
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getInt("years_of_service"),
                        rs.getString("employment_type"),
                        rs.getInt("salary"),
                        rs.getInt("manager_id")
                ));
    }

    public EmployeeResponseDto.EmployeeResInfo selectEmployeeById(int employee_id) {
        String selectEmployeeQuery = "select * from employee where employee_id = ?";
        return this.jdbcTemplate.queryForObject(selectEmployeeQuery,
                (rs, rowNum) -> new EmployeeResponseDto.EmployeeResInfo(
                        rs.getInt("employee_id"),
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getInt("years_of_service"),
                        rs.getString("employment_type"),
                        rs.getInt("salary"),
                        rs.getInt("manager_id")),
                employee_id
        );
    }
}
