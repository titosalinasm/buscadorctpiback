package pe.gob.indecopi.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.indecopi.bean.ClsActividadBean;
import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.repository.ClsLstGeneralRepositoryI;
import pe.gob.indecopi.result.ClsLstGeneralResult;
import pe.gob.indecopi.result.ClsRecursoResult;
import pe.gob.indecopi.util.ClsResultDAO;

@Service
public class ClsLstGeneralService implements Serializable, ClsLstGeneralServiceI{

	/**
	 * 
	 */
	private static final long serialVersionUID = -440218789944078764L;
	
	private  Logger logger = Logger.getLogger(ClsLstGeneralService.class);

	@Autowired
	private ClsLstGeneralRepositoryI objlstGeneralRepo;
	
	@Autowired
	private ClsResultDAO objResultDAO;
	
	
	@Override
	public ClsRecursoResult doLstRecurso(ClsRecursoBean objRecurso) {
		logger.info("doLstRecurso()");
		ClsRecursoResult öbjResult=new ClsRecursoResult();
		
		try {

			objResultDAO=objlstGeneralRepo.doLstRecurso(objRecurso);
			
			öbjResult.setLsRecurso((List<ClsRecursoBean>)objResultDAO.get("POUT_CUR_RECURSO"));
			
			öbjResult.setNuError(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+""));
			öbjResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));
		
		}catch(Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		
		return öbjResult;
		
	}
	
	@Override
	public ClsLstGeneralResult doLstGeneral() {
		logger.info("ddoLstGeneral()");
		ClsLstGeneralResult öbjResult=new ClsLstGeneralResult();
		
		try {

			objResultDAO=objlstGeneralRepo.doLstGeneral();
			
			öbjResult.setLstActividad((List<ClsActividadBean>)objResultDAO.get("POUT_CUR_ACTIVIDAD"));
			
			öbjResult.setNuError(Integer.parseInt(objResultDAO.get("POUT_NU_ERROR")+""));
			öbjResult.setVcError((String)objResultDAO.get("POUT_VC_ERROR"));
		
		}catch(Exception e) {
			e.printStackTrace();
			logger.info(e);
		}
		
		return öbjResult;
		
	}
}
