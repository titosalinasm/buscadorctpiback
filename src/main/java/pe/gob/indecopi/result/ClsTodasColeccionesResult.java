package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.ClsTodasColeccionesBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsTodasColeccionesResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1536194232675851267L;
	
	private List<ClsTodasColeccionesBean> lstTodasColecciones;
	
	public ClsTodasColeccionesResult() {
		this.setLstTodasColecciones(new ArrayList<ClsTodasColeccionesBean>());
	}

	public List<ClsTodasColeccionesBean> getLstTodasColecciones() {
		return lstTodasColecciones;
	}

	public void setLstTodasColecciones(List<ClsTodasColeccionesBean> lstTodasColecciones) {
		this.lstTodasColecciones = lstTodasColecciones;
	}
	
	

}
