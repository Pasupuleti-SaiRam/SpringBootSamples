package src.optional.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.optional.OptionalClass;
import src.optional.employee.Employee;

public class DataBase extends OptionalClass{
	
	public static List<Employee> getAll() {
		
		List<Employee> employee=new ArrayList<>(Arrays.asList(
				new Employee(1, "Balram", 24, 79000.00),
				new Employee(2, "sai", 26, 9000.00),
				new Employee(3, "ram", 27, 9000.00)));
		return employee;
		
		

		
	} 
	
}
