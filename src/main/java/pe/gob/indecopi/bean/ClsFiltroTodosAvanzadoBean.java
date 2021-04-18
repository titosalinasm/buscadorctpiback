package pe.gob.indecopi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ClsFiltroTodosAvanzadoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3163241769894708266L;
	
	public List<ClsActividadBean> lstActividad;
	private String vcNombreCientifico;
	
	public List<ClsValorBean> lstValor;
	public List<ClsOperadorBean> lstOperador;
	
	public ClsFiltroTodosAvanzadoBean() {
		this.setLstActividad(new ArrayList<ClsActividadBean>());
		this.setLstOperador(new ArrayList<ClsOperadorBean>());
		this.setLstValor(new ArrayList<ClsValorBean>());
	}

	
	public List<ClsValorBean> getLstValor() {
		return lstValor;
	}


	public void setLstValor(List<ClsValorBean> lstValor) {
		this.lstValor = lstValor;
	}


	public List<ClsOperadorBean> getLstOperador() {
		return lstOperador;
	}


	public void setLstOperador(List<ClsOperadorBean> lstOperador) {
		this.lstOperador = lstOperador;
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
