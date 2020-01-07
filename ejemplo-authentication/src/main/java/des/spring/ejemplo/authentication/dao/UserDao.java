package des.spring.ejemplo.authentication.dao;

import java.util.List;

import des.spring.ejemplo.authentication.entity.User;

public interface UserDao extends GenericDao<User> {

	public User save (User user);
	
	public List<User> findAll ();
	
	public User findByEmail (String email);
	
	public User findByUsername (String username);
	
	public User autenticate(String username, String password);
	
	
	
	
}
