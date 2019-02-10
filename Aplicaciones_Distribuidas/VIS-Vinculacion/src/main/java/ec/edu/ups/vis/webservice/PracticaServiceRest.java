package ec.edu.ups.vis.webservice;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ec.edu.ups.vis.modelo.Alumno;
import ec.edu.ups.vis.modelo.PracticaAlumno;
import ec.edu.ups.vis.modelo.Practicas;
import ec.edu.ups.vis.modelo.Usuario;
import ec.edu.ups.vis.negocio.AlumnoBusiness;
import ec.edu.ups.vis.negocio.PracticasBusiness;
import ec.edu.ups.vis.negocio.UsuarioBusiness;

/**
 * Expone los metodos que deseemos del sistema para que sean consumidos como
 * servicios por los clientes externos al sistema a traves de una aplicacion
 * movil
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Path("/practicas")
public class PracticaServiceRest {

	@Inject
	private PracticasBusiness pB;
	@Inject
	private AlumnoBusiness aB;
	@Inject
	private UsuarioBusiness uB;

	/**
	 * Permite registrar una Practica en el sistema
	 * 
	 * @param p
	 * @return
	 */
	@POST
	@Path("/insertar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertar(Practicas p) {

		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			p.setAudFechaModificado(new Date());
			pB.registrar(p);
			data.put("codigo", "1");
			data.put("mensaje", "Ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {

			e.printStackTrace();
			data.put("codigo", "99");
			data.put("mensaje", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();
	}

	/**
	 * Retorna un json con los datos de una Practica segun el numero de cedula de un
	 * Alumno
	 * 
	 * @param cedula
	 * @return
	 */
	@GET
	@Path("/leerCedulaPractica")
	@Produces("application/json")
	public Practicas getPractica(@QueryParam("cedula") String cedula) {
		Practicas p = null;
		try {
			p = pB.leerCedula(cedula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Retorna un json con los datos de una Practica segun su id
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/leerIDPractica")
	@Produces("application/json")
	public Practicas getPracticaID(@QueryParam("id") int id) {
		Practicas p = null;
		try {
			p = pB.leer(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Retorna json con los datos de un Alumno segun su cedula
	 * 
	 * @param cedula
	 * @return
	 */
	@GET
	@Path("/leerAlumno")
	@Produces("application/json")
	public Alumno getAlumno(@QueryParam("cedula") String cedula) {
		Alumno a = null;
		try {
			a = aB.leer(cedula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	/**
	 * Actualiza la informacion de una Practica
	 * 
	 * @param p
	 * @return
	 */
	@PUT
	@Path("/actualizar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response actualizar(Practicas p) {

		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			p.setAudFechaModificado(new Date());
			pB.actualizar(p);
			data.put("codigo", "1");
			data.put("mensaje", "Ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {

			e.printStackTrace();
			data.put("codigo", "99");
			data.put("mensaje", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();
	}

	/**
	 * Elimina una practica segun su id
	 * 
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/eliminar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response eliminar(@QueryParam("id") int id) {

		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			pB.eliminar(id);
			data.put("codigo", "1");
			data.put("mensaje", "Ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {

			e.printStackTrace();
			data.put("codigo", "99");
			data.put("mensaje", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();
	}

	/**
	 * Retorna un json con la lista de todas las practicas registradas en el sistema
	 * 
	 * @return
	 */
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Practicas> getPracticas() {
		List<Practicas> practicas = pB.listarPracticas();
		for (Practicas p : practicas) {
			System.out.println(">>>>> " + p.getPprCodigo() + ", " + p.getPprAprobadoPor() + ", " + p.getPprAprobado()
					+ ", " + p.getPprEstadoResolucion() + ", " + p.getPprFechaInscripcion() + ", "
					+ p.getPprFechaAprobacion() + ", " + p.getPprFechaAcreditacion() + ", " + p.getPprNumeroResolucion()
					+ ", " + p.getPprNumeroActa() + ", " + p.getPprObservaciones() + ", " + p.getPprTotalHoras() + ", "
					+ p.getAluCodigo().getAluNombres() + ", " + p.getTppCodigo().getTppDescripcion());
		}
		return practicas;
	}

	/**
	 * Retorna un json con una lista resumen de todas las practicas registradas en
	 * el sistema
	 * 
	 * @return
	 */
	@GET
	@Path("/practicas")
	@Produces("application/json")
	public List<PracticaAlumno> getPracticasAlumno() {
		return pB.listarPracticaAlumno();
	}

	/**
	 * Retorna un json con la lista de todos los Alumnos registrados en el sistema
	 * 
	 * @return
	 */
	@GET
	@Path("/alumnos")
	@Produces("application/json")
	public List<Alumno> getAlumnoa() {
		return aB.listarAlumnos();
	}

	/**
	 * Retorna un json con los datos resumen de una Practica segun la cedula del
	 * Alumno
	 * 
	 * @param cedula
	 * @return
	 */
	@GET
	@Path("/leerCedula")
	@Produces("application/json")
	public PracticaAlumno getPracticaCedula(@QueryParam("cedula") String cedula) {
		PracticaAlumno p = null;
		try {
			p = pB.leer(cedula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * Retorna un json con los datos de un Usuario si el email y clave
	 * proporcionados corresponden con un Usuario registrado en el sistema
	 * 
	 * @param email
	 * @param clave
	 * @return
	 */
	@GET
	@Path("/login")
	@Produces("application/json")
	public Usuario login(@QueryParam("email") String email, @QueryParam("clave") String clave) {
		System.out.println(email + ", " + clave);
		return uB.login(email, clave);
	}
}
