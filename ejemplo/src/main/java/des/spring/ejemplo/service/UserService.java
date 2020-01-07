package des.spring.ejemplo.service;

import java.util.List;

import des.spring.ejemplo.entity.User;


public interface UserService {

	public List<User> getUsers();

	public User saveUser(User user);

	public User getUser(long theId) ;

	public Boolean deleteUser(long theId);
}
