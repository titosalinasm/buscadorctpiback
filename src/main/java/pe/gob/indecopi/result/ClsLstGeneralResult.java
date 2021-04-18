package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.ClsActividadBean;
import pe.gob.indecopi.bean.ClsPuebloBean;
import pe.gob.indecopi.bean.ClsTipoBibliografiaBean;
import pe.gob.indecopi.bean.ClsTipoConocimientoBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsLstGeneralResult extends ClsErrorResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6769538073318456984L;
	
	public List<ClsActividadBean> lstActividad;
	private List<ClsPuebloBean> lstPueblo;
	private List<ClsTipoBibliografiaBean> lstTipoBibliografia;
	private List<ClsTipoConocimientoBean> lstTipoConocimiento;
	
	public ClsLstGeneralResult() {
		this.setLstActividad(new ArrayList<ClsActividadBean>());
		this.setLstPueblo(new ArrayList<ClsPuebloBean>());
		this.setLstTipoBibliografia(new ArrayList<ClsTipoBibliografiaBean>());
		this.setLstTipoConocimiento(new ArrayList<ClsTipoConocimientoBean>());
	}

	public List<ClsTipoConocimientoBean> getLstTipoConocimiento() {
		return lstTipoConocimiento;
	}

	public void setLstTipoConocimiento(List<ClsTipoConocimientoBean> lstTipoConocimiento) {
		this.lstTipoConocimiento = lstTipoConocimiento;
	}

	public List<ClsPuebloBean> getLstPueblo() {
		return lstPueblo;
	}

	public void setLstPueblo(List<ClsPuebloBean> lstPueblo) {
		this.lstPueblo = lstPueblo;
	}

	public List<ClsTipoBibliografiaBean> getLstTipoBibliografia() {
		return lstTipoBibliografia;
	}

	public void setLstTipoBibliografia(List<ClsTipoBibliografiaBean> lstTipoBibliografia) {
		this.lstTipoBibliografia = lstTipoBibliografia;
	}
	
	public List<ClsActividadBean> getLstActividad() {
		return lstActividad;
	}

	public void setLstActividad(List<ClsActividadBean> lstActividad) {
		this.lstActividad = lstActividad;
	}

	
	

}
