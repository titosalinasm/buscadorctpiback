package pe.gob.indecopi.service;

import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.result.ClsLstGeneralResult;
import pe.gob.indecopi.result.ClsRecursoResult;

public interface ClsLstGeneralServiceI {
	public ClsLstGeneralResult doLstGeneral();
	public ClsRecursoResult doLstRecurso(ClsRecursoBean objRecurso);
}
