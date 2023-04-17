package com.employee.Service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;

import com.employee.Entity.Employee;
import com.employee.Exceptions.EmployeeNotFoundException;
import com.employee.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee saveEmployee(Employee employeeObj) {
		employeeRepo.save(employeeObj);
		return employeeRepo.save(employeeObj);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();

	}
	
	/*
	 * @Transactional
	 * 
	 * @Async public CompletableFuture<List<Employee>> findAllEmployees() {
	 * List<Employee> allEmployees = employeeRepo.findAll(); return
	 * CompletableFuture.completedFuture(allEmployees); }
	 */
	 

	@Override
	public Employee getEmployeeById(Integer empId) {

		Optional<Employee> employeeById = employeeRepo.findById(empId);
		if (employeeById.isPresent()) {
			return employeeById.get();
		} else {
			throw new EmployeeNotFoundException(" Employee Not Available With Thise Id" + " " + empId);
		}

	}
	@Override
	public Employee update(Integer empId, Employee employeeObj) {

		Optional<Employee> employeeId = employeeRepo.findById(empId);
		if (employeeId !=null) {
			Employee savedEmployee = employeeRepo.save(employeeObj);
			return savedEmployee;
		} else {
			throw new EmployeeNotFoundException("Employee Not Available With Thise Id" + " " + empId);
		}
		
	}

	@Override
	public boolean deleteEmployeeById(Integer empId) {
		Optional<Employee> findById = employeeRepo.findById(empId);
		if (findById.isPresent()) {
			employeeRepo.deleteById(empId);
			return true;
		} else {
			throw new EmployeeNotFoundException("Employee Not Available With Thise Id" + " " + empId);
		}
	}



	@Override
	public Page<Employee> findPages(int pageNumber, int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize);
		
		/*int number = findAll.getNumber();
		int size = findAll.getSize();
		List<Employee> content = findAll.getContent();
		int numberOfRecordsOnPage = content.size();*/
		return  employeeRepo.findAll(pages);
	}

}
