package com.host.domain.hrservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.host.domain.hrservice.domain.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
//	@Query ("select e from Employees e where e.departmentId = :departmentId")
//	List <Employees> getEmployees (@Param("departmentId") int departmentId);

	@Query("select e from Employees e where email=:email")
	Employees getEmployeeByEmail(@Param("email") String email);

//	@Query ("SELECT E.FIRST_NAME FROM DEPARTMENTS D LEFT OUTER JOIN EMPLOYEES E ON (D.MANAGER_ID = E.EMPLOYEE_ID) WHERE D.DEPARTMENT_ID =:departmentId")
//	List getManagersByDepartmentId (@Param("departmentId") int departmentId);
	@Query("select e from Employees e where departmentId=:departmentId")
	List<Employees> getEmployeesByDepartmentId(@Param("departmentId") int departmentId);
}