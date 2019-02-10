package ec.edu.ups.vis.vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.vis.modelo.TipoPractica;
import ec.edu.ups.vis.negocio.TipoPracticaBusiness;

/**
 * Permite administrar la interaccion entre el Usuario y el sistema
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@ManagedBean
@ViewScoped
public class TipoPracticaBean {

	@Inject
	private TipoPracticaBusiness tpB;
	private TipoPractica tipo;
	private List<TipoPractica> tipos;
	private boolean editing;
	private int id;
	@Inject
	private FacesContext facesContext;

	@PostConstruct
	public void init() {
		tipo = new TipoPractica();
		editing = false;
		tipos = tpB.listarTipos();
	}

	/**
	 * Carga la iformacion de un Tipo de Practica segun su id
	 */
	public void loadData() {
		if (id == 0)
			return;
		try {
			tipo = tpB.leer(id);
			editing = true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	/**
	 * Permite registrar o editar un Tipo de Practica
	 * 
	 * @return
	 */
	public String registrar() {

		try {
			if (editing) {
				tipo.setTppFechaModificado(new Date());
				tipo.setTppModificado("Admin");
				tpB.actualizar(tipo);
			} else {
				tipo.setTppFechaModificado(new Date());
				tipo.setTppModificado("Admin");
				tpB.registrar(tipo);
			}
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Elimina un Tipo de Practica segun su id
	 * 
	 * @param id
	 * @return
	 */
	public String eliminar(int id) {
		try {
			tpB.eliminar(id);
			System.out.println("eliminado");
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Carga los datos de un Tipo de Practica en la ventana para su edicion
	 * 
	 * @param tp
	 * @return
	 */
	public String editar(TipoPractica tp) {
		editing = true;
		return "crear-tipo?faces-redirect=true&id=" + tp.getTppCodigo();
	}

	/**
	 * Regresa a la pagina anterior
	 * 
	 * @return
	 */
	public String regresar() {
		return "crear-tipo";
	}

	/**
	 * 
	 * @return
	 */
	public TipoPractica getTipo() {
		return tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(TipoPractica tipo) {
		this.tipo = tipo;
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
