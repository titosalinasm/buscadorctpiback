package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsFilterDetRegistroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1477553256885342057L;
	
	private Integer nuIdRegistro;
	private Integer nuIdTipo;
	
	public Integer getNuIdRegistro() {
		return nuIdRegistro;
	}
	public void setNuIdRegistro(Integer nuIdRegistro) {
		this.nuIdRegistro = nuIdRegistro;
	}
	public Integer getNuIdTipo() {
		return nuIdTipo;
	}
	public void setNuIdTipo(Integer nuIdTipo) {
		this.nuIdTipo = nuIdTipo;
	}

	
}
