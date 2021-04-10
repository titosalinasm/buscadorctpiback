package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.ClsActividadBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsLstGeneralResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769538073318456984L;
	
	public List<ClsActividadBean> lstActividad;
	
	public ClsLstGeneralResult() {
		this.setLstActividad(new ArrayList<ClsActividadBean>());
	}

	public List<ClsActividadBean> getLstActividad() {
		return lstActividad;
	}

	public void setLstActividad(List<ClsActividadBean> lstActividad) {
		this.lstActividad = lstActividad;
	}

	
	

}
