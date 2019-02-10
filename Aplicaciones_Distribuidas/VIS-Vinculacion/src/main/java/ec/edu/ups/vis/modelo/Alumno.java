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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Esta clase define la entidad Alumno con todos sus atributos, los cuales
 * serviran para mapear una tabla en la base de datos
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Entity
@Table(name = "VIS_ALUMNO")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@NotNull
	@Column(name = "alu_codigo")
	private int aluCodigo;
	@Size(max = 50)
	@Pattern(regexp = "[^0-9]*", message = "Solo debe ingresar letras")
	@Column(name = "alu_apellidos")
	private String aluApellidos;
	@Size(max = 50)
	@Column(name = "alu_nombres")
	private String aluNombres;
	@Size(max = 10)
	@Column(name = "alu_cedula")
	private String aluCedula;
	@Size(max = 1)
	@Column(name = "alu_genero")
	private String aluGenero;
	@Column(name = "alu_fecha_nacimiento")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date aluFechaNacimiento;
	@Size(max = 100)
	@Column(name = "alu_direccion_calle_sec")
	private String aluDireccionCalleSec;
	@Size(max = 100)
	@Column(name = "alu_direccion_dato_adi")
	private String aluDireccionDatoAdi;
	@Size(max = 250)
	@Email
	@Column(name = "alu_email")
	private String aluEmail;
	@Size(max = 100)
	@Column(name = "alu_barrio")
	private String aluBarrio;
	@Size(max = 100)
	@Column(name = "alu_nacionalidad")
	private String aluNacionalidad;
	@Size(max = 100)
	@Column(name = "alu_telefono")
	private String aluTelefono;
	@Size(max = 50)
	@Column(name = "alu_modificado")
	private String aluModificado;
	@Column(name = "alu_fecha_modificado")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date aluFechaModificado;
	@JsonIgnore
	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "alu_codigo")
	private List<Practicas> practicas;

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
	public String getAluGenero() {
		return aluGenero;
	}

	/**
	 * 
	 * @param aluGenero
	 */
	public void setAluGenero(String aluGenero) {
		this.aluGenero = aluGenero;
	}

	/**
	 * 
	 * @return
	 */
	public Date getAluFechaNacimiento() {
		return aluFechaNacimiento;
	}

	/**
	 * 
	 * @param aluFechaNacimiento
	 */
	public void setAluFechaNacimiento(Date aluFechaNacimiento) {
		this.aluFechaNacimiento = aluFechaNacimiento;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluDireccionCalleSec() {
		return aluDireccionCalleSec;
	}

	/**
	 * 
	 * @param aluDireccionCalleSec
	 */
	public void setAluDireccionCalleSec(String aluDireccionCalleSec) {
		this.aluDireccionCalleSec = aluDireccionCalleSec;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluDireccionDatoAdi() {
		return aluDireccionDatoAdi;
	}

	/**
	 * 
	 * @param aluDireccionDatoAdi
	 */
	public void setAluDireccionDatoAdi(String aluDireccionDatoAdi) {
		this.aluDireccionDatoAdi = aluDireccionDatoAdi;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluEmail() {
		return aluEmail;
	}

	/**
	 * 
	 * @param aluEmail
	 */
	public void setAluEmail(String aluEmail) {
		this.aluEmail = aluEmail;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluBarrio() {
		return aluBarrio;
	}

	/**
	 * 
	 * @param aluBarrio
	 */
	public void setAluBarrio(String aluBarrio) {
		this.aluBarrio = aluBarrio;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluNacionalidad() {
		return aluNacionalidad;
	}

	/**
	 * 
	 * @param aluNacionaidad
	 */
	public void setAluNacionalidad(String aluNacionaidad) {
		this.aluNacionalidad = aluNacionaidad;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluTelefono() {
		return aluTelefono;
	}

	/**
	 * 
	 * @param aluTelefono
	 */
	public void setAluTelefono(String aluTelefono) {
		this.aluTelefono = aluTelefono;
	}

	/**
	 * 
	 * @return
	 */
	public String getAluModificado() {
		return aluModificado;
	}

	/**
	 * 
	 * @param aluModificado
	 */
	public void setAluModificado(String aluModificado) {
		this.aluModificado = aluModificado;
	}

	/**
	 * 
	 * @return
	 */
	public Date getAluFechaModificado() {
		return aluFechaModificado;
	}

	/**
	 * 
	 * @param aluFechaModificado
	 */
	public void setAluFechaModificado(Date aluFechaModificado) {
		this.aluFechaModificado = aluFechaModificado;
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
