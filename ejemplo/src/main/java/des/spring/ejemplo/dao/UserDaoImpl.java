package des.spring.ejemplo.dao;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import des.spring.ejemplo.entity.User;

@Repository
@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@Override
	public User autenticate(String username, String password) {

		Query query = this.em
                .createQuery("select u FROM User u where u.username= :username");
        query.setParameter("username", username);
        User user = (User) query.getSingleResult();
        
        if (user != null ) {
            return null;
        }
        if (user.getPassword() == password) {
        	return user;
        }
		return null;
	}

	@Override
	public List<User> findAll() {
		Query query = this.em.createQuery("FROM User u");
        List<User> lUser =  query.getResultList();
        
        if (lUser == null ) {
            return null;
        }
		return lUser;
	}

}
