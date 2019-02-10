package ec.edu.ups.vis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.vis.modelo.Alumno;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad Alumno
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Stateless
public class AlumnoDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param a
	 */
	public void insertar(Alumno a) {
		em.persist(a);
	}

	/**
	 * 
	 * @param a
	 */
	public void actualizar(Alumno a) {
		em.merge(a);
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
	public Alumno leer(int id) {
		Alumno aux = em.find(Alumno.class, id);
		return aux;
	}

	/**
	 * Retorna un Alumno segun su numero de cedula
	 * 
	 * @param cedula
	 * @return
	 */
	public Alumno leer(String cedula) {
		String jpql = "SELECT a FROM Alumno a WHERE a.aluCedula LIKE ?1";
		Query query = em.createQuery(jpql, Alumno.class);
		query.setParameter(1, cedula);
		Alumno aux = (Alumno) query.getSingleResult();
		return aux;
	}

	/**
	 * Retorna una lista de Alumnos
	 * 
	 * @return
	 */
	public List<Alumno> listarAlumnos() {
		String jpql = "SELECT a FROM Alumno a";
		Query query = em.createQuery(jpql, Alumno.class);
		return query.getResultList();
	}
}
