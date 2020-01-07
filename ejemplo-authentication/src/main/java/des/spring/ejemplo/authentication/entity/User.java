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
@Table(name = "usuario")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;
	
	@Column(name = "nombreUsuario",unique = true)
	private String nombreUsuario;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
    @ManyToMany
    private Set<Rol> roles;


	public User() {
		super();
	}

	public User(String nombreUsuario, String email, String password) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    public Set<Rol> getRoles() {
        return roles;
    }
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

}
