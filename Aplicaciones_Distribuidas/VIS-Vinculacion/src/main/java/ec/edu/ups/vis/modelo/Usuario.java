package ec.edu.ups.vis.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Esta clase define la entidad Usuario con todos sus atributos, los cuales
 * serviran para mapear una tabla en la base de datos
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private String email;
	private String clave;

	/**
	 * 
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * 
	 * @param clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
}
