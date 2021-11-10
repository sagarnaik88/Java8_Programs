package Java8.stream.api.preparation;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sagar_09_11_2021
 * Given a list of integers, to check difference between Limit() and Skip()
 * using Stream functions?
  */
public class ExampleOfLimitAndSkip {
	
	public static void main(String[] args) {
	
		List<Integer> intList = Arrays.asList(10,20,30,40,52,14,74,2,4,85,2);
		
		//Comment out of each functionality and check outout
		// Limit example
		intList.stream().limit(7).forEach(n -> System.out.println(n));
		
		// Skip Example
		intList.stream().skip(7).forEach(n -> System.out.println(n));
		
		
	}
}
