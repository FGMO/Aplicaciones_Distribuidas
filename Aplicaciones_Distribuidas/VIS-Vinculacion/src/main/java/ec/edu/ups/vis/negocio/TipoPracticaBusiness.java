package ec.edu.ups.vis.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.vis.dao.TipoPracticaDAO;
import ec.edu.ups.vis.modelo.TipoPractica;

/**
 * Establece las reglas de negocio y las validaciones necesarias para la entidad
 * TipoPractica
 * 
 * @author Frank Gabriel Montalvo Ochoa
 *
 */
@Stateless
public class TipoPracticaBusiness {

	@Inject
	private TipoPracticaDAO dao;

	/**
	 * Permite registrar un Tipo de Practica en el sistema
	 * 
	 * @param tp
	 */
	public void registrar(TipoPractica tp) {
		TipoPractica aux = dao.leer(tp.getTppCodigo());
		if (aux != null)
			System.out.println(" ya registrado");
		else
			dao.insertar(tp);
	}

	/**
	 * Retorna un Tipo Practica segun su id
	 * 
	 * @param id
	 * @return
	 */
	public TipoPractica leer(int id) {
		TipoPractica tipo = dao.leer(id);
		if (tipo == null)
			System.out.println(" no registrado");
		return tipo;
	}

	/**
	 * Permite actualizar la informacion de un Tipo de Practica
	 * 
	 * @param tp
	 */
	public void actualizar(TipoPractica tp) {
		TipoPractica aux = dao.leer(tp.getTppCodigo());
		if (aux == null)
			System.out.println(" no registrado");
		else
			dao.actualizar(tp);
	}

	/**
	 * Elimina un Tipo Practica segun su id
	 * 
	 * @param id
	 */
	public void eliminar(int id) {
		TipoPractica aux = dao.leer(id);
		if (aux == null)
			System.out.println(" no registrado");
		else
			dao.eliminar(id);
	}

	/**
	 * Retorna una lista de Tipos de Practicas
	 * 
	 * @return
	 */
	public List<TipoPractica> listarTipos() {
		return dao.listarTipoPracticas();
	}

}
