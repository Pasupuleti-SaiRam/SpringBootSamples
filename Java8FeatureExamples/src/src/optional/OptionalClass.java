package src.optional;

import java.util.Optional;

import src.optional.database.DataBase;
import src.optional.employee.Employee;
public class OptionalClass {
	
	
	public static void main(String[] args) {
		
		
	    Employee emp=new Employee(101, null, 23, 78000.00);
	    
	    Optional<Object> empty = Optional.empty();
	    System.out.println(empty);
	    
	    
	  //of
	 //use when sure that parameter will not be null, if null will throw exception else return value
	    Optional<Integer> employee = Optional.of(emp.getAge());
	    if(employee.isPresent()) {
	    	System.out.println("of sysout"+employee);
	    }
	    
	    Optional<String> nameOptional1 = Optional.ofNullable(emp.getName());
	    System.out.println(nameOptional1);
	    System.out.println(nameOptional1.orElse("name not availble"));
		
		 
		 
	    	

	}
}
