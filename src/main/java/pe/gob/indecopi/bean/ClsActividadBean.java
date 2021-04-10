package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsActividadBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7495601812313157762L;
	
	private Integer nuIdActividad;
	private String vcActividad;
	
	
	public Integer getNuIdActividad() {
		return nuIdActividad;
	}
	public void setNuIdActividad(Integer nuIdActividad) {
		this.nuIdActividad = nuIdActividad;
	}
	public String getVcActividad() {
		return vcActividad;
	}
	public void setVcActividad(String vcActividad) {
		this.vcActividad = vcActividad;
	}
	
	

}
