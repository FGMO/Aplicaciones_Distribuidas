package ec.edu.ups.vis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.vis.modelo.TipoPractica;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad TipoPractica
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Stateless
public class TipoPracticaDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param tp
	 */
	public void insertar(TipoPractica tp) {
		em.persist(tp);
	}

	/**
	 * 
	 * @param tp
	 */
	public void actualizar(TipoPractica tp) {
		em.merge(tp);
	}

	/**
	 * 
	 * @param id
	 */
	public void eliminar(int id) {
		em.remove(leer(id));
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public TipoPractica leer(int id) {
		TipoPractica aux = em.find(TipoPractica.class, id);
		return aux;
	}

	/**
	 * Retorna una lista con los Tipos de Practicas almacenados
	 * 
	 * @return
	 */
	public List<TipoPractica> listarTipoPracticas() {
		String jpql = "SELECT tp FROM TipoPractica tp";
		Query query = em.createQuery(jpql, TipoPractica.class);
		return query.getResultList();
	}

}
