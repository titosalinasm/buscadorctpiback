package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsPuebloBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7495601812313157762L;
	
	private Integer nuIdPueblo;
	private String vcPueblo;
	
	
	public Integer getNuIdPueblo() {
		return nuIdPueblo;
	}
	public void setNuIdPueblo(Integer nuIdPueblo) {
		this.nuIdPueblo = nuIdPueblo;
	}
	public String getVcPueblo() {
		return vcPueblo;
	}
	public void setVcPueblo(String vcPueblo) {
		this.vcPueblo = vcPueblo;
	}
		

}
