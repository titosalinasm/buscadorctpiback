package pe.gob.indecopi.service;

import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.result.ClsTodasColeccionesResult;

public interface ClsBusquedasServiceI {
	public ClsTodasColeccionesResult doLstTodosColeccion(ClsFiltroTodosColeccionesBean objFiltro);
}
