package Java8.stream.api.preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sagar Naik : 15_11_2021
 * To convert employee list into Map using stream api
 *
 */
public class ConvertListInToMapEmployee {

	public static void main(String[] args) {
		
		List<Employee> empList =  new ArrayList<>();
		empList.add(new Employee(1, "Sagar", "Pune"));
		empList.add(new Employee(1, "Amar", "Sangli"));
		empList.add(new Employee(1, "Mandar", "Pune"));
		empList.add(new Employee(1, "Sunil", "Tasgoan"));
		empList.add(new Employee(1, "Vijay", "Sangli"));
		empList.add(new Employee(1, "sharmila", "Tasgoan"));		
		
		Map<String, List<Employee>> mapEmp =  empList.stream().collect(Collectors.groupingBy(Employee :: getCity));
		
		mapEmp.forEach((k,v) -> System.out.println("city is : "+k+ "Employee List :"+v));

	}

}

class Employee {
	
	int empNo;
	String name;
	String city;
	
	public Employee(int empid, String name, String city){
		
		this.empNo = empid;
		this.name = name;
		this.city = city;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}	
	
}
