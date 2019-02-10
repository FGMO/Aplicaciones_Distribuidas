package ec.edu.ups.vis.modelo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Esta clase define la entidad Practica con todos sus atributos, los cuales
 * serviran para mostrarnos un resumen con los datos del Alumno, Practica y
 * TipoPractica
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
public class PracticaAlumno {

	private int pprCodigo;
	private int aluCodigo;
	private int tppCodigo;
	private String tppDescripcion;
	private String aluCedula;
	private String aluNombres;
	private String aluApellidos;
	private String pprAprobadoPor;
	private String pprAprobado;
	private String pprEstadoResolucion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date pprFechaInscripcion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date pprFechaAprobacion;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date pprFechaAcreditacion;
	private String pprNumeroResolucion;
	private String pprNumeroActa;
	private String pprObservaciones;
	private BigDecimal pprTotalHoras;

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
	public int getAluCodigo() {
		return aluCodigo;
	}

	/**
	 * 
	 * @param aluCodigo
	 */
	public void setAluCodigo(int aluCodigo) {
		this.aluCodigo = aluCodigo;
	}

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
	public String getAluCedula() {
		return aluCedula;
	}

	/**
	 * 
	 * @param aluCedula
	 */
	public void setAluCedula(String aluCedula) {
		this.aluCedula = aluCedula;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluNombres() {
		return aluNombres;
	}

	/**
	 * 
	 * @param aluNombres
	 */
	public void setAluNombres(String aluNombres) {
		this.aluNombres = aluNombres;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluApellidos() {
		return aluApellidos;
	}

	/**
	 * 
	 * @param aluApellidos
	 */
	public void setAluApellidos(String aluApellidos) {
		this.aluApellidos = aluApellidos;
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

}
