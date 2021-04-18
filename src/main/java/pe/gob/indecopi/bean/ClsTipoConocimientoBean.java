package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsTipoConocimientoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7495601812313157762L;
	
	private Integer nuIdTipoConocimiento;
	private String vcIdTipoConocimiento;
	
	public Integer getNuIdTipoConocimiento() {
		return nuIdTipoConocimiento;
	}
	public void setNuIdTipoConocimiento(Integer nuIdTipoConocimiento) {
		this.nuIdTipoConocimiento = nuIdTipoConocimiento;
	}
	public String getVcIdTipoConocimiento() {
		return vcIdTipoConocimiento;
	}
	public void setVcIdTipoConocimiento(String vcIdTipoConocimiento) {
		this.vcIdTipoConocimiento = vcIdTipoConocimiento;
	}
	
	
	
	

}
