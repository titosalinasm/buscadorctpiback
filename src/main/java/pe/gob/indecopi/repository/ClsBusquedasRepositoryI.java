package pe.gob.indecopi.repository;

import pe.gob.indecopi.bean.ClsFilterDetRegistroBean;
import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.util.ClsResultDAO;

public interface ClsBusquedasRepositoryI {
	public ClsResultDAO doLstTodasColeeciones(ClsFiltroTodosColeccionesBean objFiltro);
	
	public ClsResultDAO doLstDetConocimiento(ClsFilterDetRegistroBean objFiltro);
	public ClsResultDAO doLstDetPatente(ClsFilterDetRegistroBean objFiltro);
}
