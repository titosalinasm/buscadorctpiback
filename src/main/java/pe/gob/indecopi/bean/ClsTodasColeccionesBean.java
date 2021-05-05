package pe.gob.indecopi.bean;

import java.io.Serializable;

public class ClsTodasColeccionesBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1542336939157483838L;
	
	//general
	private Integer nuIdRegistro;
	private Integer nuIdTipoRegistro;
	private String vcFuente;
	private String vcRecurso;
	private String vcActividad;
	private String vcColumna3;
	private String vcNumero;
	private String vcFecha;
	private String vcResumen;
	
	//patentes
	private String vcTituloOriginal;
	private String vcNroPublicacion;
	private String vcFechaPublicacion;
	
	//conocimiento
	private String vcAutor;
	private String vcLugarPublicacion;
	private String vcFechaPublicacionConocimiento;
	private Integer nuPaginas;
	private String vcRevista;
	private String vcTituloArticulo;
	private String vcTipoBibliografia;
	
	
	public String getVcTituloArticulo() {
		return vcTituloArticulo;
	}
	public void setVcTituloArticulo(String vcTituloArticulo) {
		this.vcTituloArticulo = vcTituloArticulo;
	}
	public String getVcTipoBibliografia() {
		return vcTipoBibliografia;
	}
	public void setVcTipoBibliografia(String vcTipoBibliografia) {
		this.vcTipoBibliografia = vcTipoBibliografia;
	}
	
	public String getVcAutor() {
		return vcAutor;
	}
	public void setVcAutor(String vcAutor) {
		this.vcAutor = vcAutor;
	}
	
	public String getVcLugarPublicacion() {
		return vcLugarPublicacion;
	}
	public void setVcLugarPublicacion(String vcLugarPublicacion) {
		this.vcLugarPublicacion = vcLugarPublicacion;
	}
	public String getVcFechaPublicacionConocimiento() {
		return vcFechaPublicacionConocimiento;
	}
	public void setVcFechaPublicacionConocimiento(String vcFechaPublicacionConocimiento) {
		this.vcFechaPublicacionConocimiento = vcFechaPublicacionConocimiento;
	}
	public Integer getNuPaginas() {
		return nuPaginas;
	}
	public void setNuPaginas(Integer nuPaginas) {
		this.nuPaginas = nuPaginas;
	}
	public String getVcRevista() {
		return vcRevista;
	}
	public void setVcRevista(String vcRevista) {
		this.vcRevista = vcRevista;
	}
	public String getVcTituloOriginal() {
		return vcTituloOriginal;
	}
	public void setVcTituloOriginal(String vcTituloOriginal) {
		this.vcTituloOriginal = vcTituloOriginal;
	}
	public String getVcNroPublicacion() {
		return vcNroPublicacion;
	}
	public void setVcNroPublicacion(String vcNroPublicacion) {
		this.vcNroPublicacion = vcNroPublicacion;
	}
	public String getVcFechaPublicacion() {
		return vcFechaPublicacion;
	}
	public void setVcFechaPublicacion(String vcFechaPublicacion) {
		this.vcFechaPublicacion = vcFechaPublicacion;
	}
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
