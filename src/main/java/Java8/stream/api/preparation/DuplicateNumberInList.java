package Java8.stream.api.preparation;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNumberInList {

	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(10,5,48,12,10,5,10);
		Set<Integer> intSet = new HashSet<>();		
		intList.stream().filter(n -> !intSet.add(n)).collect(Collectors.toSet()).forEach(n -> System.out.println(n));
	}
}
