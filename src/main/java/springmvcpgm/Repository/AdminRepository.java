package springmvcpgm.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import springmvcpgm.POJO.Admin;
@Repository
public class AdminRepository {
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

	public static Admin addAdmin(String username, String password) {
		openConnection();
		transaction.begin();
		Admin admin= new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		manager.persist(admin);
		transaction.commit();
		closeConnection();
		return admin;
	}
	public Admin Login(String username, String password) {
		openConnection();
		transaction.begin();
		JPQL="from Admin "+"where username='"+username+"' and password='"+password+"'";
		query=manager.createQuery(JPQL);
		List<Admin> admin = query.getResultList();
		for(Admin admin2:admin) {
			transaction.commit();
			closeConnection();
			return admin2;
		}
		return null;
	}

}
