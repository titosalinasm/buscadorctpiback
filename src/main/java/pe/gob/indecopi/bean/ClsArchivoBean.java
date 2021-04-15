package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsArchivoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7153064952578505508L;
	
	private Integer nuIdTipoDocumento;
	private String vcUrl;
	private String vcNombreOrigial;
	private Integer nuLong;
	
	
	public Integer getNuIdTipoDocumento() {
		return nuIdTipoDocumento;
	}
	public void setNuIdTipoDocumento(Integer nuIdTipoDocumento) {
		this.nuIdTipoDocumento = nuIdTipoDocumento;
	}
	public String getVcUrl() {
		return vcUrl;
	}
	public void setVcUrl(String vcUrl) {
		this.vcUrl = vcUrl;
	}
	public String getVcNombreOrigial() {
		return vcNombreOrigial;
	}
	public void setVcNombreOrigial(String vcNombreOrigial) {
		this.vcNombreOrigial = vcNombreOrigial;
	}
	public Integer getNuLong() {
		return nuLong;
	}
	public void setNuLong(Integer nuLong) {
		this.nuLong = nuLong;
	}
	
	

}
