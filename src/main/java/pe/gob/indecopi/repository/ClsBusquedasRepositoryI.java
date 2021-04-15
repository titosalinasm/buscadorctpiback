package pe.gob.indecopi.repository;

import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.util.ClsResultDAO;

public interface ClsBusquedasRepositoryI {
	public ClsResultDAO doLstTodasColeeciones(ClsFiltroTodosColeccionesBean objFiltro);
}
