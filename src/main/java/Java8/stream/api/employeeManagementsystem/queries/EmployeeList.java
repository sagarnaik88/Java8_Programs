package Java8.stream.api.employeeManagementsystem.queries;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeList {
	public static void main(String args[]) {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// 1. Employee Query
		System.out.println("1. How many male and female employees are there in the organization? ");
		maleAndFemaleEmpInOrganisation(employeeList);
		System.out.println("\n");

		// 2. Employee Query
		System.out.println("2. Print the name of all departments in the organization? ");
		nameofDepartmentsInOrganisation(employeeList);
		System.out.println("\n");

		// 3. Employee Query
		System.out.println("3. What is the average age of male and female employees? ");
		averageAgeOfMaleAndFemale(employeeList);
		System.out.println("\n");

		// 4. Employee Query
		System.out.println("4. Get the details of highest paid employee in the organization? ");
		toGetHigestPaidEmployee(employeeList);
		System.out.println("\n");

		// 5. Employee Query
		System.out.println("5. Get the details of lowest paid employee in the organization? ");
		toGetLowestPaidEmployee(employeeList);
		System.out.println("\n");

		// 6. Employee Query
		System.out.println("6. Get the names of all employees who have joined after 2015? ");
		toGetAllEmployeeBeforeJoining2015(employeeList);
		System.out.println("\n");

		// 7. Employee Query
		System.out.println("7. What is the average salary of each department? ");
		toGetAllAverageSalaryOfEachDepartmet(employeeList);
		System.out.println("\n");

		// 8. Employee Query
		System.out.println("8. Count the number of employees in each department?");
		toGetCountOfEmployeeInEachDepartmet(employeeList);
		System.out.println("\n");

		// 9. Employee Query
		System.out.println("9. Get the details of youngest male employee in the product development department?");
		toGetYoungestMaleOfEachDepartment(employeeList);
		System.out.println("\n");

		// 10. Employee Query
		System.out.println("10. Who has the most working experience in the organization?");
		toGetMaxExperience(employeeList);
		System.out.println("\n");

		// 10. Employee Query
		System.out.println("10. Who has the most working experience in the organization?");
		toGetMaxExperience(employeeList);
		System.out.println("\n");

		// 11. Employee Query
		System.out.println("11. How many male and female employees are there in the sales and marketing team?");
		toGetCountOfEmployeeInSalesAndMarketing(employeeList);
		System.out.println("\n");
		
		// 12. Employee Query
		System.out.println("12. What is the average salary of male and female employees?");
		toGetAvgSalaryOfMaleAndFemale(employeeList);
		System.out.println("\n");
		
		
		// 13. Employee Query
		System.out.println("13. List down the names of all employees in each department?");
		toGetAllEmployeeDepartmentWise(employeeList);
		System.out.println("\n");
	}

	private static void toGetAllEmployeeDepartmentWise(List<Employee> employeeList) {
		
		Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee :: getDepartment));
		
		System.out.println(collect);
		
	}

	private static void toGetAvgSalaryOfMaleAndFemale(List<Employee> employeeList) {
		Map<String, Double> collect = employeeList.stream().collect(Collectors.groupingBy(Employee :: getGender, Collectors.averagingDouble(Employee :: getSalary)));
		System.out.println(collect);
	}

	private static void toGetCountOfEmployeeInSalesAndMarketing(List<Employee> employeeList) {
		Map<String, Long> collect = employeeList.stream().filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(collect);
	}

	private static void toGetMaxExperience(List<Employee> employeeList) {
		Optional<Employee> findFirst = employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearofjoining))
				.findFirst();
		System.out.println(findFirst);
	}

	private static void toGetYoungestMaleOfEachDepartment(List<Employee> employeeList) {

		System.out.println(" ===== To get youngest male employee in the Each department====");

		Map<String, Optional<Employee>> collect = employeeList.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparing(Employee::getAge))));

		System.out.println(collect);
		System.out.println("\n");

		System.out.println(" ===== To get youngest male employee in the product development department====");
		Optional<Employee> min = employeeList.stream()
				.filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparing(Employee::getAge));

		System.out.println(min);
	}

	private static void toGetCountOfEmployeeInEachDepartmet(List<Employee> employeeList) {
		Map<String, Long> noOfCountofemp = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.print(noOfCountofemp);
	}

	private static void toGetAllAverageSalaryOfEachDepartmet(List<Employee> employeeList) {
		Map<String, Double> deptAvgSalary = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(deptAvgSalary);

	}

	private static void toGetAllEmployeeBeforeJoining2015(List<Employee> employeeList) {
		employeeList.stream().filter(e -> e.getYearofjoining() < 2015).map(Employee::getName)
				.forEach(System.out::println);
	}

	private static void toGetLowestPaidEmployee(List<Employee> employeeList) {
		Employee employee = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(employee);
	}

	private static void toGetHigestPaidEmployee(List<Employee> employeeList) {
		Employee employee = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(employee);
	}

	private static void averageAgeOfMaleAndFemale(List<Employee> employeeList) {
		Map<String, Double> empAvg = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingLong(Employee::getAge)));
		System.out.println(empAvg);
	}

	private static void nameofDepartmentsInOrganisation(List<Employee> employeeList) {

		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

	}

	private static void maleAndFemaleEmpInOrganisation(List<Employee> emplist) {
		Map<String, Long> empMap = emplist.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(empMap);
	}

}
