package springmvcpgm.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvcpgm.POJO.Admin;
import springmvcpgm.Repository.AdminRepository;
@Service
public class AdminService {
	
@Autowired
AdminRepository repository;



	public Admin addAdmin(String username, String password) {
		
		Admin admin=AdminRepository.addAdmin(username, password);
		
		return admin;
	}

	public Admin Login(String username, String password) {
		Admin admin=repository.Login(username,password);
		return admin;
	}

}
