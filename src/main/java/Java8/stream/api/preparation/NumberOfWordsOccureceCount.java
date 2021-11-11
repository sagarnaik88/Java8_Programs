package Java8.stream.api.preparation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Sagar_09_12_2021
 * Count the number of Occurence of the words in given string using java 8
 */
public class NumberOfWordsOccureceCount {

	public static void main(String[] args) {
		
		String str = "welcome to code decode and code decode welcome to you";
		List<String> stringList = Arrays.asList(str.split(" "));
		
		Map<String, Long> map = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(map);		
	}
}
