package com.employee.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Page;

import com.employee.Entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employeeObj);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(Integer EmpId);

	public Employee update(Integer empId, Employee employeeObj);

	public boolean deleteEmployeeById(Integer EmpId);

	public Page<Employee> findPages(int pageNumber, int pageSize);
	
	//public CompletableFuture<List<Employee>> findAllEmployees();

}
