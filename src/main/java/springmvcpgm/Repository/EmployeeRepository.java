package springmvcpgm.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;



import springmvcpgm.POJO.Employee;
@Repository
public class EmployeeRepository {
	
//	hibernate logic
	private static EntityManager manager;
	private static EntityManagerFactory factor;
	private static EntityTransaction transaction;
//	private static String Query;
	private static Query query;
	private static String JPQL;
	
	private static void openConnection() {
		factor=Persistence.createEntityManagerFactory("emp");
		manager=factor.createEntityManager();
		transaction=manager.getTransaction();
	}
	private static void closeConnection() {
		if (factor!=null) {
			factor.close();
		}
		if (manager!=null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public Employee addEmployee(String name, String email, String contact, String desigantion, String salary) {
		// TODO Auto-generated method stub
		openConnection();
		transaction.begin();
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setContact(contact);
		employee.setDesignation(desigantion);
		employee.setSalary(salary);
		manager.persist(employee);
		transaction.commit();
		closeConnection();
		return employee;
	}
	public Employee searchEmployee(int id) {
		openConnection();
		transaction.begin();
		Employee employee=manager.find(Employee.class, id);
		transaction.commit();
		closeConnection();
		return employee;
	}
	public List<Employee> searchAllEmployees() {
		openConnection();
		transaction.begin();
		System.out.println("1");
		JPQL="from Employee";
		query=manager.createQuery(JPQL);
		List<Employee> employees=query.getResultList();
		transaction.commit();
		closeConnection();
		return employees;
	}
	
	public Employee removeEmployee(int id) {
		openConnection();
		transaction.begin();
		Employee employee = manager.find(Employee.class, id);
		manager.remove(employee);
		transaction.commit();
		closeConnection();
		return employee;
	}
	
	public Employee updateEmployee(int id, String name,String email, String contact,String designation) {
		openConnection();
		transaction.begin();
		Employee employee=manager.find(Employee.class, id);
		
			employee.setName(name);
			employee.setEmail(email);
			employee.setContact(contact);
			employee.setDesignation(designation);
			manager.persist(employee);
			transaction.commit();
			closeConnection();
		   return employee;
	}
}
