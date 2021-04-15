package pe.gob.indecopi.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.bean.ClsTodasColeccionesBean;
import pe.gob.indecopi.repository.ClsBusquedasRepositoryI;
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

}
