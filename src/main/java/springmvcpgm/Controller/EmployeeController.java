package springmvcpgm.Controller;


import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import springmvcpgm.POJO.Admin;
import springmvcpgm.POJO.Employee;
import springmvcpgm.Service.AdminService;
import springmvcpgm.Service.EmployeeService;

@Controller

public class EmployeeController {
//upcoming requests
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/Home")
	public String Home(@SessionAttribute(value = "Login",required = false)Admin admin)  {
		if (admin!=null) {
			return "Home";
		}
		return "Login";
	
}
	@GetMapping("/Add")
	public String Add(@SessionAttribute(value = "Login",required = false)Admin admin) {
		if (admin!=null) {
			return "Add";
		}
		return "Login";
	}
	
	@PostMapping("/Add")
	public String AddEmployee(@RequestParam String name, @RequestParam String email, @RequestParam String contact, @RequestParam String designation, @RequestParam String salary, ModelMap Map) {
	Employee employee= service.addEmployee(name,email,contact,designation,salary);
	
	if (employee!= null) {
//		success response msg
		Map.addAttribute("msg", "data inserted successfully");
		return "Add";
		}
	Map.addAttribute("msg", "data not inserted");
	
	return "Add";
	}
	
//	search page
	@GetMapping("/search")
	public String search(@SessionAttribute(value = "Login",required = false)Admin admin) {
		if (admin!=null) {
			return "search";
		}
		return "Login";
	}
	
//	search employee
	@PostMapping("/search")
	public String searchEmployee(@RequestParam int id, ModelMap Map) {
		Employee employee=service.searchEmployee(id);
		if(employee!=null) {
			Map.addAttribute("msg","data found");
			Map.addAttribute("emp", employee);
			return "search";
		}
		Map.addAttribute("msg","data not found");
		return "search";
	}
//	remove page
	@GetMapping("/remove")
	public String remove(@SessionAttribute(value = "Login",required = false)Admin admin) {
		if (admin!=null) {
			return "remove";
		}
		return "Login";
		}
	
	
	@PostMapping("/remove")
	public String remove (@RequestParam int id, ModelMap map) {
		Employee employee = service.searchEmployee(id);
		if (employee!=null) {
//			success response
		
			service.removeEmployee(id);
			map.addAttribute("msg","Data removes successfully...!");
			return "remove";
			
		}
//		Failure response
		
		map.addAttribute("msg","Data does not exist...!");
		return "remove";
		
	}
	
	@GetMapping("/update")
	public String update(@SessionAttribute(value = "Login",required = false)Admin admin) {
		if (admin!=null) {
			return "update";
		}
		return "Login";
		}
	
	@PostMapping("/update")
	public String updateForm(@RequestParam int id,@RequestParam String name, @RequestParam String email,@RequestParam String contact,
			@RequestParam String designation, ModelMap map) {
		Employee employee=service.updateEmployee(id,name,email,contact,designation);
		if (employee!=null) {
//			success response
			map.addAttribute("msg","data inserted successfully..!");
			return "update";
			}
//		Failure response
		map.addAttribute("msg","Data not found..!");
		List<Employee> employees = service.searchAllEmployees();
		map.addAttribute("empList", employees);
		return "update";
	}
	
	
	//login page
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session) {
		
		map.addAttribute("msg","....logout Successfully...!");
		session.invalidate();
		return "Login";
	}
	
	
//	create page
	@GetMapping("/create")
	public String createAccount() {
		return "Admin";
	}
	@PostMapping("/create")
	public String addAdmin(@RequestParam String username, @RequestParam String password, ModelMap map) {
		Admin admin=adminService.addAdmin(username,password);
		if (admin!=null) {
			map.addAttribute("msg", "data inserted successfully");
			return "Admin";
			
		}
		map.addAttribute("msg", "data not inserted");
		
		return "Admin";
	}
	@PostMapping("/Login")
	public String Login(@RequestParam String username, @RequestParam String password, ModelMap map ,HttpServletRequest request) {
		Admin admin=adminService.Login(username,password);
		if (admin!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("Login", admin);
			map.addAttribute("msg", "data inserted successfully");
			return "Home";
			
		}
		map.addAttribute("msg","incorrect username or password");
		return "Login";
	}
}



