package pe.gob.indecopi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClsFiltroConocimientosBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3163241769894708266L;
	
	public List<ClsActividadBean> lstActividad;
	private String vcNombreCientifico;
	private Integer nuIdTipoConocimiento;
	private String vcDescripcion;
	private String vcNombreComun;
	private Integer nuIdTipoBibliografia;
	private Integer nuIdPueblo;
	
	public Integer getNuIdTipoConocimiento() {
		return nuIdTipoConocimiento;
	}

	public void setNuIdTipoConocimiento(Integer nuIdTipoConocimiento) {
		this.nuIdTipoConocimiento = nuIdTipoConocimiento;
	}

	public String getVcDescripcion() {
		return vcDescripcion;
	}

	public void setVcDescripcion(String vcDescripcion) {
		this.vcDescripcion = vcDescripcion;
	}

	public String getVcNombreComun() {
		return vcNombreComun;
	}

	public void setVcNombreComun(String vcNombreComun) {
		this.vcNombreComun = vcNombreComun;
	}

	public Integer getNuIdTipoBibliografia() {
		return nuIdTipoBibliografia;
	}

	public void setNuIdTipoBibliografia(Integer nuIdTipoBibliografia) {
		this.nuIdTipoBibliografia = nuIdTipoBibliografia;
	}

	public Integer getNuIdPueblo() {
		return nuIdPueblo;
	}

	public void setNuIdPueblo(Integer nuIdPueblo) {
		this.nuIdPueblo = nuIdPueblo;
	}

	public ClsFiltroConocimientosBean() {
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
