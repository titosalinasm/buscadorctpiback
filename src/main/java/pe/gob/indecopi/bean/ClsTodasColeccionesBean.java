package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsTodasColeccionesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1542336939157483838L;
	
	private Integer nuIdRegistro;
	private Integer nuIdTipoRegistro;
	private String vcFuente;
	private String vcRecurso;
	private String vcActividad;
	private String vcColumna3;
	private String vcNumero;
	private String vcFecha;
	private String vcResumen;
	
	public Integer getNuIdRegistro() {
		return nuIdRegistro;
	}
	public void setNuIdRegistro(Integer nuIdRegistro) {
		this.nuIdRegistro = nuIdRegistro;
	}
	public Integer getNuIdTipoRegistro() {
		return nuIdTipoRegistro;
	}
	public void setNuIdTipoRegistro(Integer nuIdTipoRegistro) {
		this.nuIdTipoRegistro = nuIdTipoRegistro;
	}
	public String getVcFuente() {
		return vcFuente;
	}
	public void setVcFuente(String vcFuente) {
		this.vcFuente = vcFuente;
	}
	public String getVcRecurso() {
		return vcRecurso;
	}
	public void setVcRecurso(String vcRecurso) {
		this.vcRecurso = vcRecurso;
	}
	public String getVcActividad() {
		return vcActividad;
	}
	public void setVcActividad(String vcActividad) {
		this.vcActividad = vcActividad;
	}
	public String getVcColumna3() {
		return vcColumna3;
	}
	public void setVcColumna3(String vcColumna3) {
		this.vcColumna3 = vcColumna3;
	}
	public String getVcNumero() {
		return vcNumero;
	}
	public void setVcNumero(String vcNumero) {
		this.vcNumero = vcNumero;
	}
	public String getVcFecha() {
		return vcFecha;
	}
	public void setVcFecha(String vcFecha) {
		this.vcFecha = vcFecha;
	}
	public String getVcResumen() {
		return vcResumen;
	}
	public void setVcResumen(String vcResumen) {
		this.vcResumen = vcResumen;
	}
	
	
}
