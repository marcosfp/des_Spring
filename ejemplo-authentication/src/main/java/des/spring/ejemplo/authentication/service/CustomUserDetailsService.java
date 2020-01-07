package des.spring.ejemplo.authentication.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import des.spring.ejemplo.authentication.dao.UserDao;
import des.spring.ejemplo.authentication.entity.Rol;
import des.spring.ejemplo.authentication.entity.User;

@Transactional
@Service
public class CustomUserDetailsService implements  UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = userDao.findByEmail(email);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Rol rol : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		}

		return new org.springframework.security.core.userdetails.User(user.getNombreUsuario(), user.getPassword(),
				grantedAuthorities);
	}
}
