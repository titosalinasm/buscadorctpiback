package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsBibliografiaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124202609743699896L;

	private Integer nuIdTipoFuente;
	private String vcAutor;
	private String vcNombreFuente;
	private String vcEditorial;
	private String vcFechaPublicacion;
	private String vcLugarPublicacion;
	private String vcPaginaCitada;
	
	
	public Integer getNuIdTipoFuente() {
		return nuIdTipoFuente;
	}
	public void setNuIdTipoFuente(Integer nuIdTipoFuente) {
		this.nuIdTipoFuente = nuIdTipoFuente;
	}
	public String getVcAutor() {
		return vcAutor;
	}
	public void setVcAutor(String vcAutor) {
		this.vcAutor = vcAutor;
	}
	public String getVcNombreFuente() {
		return vcNombreFuente;
	}
	public void setVcNombreFuente(String vcNombreFuente) {
		this.vcNombreFuente = vcNombreFuente;
	}
	public String getVcEditorial() {
		return vcEditorial;
	}
	public void setVcEditorial(String vcEditorial) {
		this.vcEditorial = vcEditorial;
	}
	public String getVcFechaPublicacion() {
		return vcFechaPublicacion;
	}
	public void setVcFechaPublicacion(String vcFechaPublicacion) {
		this.vcFechaPublicacion = vcFechaPublicacion;
	}
	public String getVcLugarPublicacion() {
		return vcLugarPublicacion;
	}
	public void setVcLugarPublicacion(String vcLugarPublicacion) {
		this.vcLugarPublicacion = vcLugarPublicacion;
	}
	public String getVcPaginaCitada() {
		return vcPaginaCitada;
	}
	public void setVcPaginaCitada(String vcPaginaCitada) {
		this.vcPaginaCitada = vcPaginaCitada;
	}
	
}
