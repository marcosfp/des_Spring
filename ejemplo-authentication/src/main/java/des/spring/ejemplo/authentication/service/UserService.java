package des.spring.ejemplo.authentication.service;

import java.util.List;

import des.spring.ejemplo.authentication.entity.User;


public interface UserService {

	public List<User> getUsers();

	public User saveUser(User user);
	
	public User findByEmail(String email);
	
	public User findByUsername(String username);

	public User getUser(long theId) ;

	public Boolean deleteUser(long theId);
}
