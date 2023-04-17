package src.optional;

import java.util.Optional;

public class OptionalPredefindMethods {
	
	public static void main(String[] args) {
		
		String str="suresh";
		Optional<String> opt = Optional.of(str);
        
        // isPresent()
        System.out.println(opt.isPresent()); // true
        
        // get() will get value
        String value = opt.get();
        System.out.println(value); 
        
        // orElse() if value is not there return default value
        String result = opt.orElse("Default Value");
        System.out.println(result); 
        
        Optional<String> emptyOpt = Optional.empty();
        System.out.println(emptyOpt);
        

	}

}
