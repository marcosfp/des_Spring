package des.spring.ejemplo.authentication.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import des.spring.ejemplo.authentication.entity.Rol;
import des.spring.ejemplo.authentication.entity.User;

@Repository
@Component("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    @Autowired
    private RolRepository rolRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User save (User user) {
		
		Set<Rol> roles  =new HashSet<Rol>();
		
		Rol rol = rolRepository.getOne(1);
		roles.add(rol);
//		new Rol (1,"usuario")
        user.setRoles(roles);
        this.em.persist(user);
        
		return user;
	}
	
	@Override
	public User autenticate(String username, String password) {

		Query query = this.em
                .createQuery("select u FROM User u where u.username= :username");
        query.setParameter("username", username);
        User user = (User) query.getSingleResult();
        
        if (user == null ) {
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

	@Override
	public User findByEmail(String email) {
		Query query = this.em.createQuery("FROM User u where u.email = :email");
		query.setParameter("email", email);
		User user = (User) query.getSingleResult();
		
		if (user != null ) {
            return user;
        }
		  
		  return null;
	}

	@Override
	public User findByUsername(String nombreUsuario) {
		Query query = this.em.createQuery("FROM User u where u.nombreUsuario = :nombreUsuario");
		query.setParameter("nombreUsuario", nombreUsuario);
		User user = (User) query.getSingleResult();
		
		if (user != null ) {
            return user;
        }
		  
		  return null;
	}

}
