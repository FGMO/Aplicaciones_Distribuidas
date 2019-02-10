package ec.edu.ups.vis.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.vis.modelo.PracticaAlumno;
import ec.edu.ups.vis.modelo.Practicas;

/**
 * Etidad que permite realizar todas las operaciones de mantenimiento (C.R.U.D)
 * sobre la entidad Practicas
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Stateful
public class PracticasDAO {

	@Inject
	private EntityManager em;

	/**
	 * 
	 * @param p
	 */
	public void insertar(Practicas p) {
		em.persist(p);
	}

	/**
	 * 
	 * @param p
	 */
	public void actualizar(Practicas p) {
		em.merge(p);
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
	public Practicas leer(int id) {

		Practicas aux = em.find(Practicas.class, id);
		if (aux != null) {
			aux.getAluCodigo().getAluCodigo();
			aux.getTppCodigo().getTppCodigo();
		}
		return aux;
	}

	/**
	 * Retorna la practica de un Alumno segun su numero de cedula
	 * 
	 * @param cedula
	 * @return
	 */
	public Practicas leerCedula(String cedula) {
		String jpql = "SELECT p FROM Practicas p WHERE p.aluCodigo.aluCedula LIKE ?1";
		Query query = em.createQuery(jpql, Practicas.class);
		query.setParameter(1, cedula);
		Practicas aux = (Practicas) query.getSingleResult();
		aux.getAluCodigo().getAluCodigo();
		aux.getTppCodigo().getTppCodigo();
		return aux;
	}

	/**
	 * Retorna un resumen con los datos del TipoPractica, Practica y los datos del
	 * Alumno segun su numero de cedula
	 * 
	 * @param cedula
	 * @return
	 */
	public PracticaAlumno leer(String cedula) {
		String jpql = "SELECT p FROM Practicas p WHERE p.aluCodigo.aluCedula LIKE ?1";
		Query query = em.createQuery(jpql, Practicas.class);
		query.setParameter(1, cedula);
		Practicas aux = (Practicas) query.getSingleResult();
		PracticaAlumno pA = new PracticaAlumno();
		pA.setPprCodigo(aux.getPprCodigo());
		pA.setAluCodigo(aux.getAluCodigo().getAluCodigo());
		pA.setTppCodigo(aux.getTppCodigo().getTppCodigo());
		pA.setTppDescripcion(aux.getTppCodigo().getTppDescripcion());
		pA.setAluCedula(aux.getAluCodigo().getAluCedula());
		pA.setAluNombres(aux.getAluCodigo().getAluNombres());
		pA.setAluApellidos(aux.getAluCodigo().getAluApellidos());
		pA.setPprAprobadoPor(aux.getPprAprobadoPor());
		pA.setPprAprobado(aux.getPprAprobado());
		pA.setPprEstadoResolucion(aux.getPprEstadoResolucion());
		pA.setPprFechaInscripcion(aux.getPprFechaInscripcion());
		pA.setPprFechaAprobacion(aux.getPprFechaAprobacion());
		pA.setPprFechaAcreditacion(aux.getPprFechaAcreditacion());
		pA.setPprNumeroResolucion(aux.getPprNumeroResolucion());
		pA.setPprNumeroActa(aux.getPprNumeroActa());
		pA.setPprObservaciones(aux.getPprObservaciones());

		return pA;
	}

	/**
	 * Retorna una lista con todas las practicas almacenadas
	 * 
	 * @return
	 */
	public List<Practicas> listarPracticas() {
		String jpql = "SELECT p FROM Practicas p";
		Query query = em.createQuery(jpql, Practicas.class);
		List<Practicas> practicas = query.getResultList();
		for (Practicas p : practicas) {
			p.getTppCodigo().getTppCodigo();
			p.getAluCodigo().getAluCodigo();
		}
		return practicas;

	}

	/**
	 * Retorna una lista resumen con los datos del TipoPractica, Practica y los
	 * datos del Alumno
	 * 
	 * @return
	 */
	public List<PracticaAlumno> listarPracticasAlumno() {
		String jpql = "SELECT p FROM Practicas p";
		Query query = em.createQuery(jpql, Practicas.class);
		List<Practicas> lista = query.getResultList();
		List<PracticaAlumno> practicas = new ArrayList<>();
		for (Practicas p : lista) {
			PracticaAlumno pA = new PracticaAlumno();
			pA.setPprCodigo(p.getPprCodigo());
			pA.setAluCodigo(p.getAluCodigo().getAluCodigo());
			pA.setTppCodigo(p.getTppCodigo().getTppCodigo());
			pA.setTppDescripcion(p.getTppCodigo().getTppDescripcion());
			pA.setAluCedula(p.getAluCodigo().getAluCedula());
			pA.setAluNombres(p.getAluCodigo().getAluNombres());
			pA.setAluApellidos(p.getAluCodigo().getAluApellidos());
			pA.setPprAprobadoPor(p.getPprAprobadoPor());
			pA.setPprAprobado(p.getPprAprobado());
			pA.setPprEstadoResolucion(p.getPprEstadoResolucion());
			pA.setPprFechaInscripcion(p.getPprFechaInscripcion());
			pA.setPprFechaAprobacion(p.getPprFechaAprobacion());
			pA.setPprFechaAcreditacion(p.getPprFechaAcreditacion());
			pA.setPprNumeroResolucion(p.getPprNumeroResolucion());
			pA.setPprNumeroActa(p.getPprNumeroActa());
			pA.setPprObservaciones(p.getPprObservaciones());
			pA.setPprTotalHoras(p.getPprTotalHoras());
			practicas.add(pA);
		}
		return practicas;

	}

}
