package pe.gob.indecopi.repository;

import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.util.ClsResultDAO;

public interface ClsLstGeneralRepositoryI {
	public ClsResultDAO doLstGeneral();
	public ClsResultDAO doLstRecurso(ClsRecursoBean objRecurso);
}
