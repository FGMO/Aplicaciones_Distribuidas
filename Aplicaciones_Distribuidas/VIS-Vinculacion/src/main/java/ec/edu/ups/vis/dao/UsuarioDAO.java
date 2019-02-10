package ec.edu.ups.vis.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.vis.modelo.Usuario;

/**
 * Permite obtener la informacion del Usuario desde la base de datos para
 * autenticarlo en el sistema
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Stateless
public class UsuarioDAO {

	@Inject
	private EntityManager em;

	/**
	 * Retorna un Usuario siempre que el email y la clave proporcionados
	 * correspondan a un usuario registrado en sistema
	 * 
	 * @param email
	 * @param clave
	 * @return
	 */
	public Usuario login(String email, String clave) {
		String jpql = "SELECT u FROM Usuario u WHERE u.email LIKE ?1 AND u.clave LIKE ?2";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter(1, email);
		query.setParameter(2, clave);
		Usuario c = (Usuario) query.getSingleResult();
		return c;
	}

	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Usuario leer(int codigo) {
		return em.find(Usuario.class, codigo);
	}

}
