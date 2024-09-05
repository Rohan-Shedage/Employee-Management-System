package springmvcpgm.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvcpgm.POJO.Employee;
import springmvcpgm.Repository.EmployeeRepository;
@Service
public class EmployeeService {
//service logic 
	
	@Autowired
	EmployeeRepository repository;
	public Employee addEmployee(String name, String email, String contact, String desigantion, String salary) {
		Employee employee = repository.addEmployee(name, email, contact, desigantion, salary);
		return employee;
	}
	
	public Employee searchEmployee(int id) {
		Employee employee=repository.searchEmployee(id);
		return employee;
	}
	
	public List<Employee>searchAllEmployees(){
		List<Employee> employee=repository.searchAllEmployees();
		
		return employee;
		
	}
	
	public Employee removeEmployee(int id) {
		Employee employee=repository.removeEmployee(id);
		return employee;
	}
	
	public Employee updateEmployee(int id,String name, String email, String contact, String desigantion){
		Employee employee=repository.updateEmployee(id, name, email,contact, desigantion);
		return employee;
	}
}
