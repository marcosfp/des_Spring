package des.spring.ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import des.spring.ejemplo.dao.UserDao;
import des.spring.ejemplo.entity.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<User> getUsers() {

		return userDao.findAll();
	}

	@Override
	@Transactional
	public User saveUser(User user) {

		return userDao.update(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User getUser(long theId) {
		return userDao.find(theId);
	}

	@Override
	@Transactional
	public Boolean deleteUser(long theId) {

		boolean result=false;
		userDao.delete(theId);
		
		User user = userDao.find(theId);
		if (user !=null && user.getIdUsuario() ==theId) {
			result=true;
		}
		return result;
	}

}
