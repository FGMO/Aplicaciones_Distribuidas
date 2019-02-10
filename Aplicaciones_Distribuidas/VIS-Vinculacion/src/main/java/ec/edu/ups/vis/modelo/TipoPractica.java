package ec.edu.ups.vis.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Esta clase define la entidad TipoPractica con todos sus atributos, los cuales
 * serviran para mapear una tabla en la base de datos
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Entity
@Table(name = "VIS_TIPO_PRACTICA_PRE_PRO")
public class TipoPractica implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "TPP_CODIGO")
	private int tppCodigo;
	@Size(max = 100)
	@Column(name = "TPP_DESCRIPCION")
	private String tppDescripcion;
	@Size(max = 30)
	@Column(name = "TPP_MODIFICADO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private String tppModificado;
	@Column(name = "TPP_FECHA_MODIFICADO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date tppFechaModificado;
	@JsonIgnore
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "tpp_codigo")
	private List<Practicas> practicas;

	/**
	 * 
	 * @return
	 */
	public int getTppCodigo() {
		return tppCodigo;
	}

	/**
	 * 
	 * @param tppCodigo
	 */
	public void setTppCodigo(int tppCodigo) {
		this.tppCodigo = tppCodigo;
	}

	/**
	 * 
	 * @return
	 */
	public String getTppDescripcion() {
		return tppDescripcion;
	}

	/**
	 * 
	 * @param tppDescripcion
	 */
	public void setTppDescripcion(String tppDescripcion) {
		this.tppDescripcion = tppDescripcion;
	}

	/**
	 * 
	 * @return
	 */
	public String getTppModificado() {
		return tppModificado;
	}

	/**
	 * 
	 * @param tppModificado
	 */
	public void setTppModificado(String tppModificado) {
		this.tppModificado = tppModificado;
	}

	/**
	 * 
	 * @return
	 */
	public Date getTppFechaModificado() {
		return tppFechaModificado;
	}

	/**
	 * 
	 * @param tppFechaModificado
	 */
	public void setTppFechaModificado(Date tppFechaModificado) {
		this.tppFechaModificado = tppFechaModificado;
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

}
