package pe.gob.indecopi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClsFiltroTodosColeccionesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3163241769894708266L;
	
	public List<ClsActividadBean> lstActividad;
	private String vcNombreCientifico;
	
	public ClsFiltroTodosColeccionesBean() {
		this.setLstActividad(new ArrayList<ClsActividadBean>());
	}

	public List<ClsActividadBean> getLstActividad() {
		return lstActividad;
	}

	public void setLstActividad(List<ClsActividadBean> lstActividad) {
		this.lstActividad = lstActividad;
	}

	public String getVcNombreCientifico() {
		return vcNombreCientifico;
	}

	public void setVcNombreCientifico(String vcNombreCientifico) {
		this.vcNombreCientifico = vcNombreCientifico;
	}
	
	

}
