package ec.edu.ups.vis.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.vis.dao.PracticasDAO;
import ec.edu.ups.vis.modelo.PracticaAlumno;
import ec.edu.ups.vis.modelo.Practicas;

/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Practicas
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Stateless
public class PracticasBusiness {

	@Inject
	private PracticasDAO dao;

	/**
	 * Permite registrar una Practica en el sistema
	 * 
	 * @param p
	 */
	public void registrar(Practicas p) {
		System.out.println("_>_>_> " + p.getPprCodigo());
		Practicas aux = dao.leer(p.getPprCodigo());
		if (aux != null)
			System.out.println("Practica ya registrada");
		else
			dao.insertar(p);
	}

	/**
	 * Retorna una Practica segun su id
	 * 
	 * @param id
	 * @return
	 */
	public Practicas leer(int id) {
		Practicas practicas = dao.leer(id);
		if (practicas == null)
			System.out.println("Practica no registrada");
		return practicas;
	}

	/**
	 * Retorna un resumen de una Practica segun la cedula del Alumno
	 * 
	 * @param cedula
	 * @return
	 */
	public PracticaAlumno leer(String cedula) {
		PracticaAlumno practica = dao.leer(cedula);
		if (practica == null)
			System.out.println("Practica no registrada");
		return practica;
	}

	/**
	 * Retorna una Practica segun la cedula del Alumno
	 * 
	 * @param cedula
	 * @return
	 */
	public Practicas leerCedula(String cedula) {
		Practicas practicas = dao.leerCedula(cedula);
		if (practicas == null)
			System.out.println("Practica no registrada");
		return practicas;
	}

	/**
	 * Permite actualizar la informacion de una Practica
	 * 
	 * @param p
	 */
	public void actualizar(Practicas p) {
		Practicas aux = dao.leer(p.getPprCodigo());
		if (aux == null)
			System.out.println("Practica no registrada");
		else
			dao.actualizar(p);
	}

	/**
	 * Elimina una Practica segun su id
	 * 
	 * @param id
	 */
	public void eliminar(int id) {
		Practicas aux = dao.leer(id);
		if (aux == null)
			System.out.println("Practica no registrada");
		else
			dao.eliminar(id);
	}

	/**
	 * Retorna una lista de Practicas
	 * 
	 * @return
	 */
	public List<Practicas> listarPracticas() {
		return dao.listarPracticas();
	}

	/**
	 * Retorna una lista resumen de Practicas
	 * 
	 * @return
	 */
	public List<PracticaAlumno> listarPracticaAlumno() {
		return dao.listarPracticasAlumno();
	}

}
