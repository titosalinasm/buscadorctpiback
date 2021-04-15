package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsDescripcionBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1033914463395329540L;
	
	private String vcNombresIngles;
	private String vcNombresEspanol;
	
	
	public String getVcNombresIngles() {
		return vcNombresIngles;
	}
	public void setVcNombresIngles(String vcNombresIngles) {
		this.vcNombresIngles = vcNombresIngles;
	}
	public String getVcNombresEspanol() {
		return vcNombresEspanol;
	}
	public void setVcNombresEspanol(String vcNombresEspanol) {
		this.vcNombresEspanol = vcNombresEspanol;
	}
	
	

}
