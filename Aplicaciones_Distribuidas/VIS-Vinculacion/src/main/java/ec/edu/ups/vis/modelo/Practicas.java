package ec.edu.ups.vis.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Esta clase define la entidad Practica con todos sus atributos, los cuales
 * serviran para mapear una tabla en la base de datos
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Entity
@Table(name = "VIS_PRACTICAS_PRE_PRO")
public class Practicas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "PPR_CODIGO")
	private int pprCodigo;
	@Size(max = 30)
	@Column(name = "PPR_APROBADO_POR")
	private String pprAprobadoPor;
	@Size(max = 1)
	@Column(name = "PPR_APROBADO")
	private String pprAprobado;
	@Size(max = 1)
	@Column(name = "PPR_ESTADO_RESOLUCION")
	private String pprEstadoResolucion;
	@Column(name = "PPR_FECHA_INSCRIPCION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date pprFechaInscripcion;
	@Column(name = "PPR_FECHA_APROBACION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date pprFechaAprobacion;
	@Column(name = "PPR_FECHA_ACREDITACION")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date pprFechaAcreditacion;
	@Size(max = 20)
	@Column(name = "PPR_NUMERO_RESOLUCION")
	private String pprNumeroResolucion;
	@Size(max = 20)
	@Column(name = "PPR_NUMERO_ACTA")
	private String pprNumeroActa;
	@Size(max = 500)
	@Column(name = "PPR_OBSERVACIONES")
	private String pprObservaciones;
	@Column(name = "PPR_TOTAL_HORAS")
	private BigDecimal pprTotalHoras;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "alu_codigo")
	private Alumno aluCodigo;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "tpp_codigo")
	private TipoPractica tppCodigo;
	private String audModificado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date audFechaModificado;
	private String audAccion;

	/**
	 * 
	 * @return
	 */
	public int getPprCodigo() {
		return pprCodigo;
	}

	/**
	 * 
	 * @param pprCodigo
	 */
	public void setPprCodigo(int pprCodigo) {
		this.pprCodigo = pprCodigo;
	}

	/**
	 * 
	 * @return
	 */
	public String getPprAprobadoPor() {
		return pprAprobadoPor;
	}

	/**
	 * 
	 * @param pprAprobadoPor
	 */
	public void setPprAprobadoPor(String pprAprobadoPor) {
		this.pprAprobadoPor = pprAprobadoPor;
	}

	/**
	 * 
	 * @return
	 */
	public String getPprAprobado() {
		return pprAprobado;
	}

	/**
	 * 
	 * @param pprAprobado
	 */
	public void setPprAprobado(String pprAprobado) {
		this.pprAprobado = pprAprobado;
	}

	/**
	 * 
	 * @return
	 */
	public String getPprEstadoResolucion() {
		return pprEstadoResolucion;
	}

	/**
	 * 
	 * @param pprEstadoResolucion
	 */
	public void setPprEstadoResolucion(String pprEstadoResolucion) {
		this.pprEstadoResolucion = pprEstadoResolucion;
	}

	/**
	 * 
	 * @return
	 */
	public Date getPprFechaInscripcion() {
		return pprFechaInscripcion;
	}

	/**
	 * 
	 * @param pprFechaInscripcion
	 */
	public void setPprFechaInscripcion(Date pprFechaInscripcion) {
		this.pprFechaInscripcion = pprFechaInscripcion;
	}

	/**
	 * 
	 * @return
	 */
	public Date getPprFechaAprobacion() {
		return pprFechaAprobacion;
	}

	/**
	 * 
	 * @param pprFechaAprobacion
	 */
	public void setPprFechaAprobacion(Date pprFechaAprobacion) {
		this.pprFechaAprobacion = pprFechaAprobacion;
	}

	/**
	 * 
	 * @return
	 */
	public Date getPprFechaAcreditacion() {
		return pprFechaAcreditacion;
	}

	/**
	 * 
	 * @param pprFechaAcreditacion
	 */
	public void setPprFechaAcreditacion(Date pprFechaAcreditacion) {
		this.pprFechaAcreditacion = pprFechaAcreditacion;
	}

	/**
	 * 
	 * @return
	 */
	public String getPprNumeroResolucion() {
		return pprNumeroResolucion;
	}

	/**
	 * 
	 * @param pprNumeroResolucion
	 */
	public void setPprNumeroResolucion(String pprNumeroResolucion) {
		this.pprNumeroResolucion = pprNumeroResolucion;
	}

	/**
	 * 
	 * @return
	 */
	public String getPprNumeroActa() {
		return pprNumeroActa;
	}

	/**
	 * 
	 * @param pprNumeroActa
	 */
	public void setPprNumeroActa(String pprNumeroActa) {
		this.pprNumeroActa = pprNumeroActa;
	}

	/**
	 * 
	 * @return
	 */
	public String getPprObservaciones() {
		return pprObservaciones;
	}

	/**
	 * 
	 * @param pprObservaciones
	 */
	public void setPprObservaciones(String pprObservaciones) {
		this.pprObservaciones = pprObservaciones;
	}

	/**
	 * 
	 * @return
	 */
	public BigDecimal getPprTotalHoras() {
		return pprTotalHoras;
	}

	/**
	 * 
	 * @param pprTotalHoras
	 */
	public void setPprTotalHoras(BigDecimal pprTotalHoras) {
		this.pprTotalHoras = pprTotalHoras;
	}

	/**
	 * 
	 * @return
	 */
	public Alumno getAluCodigo() {
		return aluCodigo;
	}

	/**
	 * 
	 * @param aluCodigo
	 */
	public void setAluCodigo(Alumno aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

	/**
	 * 
	 * @return
	 */
	public TipoPractica getTppCodigo() {
		return tppCodigo;
	}

	/**
	 * 
	 * @param tppCodigo
	 */
	public void setTppCodigo(TipoPractica tppCodigo) {
		this.tppCodigo = tppCodigo;
	}

	/**
	 * 
	 * @return
	 */
	public String getAudModificado() {
		return audModificado;
	}

	/**
	 * 
	 * @param audModificado
	 */
	public void setAudModificado(String audModificado) {
		this.audModificado = audModificado;
	}

	/**
	 * 
	 * @return
	 */
	public Date getAudFechaModificado() {
		return audFechaModificado;
	}

	/**
	 * 
	 * @param audFechaModificado
	 */
	public void setAudFechaModificado(Date audFechaModificado) {
		this.audFechaModificado = audFechaModificado;
	}

	/**
	 * 
	 * @return
	 */
	public String getAudAccion() {
		return audAccion;
	}

	/**
	 * 
	 * @param audAccion
	 */
	public void setAudAccion(String audAccion) {
		this.audAccion = audAccion;
	}

}
