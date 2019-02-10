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
import ec.edu.ups.vis.modelo.Practicas;
import ec.edu.ups.vis.modelo.TipoPractica;
import ec.edu.ups.vis.negocio.AlumnoBusiness;
import ec.edu.ups.vis.negocio.PracticasBusiness;
import ec.edu.ups.vis.negocio.TipoPracticaBusiness;

/**
 * Permite administrar la interaccion entre el Usuario y el sistema
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@ManagedBean
@ViewScoped
public class PracticasBean {

	@Inject
	private PracticasBusiness pB;
	@Inject
	private AlumnoBusiness aB;
	@Inject
	private TipoPracticaBusiness tB;
	private Practicas practica;
	private List<Practicas> practicas;
	private List<Alumno> alumnos;
	private List<TipoPractica> tipos;
	private boolean editing;
	private int codigoAlumno;
	private int codigoTipo;
	private int id;
	@Inject
	private FacesContext facesContext;

	@PostConstruct
	public void init() {
		practica = new Practicas();
		editing = false;
		practicas = pB.listarPracticas();
		alumnos = aB.listarAlumnos();
		tipos = tB.listarTipos();
	}

	/**
	 * Carga la iformacion de una Practica segun su id
	 */
	public void loadData() {
		if (id == 0)
			return;
		try {
			practica = pB.leer(id);
			codigoAlumno = practica.getAluCodigo().getAluCodigo();
			codigoTipo = practica.getTppCodigo().getTppCodigo();
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	/**
	 * Permite registrar o editar una Practica
	 * 
	 * @return
	 */
	public String registrar() {

		try {
			System.out.println(">>>>>" + practica.getAluCodigo());
			if (editing) {
				Alumno a = new Alumno();
				TipoPractica tp = new TipoPractica();
				a.setAluCodigo(codigoAlumno);
				tp.setTppCodigo(codigoTipo);
				practica.setAluCodigo(a);
				practica.setTppCodigo(tp);
				practica.setAudModificado("Admin");
				practica.setAudAccion("Actualizo");
				practica.setAudFechaModificado(new Date());
				System.out.println(">>>>>>>>>>>>>>>>1");
				pB.actualizar(practica);
			} else {
				Alumno a = new Alumno();
				TipoPractica tp = new TipoPractica();
				a.setAluCodigo(codigoAlumno);
				tp.setTppCodigo(codigoTipo);
				practica.setAluCodigo(a);
				practica.setTppCodigo(tp);
				practica.setAudModificado("Admin");
				practica.setAudAccion("Registro");
				practica.setAudFechaModificado(new Date());
				pB.registrar(practica);
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Elimina una Practica segun su id
	 * 
	 * @param id
	 * @return
	 */
	public String eliminar(int id) {
		try {
			pB.eliminar(id);
			System.out.println("eliminado");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Carga los datos de una Practica en la ventana para su edicion
	 * 
	 * @param p
	 * @return
	 */
	public String editar(Practicas p) {
		editing = true;
		return "crear-practica?faces-redirect=true&id=" + p.getPprCodigo();
	}

	/**
	 * Regresa a la pagina anterior
	 * 
	 * @return
	 */
	public String regresar() {
		return "crear-practica";
	}

	/**
	 * 
	 * @return
	 */
	public Practicas getPractica() {
		return practica;
	}

	/**
	 * 
	 * @param practica
	 */
	public void setPractica(Practicas practica) {
		this.practica = practica;
	}

	/**
	 * 
	 * @return
	 */
	public List<Practicas> getPracticas() {
		return practicas;
	}

	/**
	 * 
	 * @param practicas
	 */
	public void setPracticas(List<Practicas> practicas) {
		this.practicas = practicas;
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
	public List<TipoPractica> getTipos() {
		return tipos;
	}

	/**
	 * 
	 * @param tipos
	 */
	public void setTipos(List<TipoPractica> tipos) {
		this.tipos = tipos;
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
	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	/**
	 * 
	 * @param codigoAlumno
	 */
	public void setCodigoAlumno(int codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}

	/**
	 * 
	 * @return
	 */
	public int getCodigoTipo() {
		return codigoTipo;
	}

	/**
	 * 
	 * @param codigoTipo
	 */
	public void setCodigoTipo(int codigoTipo) {
		this.codigoTipo = codigoTipo;
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

}
