package pe.gob.indecopi.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.gob.indecopi.bean.ClsActividadBean;
import pe.gob.indecopi.bean.ClsArchivoBean;
import pe.gob.indecopi.bean.ClsBibliografiaBean;
import pe.gob.indecopi.bean.ClsDescripcionBean;
import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.util.ClsErrorResult;

public class ClsConocimientoResult extends ClsErrorResult  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2531229667591759268L;
	
	private List<ClsRecursoBean> lstRecursoRelacionado;
	private List<ClsDescripcionBean> lstDescripcion;
	private List<ClsActividadBean> lstActividadRelacionada;
	private List<ClsBibliografiaBean> lstBibliografia;
	private List<ClsArchivoBean> lstArchivo;
	
	public ClsConocimientoResult() {
		this.setLstRecursoRelacionado(new ArrayList<ClsRecursoBean>());
		this.setLstDescripcion(new ArrayList<ClsDescripcionBean>());
		this.setLstActividadRelacionada(new ArrayList<ClsActividadBean>());
		this.setLstBibliografia(new ArrayList<ClsBibliografiaBean>());
		this.setLstArchivo(new ArrayList<ClsArchivoBean>());
		
	}

	public List<ClsRecursoBean> getLstRecursoRelacionado() {
		return lstRecursoRelacionado;
	}

	public void setLstRecursoRelacionado(List<ClsRecursoBean> lstRecursoRelacionado) {
		this.lstRecursoRelacionado = lstRecursoRelacionado;
	}

	public List<ClsDescripcionBean> getLstDescripcion() {
		return lstDescripcion;
	}

	public void setLstDescripcion(List<ClsDescripcionBean> lstDescripcion) {
		this.lstDescripcion = lstDescripcion;
	}

	public List<ClsActividadBean> getLstActividadRelacionada() {
		return lstActividadRelacionada;
	}

	public void setLstActividadRelacionada(List<ClsActividadBean> lstActividadRelacionada) {
		this.lstActividadRelacionada = lstActividadRelacionada;
	}

	public List<ClsBibliografiaBean> getLstBibliografia() {
		return lstBibliografia;
	}

	public void setLstBibliografia(List<ClsBibliografiaBean> lstBibliografia) {
		this.lstBibliografia = lstBibliografia;
	}

	public List<ClsArchivoBean> getLstArchivo() {
		return lstArchivo;
	}

	public void setLstArchivo(List<ClsArchivoBean> lstArchivo) {
		this.lstArchivo = lstArchivo;
	}
	
	
	

}
