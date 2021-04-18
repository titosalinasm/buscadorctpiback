package pe.gob.indecopi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClsFiltroPatentesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3163241769894708266L;
	
	public List<ClsActividadBean> lstActividad;
	private String vcNombreCientifico;
	private String vcResumen;
	private String vcTituloPatente;
	private String vcNumeroPublicacion;
	private String vcReinvindicacion;
	private String vcCip;
	
	
	
	public String getVcResumen() {
		return vcResumen;
	}

	public void setVcResumen(String vcResumen) {
		this.vcResumen = vcResumen;
	}

	public String getVcTituloPatente() {
		return vcTituloPatente;
	}

	public void setVcTituloPatente(String vcTituloPatente) {
		this.vcTituloPatente = vcTituloPatente;
	}

	public String getVcNumeroPublicacion() {
		return vcNumeroPublicacion;
	}

	public void setVcNumeroPublicacion(String vcNumeroPublicacion) {
		this.vcNumeroPublicacion = vcNumeroPublicacion;
	}

	public String getVcReinvindicacion() {
		return vcReinvindicacion;
	}

	public void setVcReinvindicacion(String vcReinvindicacion) {
		this.vcReinvindicacion = vcReinvindicacion;
	}

	public String getVcCip() {
		return vcCip;
	}

	public void setVcCip(String vcCip) {
		this.vcCip = vcCip;
	}

	public ClsFiltroPatentesBean() {
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
