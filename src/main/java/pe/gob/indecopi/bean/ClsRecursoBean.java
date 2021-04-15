package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsRecursoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8172294820874246891L;
	
	private Integer nuIdRecurso;
	private String vcNombreCientifico;
	private String vcNombreComun;
	private String vcNombreFamilia;
	
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
	public String getVcNombreComun() {
		return vcNombreComun;
	}
	public void setVcNombreComun(String vcNombreComun) {
		this.vcNombreComun = vcNombreComun;
	}
	public String getVcNombreFamilia() {
		return vcNombreFamilia;
	}
	public void setVcNombreFamilia(String vcNombreFamilia) {
		this.vcNombreFamilia = vcNombreFamilia;
	}
	
	

}
