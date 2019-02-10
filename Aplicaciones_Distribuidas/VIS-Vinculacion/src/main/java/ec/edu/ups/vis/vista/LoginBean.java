package ec.edu.ups.vis.vista;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import ec.edu.ups.vis.modelo.Usuario;
import ec.edu.ups.vis.negocio.UsuarioBusiness;
import ec.edu.ups.vis.util.SessionUtils;

/**
 * Permite al Usuario autenticarse en el sistema
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

	@Inject
	private UsuarioBusiness uB;

	private String email = "admin@ups.edu.ec";
	private String clave = "admin123";
	private Usuario usuario;

	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}

	/**
	 * Verifica que el Usuario que desea ingresar este registrado en el sistema y
	 * crea una sesion para el mismo
	 * 
	 * @return
	 */
	public String login() {
		usuario = uB.login(email, clave);
		if (usuario != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", usuario);
			return "crear-alumno";
		} else {
			return null;
		}
	}

	/**
	 * Termina la sesion del Usuario
	 * 
	 * @return
	 */
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index.xhtml";
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * 
	 * @param clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * 
	 * @return
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
