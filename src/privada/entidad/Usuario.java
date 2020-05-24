package privada.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.*;

//@NamedQuery(name = "getByLevel", query = "SELECT u FROM User u WHERE u.level >= :level")
@NamedQuery(name = "logIn", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
/**
 * Entity implementation class for Entity: Usuario
 *
 */


@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	@Column(unique= true, nullable=false)
	private String contrasena;
	@OneToMany(cascade= CascadeType.ALL,mappedBy = "usuario",orphanRemoval=true)
	private List<Telefono> telefonos;
	
	public Usuario() {
		telefonos = new ArrayList<Telefono>();
	}


	public Usuario(String cedula, String nombre, String apellido, String correo, String contrasena,
			List<Telefono> telefonos) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefonos = telefonos;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getContrasena() {
		return contrasena;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public List<Telefono> getTelefonos() {
		return telefonos;
	}


	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cedula == null) ? 0 : cedula.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cedula == null) {
			if (other.cedula != null)
				return false;
		} else if (!cedula.equals(other.cedula))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", contrasena=" + contrasena + ", telefonos=" + telefonos + "]";
	}

 
	
	
}
