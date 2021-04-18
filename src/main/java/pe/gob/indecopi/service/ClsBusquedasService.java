package pe.gob.indecopi.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.indecopi.bean.ClsActividadBean;
import pe.gob.indecopi.bean.ClsArchivoBean;
import pe.gob.indecopi.bean.ClsBibliografiaBean;
import pe.gob.indecopi.bean.ClsDatoPatenteBean;
import pe.gob.indecopi.bean.ClsDescripcionBean;
import pe.gob.indecopi.bean.ClsFilterDetRegistroBean;
import pe.gob.indecopi.bean.ClsFiltroConocimientosBean;
import pe.gob.indecopi.bean.ClsFiltroPatentesBean;
import pe.gob.indecopi.bean.ClsFiltroTodosAvanzadoBean;
import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.bean.ClsTodasColeccionesBean;
import pe.gob.indecopi.repository.ClsBusquedasRepositoryI;
import pe.gob.indecopi.result.ClsConocimientoResult;
import pe.gob.indecopi.result.ClsPatenteResult;
import pe.gob.indecopi.result.ClsTodasColeccionesResult;
import pe.gob.indecopi.util.ClsResultDAO;


@Service
public class ClsBusquedasService implements Serializable, ClsBusquedasServiceI{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5515053318726937949L;
	
	private  Logger logger = Logger.getLogger(ClsBusquedasService.class);
	
	@Autowired
	private ClsBusquedasRepositoryI objConn;
	
	@Autowired
	private ClsResultDAO objResultDAO;
	
	
	@Override
	public ClsTodasColeccionesResult doLstTodosColeccion(ClsFiltroTodosColeccionesBean objFiltro) {
		logger.info("doLstTodosColeccion()");
		ClsTodasColeccionesResult öbjResult=new ClsTodasColeccionesResult();
		
		try {
			System.out.println("objFiltro."+objFiltro.getVcNombreCientifico());
			objResultDAO=objConn.doLstTodasColeeciones(objFiltro);

			öbjResult.setLstTodasColecciones((List<ClsTodasColeccionesBean>)objResultDAO.get("POUT_CUR_TODOS_COL"));
			
			öbjResult.setNuError(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+""));
			öbjResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));
	
		}catch(Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		
		return öbjResult;
		
	}
	
	@Override
	public Object doDetalle(ClsFilterDetRegistroBean objFiltro) {
		logger.info("doDetalle()");
		ClsConocimientoResult öbjResult1=new ClsConocimientoResult();
		ClsPatenteResult öbjResult2=new ClsPatenteResult();
		
		try {
			System.out.println("getNuIdTipo: "+objFiltro.getNuIdTipo());

			switch (objFiltro.getNuIdTipo()) {
					case 1:
						objResultDAO=objConn.doLstDetPatente(objFiltro);
						öbjResult2.setLstDatosPatentes((List<ClsDatoPatenteBean>)objResultDAO.get("POUT_CUR_DATO_PATENTE"));
						öbjResult2.setLstActividadRelacionada((List<ClsActividadBean>)objResultDAO.get("POUT_CUR_ACTIVIDAD"));
						
						öbjResult2.setNuError(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+""));
						öbjResult2.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));
						break;
					case 2:
						objResultDAO=objConn.doLstDetConocimiento(objFiltro);
						öbjResult1.setLstRecursoRelacionado((List<ClsRecursoBean>)objResultDAO.get("POUT_CUR_RECURSO"));
						öbjResult1.setLstDescripcion((List<ClsDescripcionBean>)objResultDAO.get("POUT_CUR_DESCRIPCION"));
						öbjResult1.setLstActividadRelacionada((List<ClsActividadBean>)objResultDAO.get("POUT_CUR_ACTIVIDADES"));
						öbjResult1.setLstBibliografia((List<ClsBibliografiaBean>)objResultDAO.get("POUT_CUR_BIBLIOGRAFIA"));
						öbjResult1.setLstArchivo((List<ClsArchivoBean>)objResultDAO.get("POUT_CUR_ARCHIVOS"));
						
						öbjResult1.setNuError(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+""));
						öbjResult1.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));
						break;
					default:
						break;
			}
			
	
		}catch(Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		
		if(objFiltro.getNuIdTipo()==1) {
			return öbjResult2;
		}else {
			return öbjResult1;
		}
	}

	@Override
	public ClsTodasColeccionesResult doLstTodosAvanzado(ClsFiltroTodosAvanzadoBean objFiltro) {
		logger.info("doLstTodosAvanzado()");
		ClsTodasColeccionesResult öbjResult=new ClsTodasColeccionesResult();
		
		try {
			System.out.println("objFiltro."+objFiltro.getVcNombreCientifico());
			objResultDAO=objConn.doLstTodasAvanzado(objFiltro);

			öbjResult.setLstTodasColecciones((List<ClsTodasColeccionesBean>)objResultDAO.get("POUT_CUR_TODOS_AVAN"));
			
			öbjResult.setNuError(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+""));
			öbjResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));
	
		}catch(Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		
		return öbjResult;
		
	}
	
	@Override
	public ClsTodasColeccionesResult doLstPatentes(ClsFiltroPatentesBean objFiltro) {
		logger.info("doLstPatentes()");
		ClsTodasColeccionesResult öbjResult=new ClsTodasColeccionesResult();
		
		try {
			System.out.println("objFiltro."+objFiltro.getVcNombreCientifico());
			objResultDAO=objConn.doLstPatentes(objFiltro);

			öbjResult.setLstTodasColecciones((List<ClsTodasColeccionesBean>)objResultDAO.get("POUT_CUR_PATENTE"));
			
			öbjResult.setNuError(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+""));
			öbjResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));
	
		}catch(Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		
		return öbjResult;
		
	}
	
	@Override
	public ClsTodasColeccionesResult doLstConocimientos(ClsFiltroConocimientosBean objFiltro) {
		logger.info("doLstConocimientos()");
		ClsTodasColeccionesResult öbjResult=new ClsTodasColeccionesResult();
		
		try {
			System.out.println("objFiltro."+objFiltro.getVcNombreCientifico());
			objResultDAO=objConn.doLstConocimientos(objFiltro);

			öbjResult.setLstTodasColecciones((List<ClsTodasColeccionesBean>)objResultDAO.get("POUT_CUR_CONOCIMIENTO"));
			
			öbjResult.setNuError(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+""));
			öbjResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));
	
		}catch(Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		
		return öbjResult;
		
	}
}
