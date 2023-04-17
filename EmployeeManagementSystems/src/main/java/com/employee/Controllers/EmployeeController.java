package com.employee.Controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Dto.PageDto;
import com.employee.Entity.Employee;
import com.employee.Service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<Employee> save(@Valid @RequestBody Employee employeeObj) {

		Employee saveEmployee = employeeService.saveEmployee(employeeObj);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Employee>> findAll() {
		return ResponseEntity.ok(employeeService.getAllEmployees());

	}

	/*
	 * @GetMapping(value = "/getAllEmployees") public
	 * ResponseEntity<CompletableFuture<List<Employee>>> findAllEmployees() {
	 * CompletableFuture<List<Employee>> findAllResult =
	 * employeeService.findAllEmployees(); return ResponseEntity.ok(findAllResult);
	 * }
	 */
	@GetMapping(value = "/getPages")
	public ResponseEntity<PageDto<Employee>> getEmployeesByPages(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam int pageSize) {
		Page<Employee> findPages = employeeService.findPages(pageNumber, pageSize);
		List<Employee> content = findPages.getContent();
		long totalElementsInDataBase = findPages.getTotalElements();
		int numberOfElements = findPages.getNumberOfElements();
		int totalPages = findPages.getTotalPages();
		PageDto<Employee> pageDto=new PageDto();
		pageDto.setPageData(content);
		pageDto.setNumberOfElements(numberOfElements);
		pageDto.setTotalElements(totalElementsInDataBase);
		pageDto.setTotalPageNumber(totalPages);
		return ResponseEntity.ok(pageDto);

	}

	@GetMapping(value = "/getEmployee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employeeById = employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employeeById);

	}

	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee empDetails) {
		Employee existEmployee = new Employee();
		Employee employeeById = employeeService.getEmployeeById(id);
		existEmployee.setEmpId(employeeById.getEmpId());
		existEmployee.setEmpName(empDetails.getEmpName());
		existEmployee.setEmail(empDetails.getEmail());
		existEmployee.setPhNumber(empDetails.getPhNumber());
		Employee updatedEmployee = employeeService.saveEmployee(existEmployee);
		System.out.println();
		System.out.println(id);
		return ResponseEntity.ok(updatedEmployee);

	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
		return ResponseEntity.ok("Employee Record deleted with id " + id);

	}

}
