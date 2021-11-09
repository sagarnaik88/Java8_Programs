package Java8.stream.api.preparation;

import java.util.Arrays;
import java.util.List;

/**
 * @author Sagar_27_10_2021
 *Given a list of integers, find out all the even numbers exist in the list
 *using Stream functions?
 */
public class StreamOddEvenInteger {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(10,15,8,49,25,98,32);
		intList.stream()
			.filter(n -> n%2 == 1)
			//.forEach(System.out::println);
			.forEach(n-> System.out.println(n));
	}

}
