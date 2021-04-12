package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsRecursoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8172294820874246891L;
	
	private Integer nuIdRecurso;
	private String vcNombreCientifico;
	
	
	public Integer getNuIdRecurso() {
		return nuIdRecurso;
	}
	public void setNuIdRecurso(Integer nuIdRecurso) {
		this.nuIdRecurso = nuIdRecurso;
	}
	public String getVcNombreCientifico() {
		return vcNombreCientifico;
	}
	public void setVcNombreCientifico(String vcNombreCientifico) {
		this.vcNombreCientifico = vcNombreCientifico;
	}
	
	

}
