package des.spring.ejemplo.dao;

import java.util.List;

import des.spring.ejemplo.entity.User;

public interface UserDao extends GenericDao <User> {

	public List<User> findAll ();
	
	public User autenticate(String username, String password);
	
	
	
	
}
