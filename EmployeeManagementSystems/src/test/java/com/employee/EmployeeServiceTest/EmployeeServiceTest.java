package com.employee.EmployeeServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.employee.Entity.Employee;
import com.employee.Repository.EmployeeRepository;
import com.employee.Service.EmployeeServiceImpl;

@ExtendWith(SpringExtension.class)

public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	@Mock
	private EmployeeRepository employeeRepository;

	@Test
	public void testSaveEmployee() {

		// creating Employee Object and inserting some values
		Employee employee = new Employee();
		employee.setEmpId(1);
		employee.setEmpName("sai");
		employee.setEmail("sai@gmail.com");
		employee.setPhNumber("7875638322");
		employee.setCreatedBy("admin");

		employee.setCreatedOn(LocalDate.of(2023, 03, 01));

		System.out.println("employeesss areee" + employee);

		when(employeeRepository.save(employee)).thenReturn(employee);

		Employee savedEmployee = employeeServiceImpl.saveEmployee(employee);

		System.out.println(savedEmployee);
		assertNotNull(savedEmployee);
		assertEquals(1, savedEmployee.getEmpId());
		assertEquals("sai", savedEmployee.getEmpName());
		assertEquals("sai@gmail.com", savedEmployee.getEmail());
		assertEquals("7875638322", savedEmployee.getPhNumber());
		assertEquals("admin", savedEmployee.getCreatedBy());

	}

	@Test
	public void testGetAllEmployees() {

		List<Employee> employeeList = new ArrayList<>();
		employeeList
				.add(new Employee(101, "kumar", "kumar@gmail.com", "7989382143", LocalDate.of(2023, 03, 24), "Admin"));
		employeeList.add(
				new Employee(102, "Srikath", "Srikath@gmail.com", "5989382143", LocalDate.of(2023, 03, 24), "admin"));
		employeeList.add(new Employee(103, "Ravikumar", "Ravikumar@gmail.com", "9989382143", LocalDate.of(2023, 03, 24),
				"admin"));
		when(employeeRepository.findAll()).thenReturn(employeeList);

		List<Employee> actualAllEmployees = employeeServiceImpl.getAllEmployees();
		assertEquals(employeeList, actualAllEmployees);
		System.out.println(actualAllEmployees);
		System.out.println(employeeList);
		verify(employeeRepository).findAll();

	}

	@Test
	public void testGetEmployeeById() {

		final Integer empId = 100;
		Employee employee = new Employee(100, "sriram", "sriram@gmail.com", "7878765543", LocalDate.of(2023, 03, 24),"admin");
		when(employeeRepository.findById(empId)).thenReturn(Optional.of(employee));
		Employee employeeById = employeeServiceImpl.getEmployeeById(empId);
		System.out.println(employeeById);
		assertNotNull(empId);

	}

	@Test
	public void testUpdateEmployee() {
		/*
		 * Integer empId=2; Employee employee =new Employee(); employee.setEmpId(empId);
		 * employee.setEmpName("sairam"); employee.setEmail("sai@gmail.com");
		 * employee.setPhNumber("7865432187"); employee.setCreatedBy("Manager");
		 * employee.setCreatedOn(LocalDate.of(2023, 03, 02));
		 * when(employeeRepository.findById(empId)).thenReturn(Optional.of(employee));
		 * Employee updatedEmlpyee = employeeServiceImpl.update(empId, employee);
		 * System.out.println(updatedEmlpyee); assertEquals(employee, updatedEmlpyee);
		 * assertNotNull(empId);
		 */
		//Employee employee = new Employee(1, "Sai", "sai@gmail.com","7878645372",LocalDate.of(2023, 03, 02),"Admin");
		Optional<Employee> opt = Optional.of(new Employee(1,"Lokesh","lokesh@gmail.com","7894543342",LocalDate.of(2023, 03, 01),"admin"));
		when(employeeRepository.findById(1)).thenReturn(opt);
		opt.get().setEmpName("sai");
		opt.get().setEmail("sai@gmail.com");
		given(employeeRepository.save(opt.get())).willReturn(opt.get());
		Employee updatedEmployee = employeeServiceImpl.update(1,opt.get());
		assertEquals("sai@gmail.com",updatedEmployee.getEmail());
	}

	@Test
	public void testDeleteEmployeeById() {
		Integer empId = 12;
		Employee employee = new Employee();
		employee.setEmpId(empId);
		when(employeeRepository.findById(empId)).thenReturn(Optional.of(employee));
		employeeServiceImpl.deleteEmployeeById(empId);
		verify(employeeRepository).deleteById(empId);
		assertNotNull(empId);
	}

}
