package des.spring.ejemplo.authentication.dao;


import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import des.spring.ejemplo.authentication.entity.Rol;
import des.spring.ejemplo.authentication.entity.User;

@Repository
@Component("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Integer>{
	

	
}

