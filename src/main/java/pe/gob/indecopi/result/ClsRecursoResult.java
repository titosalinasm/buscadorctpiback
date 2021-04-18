package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.ClsPuebloBean;
import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.bean.ClsTipoBibliografiaBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsRecursoResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3448925104371614423L;
	
	private List<ClsRecursoBean> lsRecurso;

	
	public ClsRecursoResult() {
		this.setLsRecurso(new ArrayList<ClsRecursoBean>());
	}


	public List<ClsRecursoBean> getLsRecurso() {
		return lsRecurso;
	}

	public void setLsRecurso(List<ClsRecursoBean> lsRecurso) {
		this.lsRecurso = lsRecurso;
	}
	

}
