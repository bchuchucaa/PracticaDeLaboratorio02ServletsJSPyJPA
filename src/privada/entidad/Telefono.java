package privada.entidad;

import java.io.Serializable;
import javax.persistence.*;

//@NamedQuery(name = "getByLevel", query = "SELECT u FROM User u WHERE u.level >= :level")
@NamedQuery(name = "recuperarTelefonos", query = "SELECT t FROM Telefono t WHERE t.usuario = :cedula")
@NamedQuery(name = "eliminarTelefono", query = "DELETE FROM Telefono t WHERE t.codigo = :codigo")
@NamedQuery(name = "buscarPorCedula", query = "SELECT t FROM Telefono t WHERE t.usuario = :cedula")
/**
 * Entity implementation class for Entity: Telefono
 *
 */
@Entity

public class Telefono implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String numero;
	private String tipo;
	private String operadora;
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	
	
	public Telefono() {
		
	}

	public Telefono(String numero, String tipo, String operadora, Usuario usuario) {
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
		this.usuario = usuario;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Telefono other = (Telefono) obj;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", usuario=" + usuario + "]";
	}
	
	
	
   
}
