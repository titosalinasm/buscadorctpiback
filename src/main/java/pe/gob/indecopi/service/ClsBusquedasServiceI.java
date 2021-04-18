package pe.gob.indecopi.service;

import pe.gob.indecopi.bean.ClsFilterDetRegistroBean;
import pe.gob.indecopi.bean.ClsFiltroConocimientosBean;
import pe.gob.indecopi.bean.ClsFiltroPatentesBean;
import pe.gob.indecopi.bean.ClsFiltroTodosAvanzadoBean;
import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.result.ClsTodasColeccionesResult;

public interface ClsBusquedasServiceI {
	public ClsTodasColeccionesResult doLstTodosColeccion(ClsFiltroTodosColeccionesBean objFiltro);
	public Object doDetalle(ClsFilterDetRegistroBean objFiltro);
	public ClsTodasColeccionesResult doLstTodosAvanzado(ClsFiltroTodosAvanzadoBean objFiltro);
	public ClsTodasColeccionesResult doLstPatentes(ClsFiltroPatentesBean objFiltro);
	public ClsTodasColeccionesResult doLstConocimientos(ClsFiltroConocimientosBean objFiltro);
}
