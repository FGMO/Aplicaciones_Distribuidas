package ec.edu.ups.vis.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.vis.dao.AlumnoDAO;
import ec.edu.ups.vis.modelo.Alumno;

/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * Alumno
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Stateless
public class AlumnoBusiness {

	@Inject
	private AlumnoDAO dao;

	/**
	 * Permite registrar un Alumno en el sistema
	 * 
	 * @param a
	 */
	public void registrar(Alumno a) {
		Alumno aux = dao.leer(a.getAluCodigo());
		if (aux != null)
			System.out.println("Alumno ya registrado");
		else
			dao.insertar(a);
	}

	/**
	 * Retorna un Alumno segun su id
	 * 
	 * @param id
	 * @return
	 */
	public Alumno leer(int id) {
		Alumno alumno = dao.leer(id);
		if (alumno == null)
			System.out.println("Alumno no registrado");
		return alumno;
	}

	/**
	 * Retorna un Alumno segun su cedula
	 * 
	 * @param cedula
	 * @return
	 */
	public Alumno leer(String cedula) {
		Alumno alumno = dao.leer(cedula);
		if (alumno == null)
			System.out.println("Alumno no registrado");
		return alumno;
	}

	/**
	 * Permite actualizar la informacion de un Alumno
	 * 
	 * @param a
	 */
	public void actualizar(Alumno a) {
		Alumno aux = dao.leer(a.getAluCodigo());
		if (aux == null)
			System.out.println("Alumno no registrado");
		else
			dao.actualizar(a);
	}

	/**
	 * Elimina un Alumno segun su id
	 * 
	 * @param id
	 */
	public void eliminar(int id) {
		Alumno aux = dao.leer(id);
		if (aux == null)
			System.out.println("Alumno no registrado");
		else
			dao.eliminar(id);
	}

	/**
	 * Retorna una lista de Alumnos
	 * 
	 * @return
	 */
	public List<Alumno> listarAlumnos() {
		return dao.listarAlumnos();
	}

	/**
	 * Verifica que la cedula ingresada sea Ecuatoriana
	 * 
	 * @param cedula
	 * @return
	 */
	public boolean validadorDeCedula(String cedula) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) {
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {
					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println(err.getStackTrace());
			cedulaCorrecta = false;
		}
		return cedulaCorrecta;
	}

}
