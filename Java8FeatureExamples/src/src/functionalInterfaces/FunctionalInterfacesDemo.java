package src.functionalInterfaces;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import src.optional.employee.Employee;

public class FunctionalInterfacesDemo {
	public static void main(String[] args) {

		List<Employee> employee=new ArrayList<>(Arrays.asList(
				new Employee(101, "ramesh", 42, 45000.00),
				new Employee(102,"suresh" , 39, 65000.00)
				));
		//Predicate
		 Predicate<Employee> salaryPredicate = emp -> emp.getSalary() == 45000.00;
		 boolean employeeSalary = employee.stream().anyMatch(emp->salaryPredicate.test(emp));
		 System.out.println(employeeSalary);
		 //Bipredicate
		BiPredicate<Employee,Double> salaryPredicate1=(emp,salary)->emp.getSalary()>=salary;
		boolean empSalary = employee.stream().anyMatch(emp->salaryPredicate1.test(emp, 68000.00));
		System.out.println(empSalary);
		
		//consumer
		//define consumer which take employee as input and it will not returning anything 
		Consumer<Employee> printNameAndAge=emp->System.out.println(emp.getName()+": "+emp.getAge());
		// print employee name and age
		employee.forEach(emp->printNameAndAge.accept(emp));
		
		
		//suppliers 
		//creating suppliers that generate current time
		Supplier currentTimeSuppliers=()->LocalDateTime.now();
		LocalDateTime currentTime = (LocalDateTime) currentTimeSuppliers.get();
		System.out.println("today date and time"+" : "+currentTime);
		
	Function<String, Integer> function=(str)->str.length();
	Integer length = function.apply("suresh");
	System.out.println("length of the string is"+":"+length);
	//System.err.println(function.apply("suresh"));
		
		
	}
	
	
	
	

}
