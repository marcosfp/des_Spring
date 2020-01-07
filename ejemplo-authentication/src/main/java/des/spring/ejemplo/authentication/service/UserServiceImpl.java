package des.spring.ejemplo.authentication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import des.spring.ejemplo.authentication.dao.UserDao;
import des.spring.ejemplo.authentication.entity.User;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional
	public List<User> getUsers() {

		return userDao.findAll();
	}

	@Override
	@Transactional
	public User saveUser(User user) {

		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		return userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User getUser(long theId) {
		return userDao.find(theId);
	}

	@Override
	@Transactional
	public Boolean deleteUser(long theId) {

		boolean result = false;
		userDao.delete(theId);

		User user = userDao.find(theId);
		if (user != null && user.getIdUsuario() == theId) {
			result = true;
		}
		return result;
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}



}
