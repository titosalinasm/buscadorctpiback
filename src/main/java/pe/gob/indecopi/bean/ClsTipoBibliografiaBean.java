package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsTipoBibliografiaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7495601812313157762L;
	
	private Integer nuIdTipoBibliografia;
	private String vcTipoBibliografia;
	
	public Integer getNuIdTipoBibliografia() {
		return nuIdTipoBibliografia;
	}
	public void setNuIdTipoBibliografia(Integer nuIdTipoBibliografia) {
		this.nuIdTipoBibliografia = nuIdTipoBibliografia;
	}
	public String getVcTipoBibliografia() {
		return vcTipoBibliografia;
	}
	public void setVcTipoBibliografia(String vcTipoBibliografia) {
		this.vcTipoBibliografia = vcTipoBibliografia;
	}
	
	
	
	

}
