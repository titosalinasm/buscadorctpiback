package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.ClsActividadBean;
import pe.gob.indecopi.bean.ClsDatoPatenteBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsPatenteResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3383494772179870804L;
	
	private List<ClsDatoPatenteBean> lstDatosPatentes;
	private List<ClsActividadBean> lstActividadRelacionada;
	
	public ClsPatenteResult() {
		this.setLstDatosPatentes(new ArrayList<ClsDatoPatenteBean>());
		this.setLstActividadRelacionada(new ArrayList<ClsActividadBean>());
	}

	public List<ClsDatoPatenteBean> getLstDatosPatentes() {
		return lstDatosPatentes;
	}

	public void setLstDatosPatentes(List<ClsDatoPatenteBean> lstDatosPatentes) {
		this.lstDatosPatentes = lstDatosPatentes;
	}

	public List<ClsActividadBean> getLstActividadRelacionada() {
		return lstActividadRelacionada;
	}

	public void setLstActividadRelacionada(List<ClsActividadBean> lstActividadRelacionada) {
		this.lstActividadRelacionada = lstActividadRelacionada;
	}
	

}
