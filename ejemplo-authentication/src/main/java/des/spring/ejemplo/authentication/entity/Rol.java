package des.spring.ejemplo.authentication.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;

	@Column(name = "nombreRol")
	private String nombreRol;
	
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

	public long getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
	
	public Rol() {
		super();
	}

	public Rol(int idRol, String nombreRol) {
		super();
		this.idRol = idRol;
		this.nombreRol = nombreRol;
	}

}
