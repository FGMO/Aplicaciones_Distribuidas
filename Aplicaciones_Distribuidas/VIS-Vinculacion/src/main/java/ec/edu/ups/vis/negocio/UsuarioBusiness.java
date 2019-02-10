package ec.edu.ups.vis.negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.vis.dao.UsuarioDAO;
import ec.edu.ups.vis.modelo.Usuario;

/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Usuario
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Stateless
public class UsuarioBusiness {

	@Inject
	private UsuarioDAO dao;

	/**
	 * Retorna un Usuario si el email y clave proporcionados corresponden a un
	 * Usuario registrado
	 * 
	 * @param email
	 * @param clave
	 * @return
	 */
	public Usuario login(String email, String clave) {
		return dao.login(email, clave);
	}

	/**
	 * Retorna un Usuario segun su codigo
	 * 
	 * @param codigo
	 * @return
	 */
	public Usuario leer(int codigo) {
		return dao.leer(codigo);
	}

}
