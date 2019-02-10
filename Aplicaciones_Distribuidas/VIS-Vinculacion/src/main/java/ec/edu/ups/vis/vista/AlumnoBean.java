package ec.edu.ups.vis.vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.vis.modelo.Alumno;
import ec.edu.ups.vis.negocio.AlumnoBusiness;

/**
 * Permite administrar la interaccion entre el Usuario y el sistema
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@ManagedBean
@ViewScoped
public class AlumnoBean {

	@Inject
	private AlumnoBusiness aB;
	private Alumno alumno;
	private List<Alumno> alumnos;
	private boolean editing;
	private int id;
	private int codigo;
	@Inject
	private FacesContext facesContext;

	@PostConstruct
	public void init() {
		alumno = new Alumno();
		editing = false;
		alumnos = aB.listarAlumnos();
	}

	/**
	 * Carga la iformacion de un Alumno segun su id
	 */
	public void loadData() {
		if (id == 0)
			return;
		try {
			alumno = aB.leer(id);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	/**
	 * Permite registrar o editar un Alumno
	 * 
	 * @return
	 */
	public String registrar() {

		try {
			if (editing) {
				alumno.setAluFechaModificado(new Date());
				alumno.setAluModificado("Admin");
				System.out.println(">>>>>>> " + alumno.getAluCodigo());
				if (aB.validadorDeCedula(alumno.getAluCedula()))
					aB.actualizar(alumno);
			} else {
				alumno.setAluFechaModificado(new Date());
				alumno.setAluModificado("Admin");
				if (aB.validadorDeCedula(alumno.getAluCedula()))
					aB.registrar(alumno);
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Elimina un Alumno segun su id
	 * 
	 * @param id
	 * @return
	 */
	public String eliminar(int id) {
		try {
			aB.eliminar(id);
			System.out.println("eliminado");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Carga los datos de un Alumno en la ventana para su edicion
	 * 
	 * @param a
	 * @return
	 */
	public String editar(Alumno a) {
		editing = true;
		System.out.println(a.getAluCodigo());
		return "crear-alumno?faces-redirect=true&id=" + a.getAluCodigo();
	}

	/**
	 * Regresa a la pagina anterior
	 * 
	 * @return
	 */
	public String regresar() {
		return "crear-alumno";
	}

	/**
	 * 
	 * @return
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	 * 
	 * @param alumno
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	/**
	 * 
	 * @return
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	/**
	 * 
	 * @param alumnos
	 */
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEditing() {
		return editing;
	}

	/**
	 * 
	 * @param editing
	 */
	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

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

}
