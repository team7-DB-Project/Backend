package com.example.gabozang.repository;

import com.example.gabozang.domain.employee.Dto.EmployeeRequestDto.EmployeeReqInfo;
import com.example.gabozang.domain.employee.Dto.EmployeeResponseDto.EmployeeResInfo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired //readme 참고
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String insertEmployee(EmployeeReqInfo employeeReqInfo){
        String createEmployeeQuery = "insert into employee (store_id, name, phone_number, years_of_service, employment_type, salary, manager_id,created_at, updated_at) VALUES (?,?,?,?,?,?,?,?,?)"; // 실행될 동적 쿼리문
        Object[] createEmployeeParams = new Object[]{employeeReqInfo.getStoreId(), employeeReqInfo.getName(), employeeReqInfo.getPhoneNumber(), employeeReqInfo.getYearsOfService(), employeeReqInfo.getEmploymentType(), employeeReqInfo.getSalary(), employeeReqInfo.getManagerId(), LocalDateTime.now(),LocalDateTime.now()};
        this.jdbcTemplate.update(createEmployeeQuery, createEmployeeParams);
        return "사원 정보 저장 완료";
    }

    public List<EmployeeResInfo> selectAllEmployee() {
        String selectEmployeeQuery = "select * from employee";
        return this.jdbcTemplate.query(selectEmployeeQuery,
                (rs, rowNum) -> new EmployeeResInfo(
                        rs.getInt("employee_id"),
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getInt("years_of_service"),
                        rs.getString("employment_type"),
                        rs.getInt("salary"),
                        rs.getInt("manager_id"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ));
    }

    public EmployeeResInfo selectEmployeeById(int employee_id) {
        String selectEmployeeQuery = "select * from employee where employee_id = ?";
        return this.jdbcTemplate.queryForObject(selectEmployeeQuery,
                (rs, rowNum) -> new EmployeeResInfo(
                        rs.getInt("employee_id"),
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getInt("years_of_service"),
                        rs.getString("employment_type"),
                        rs.getInt("salary"),
                        rs.getInt("manager_id"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()),
                employee_id
        );
    }

    @Transactional
    public String updateEmployeeById(int employeeId, EmployeeReqInfo employeeReqInfo) {
        String updateEmployeeQuery="update employee set store_id=?, name=?, phone_number=?, years_of_service=?, salary=?, manager_id=?,updated_at=? where employee_id=?";
        Object[] modifyEmployeeIdParams=new Object[]{employeeReqInfo.getStoreId(), employeeReqInfo.getName(), employeeReqInfo.getPhoneNumber(), employeeReqInfo.getYearsOfService(),
                employeeReqInfo.getSalary(), employeeReqInfo.getManagerId(),LocalDateTime.now(), employeeId};
        this.jdbcTemplate.update(updateEmployeeQuery,modifyEmployeeIdParams);
        return "사원 정보 수정 완료";
    }

    public int countAllEmployee() {
        String countEmployeeQuery = "select count(*) from employee";
        return this.jdbcTemplate.queryForObject(countEmployeeQuery, Integer.class);
    }

    public List<EmployeeResInfo> selectEmployeeTop3() {
        String selectEmployeeTop3Query = "SELECT * FROM employee E JOIN "
                + "(SELECT employee_id, sum(bonus_amount) as SUM_BONUS FROM bonus GROUP BY employee_id) B "
                + "on E.employee_id = B.employee_id "
                + "ORDER BY B.SUM_BONUS DESC "
                + "LIMIT 3";
        return this.jdbcTemplate.query(selectEmployeeTop3Query,
                (rs, rowNum) -> new EmployeeResInfo(
                        rs.getInt("employee_id"),
                        rs.getInt("store_id"),
                        rs.getString("name"),
                        rs.getString("phone_number"),
                        rs.getInt("years_of_service"),
                        rs.getString("employment_type"),
                        rs.getInt("salary"),
                        rs.getInt("manager_id"),
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                ));
    }

}
