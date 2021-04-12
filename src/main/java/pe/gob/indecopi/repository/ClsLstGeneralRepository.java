package pe.gob.indecopi.repository;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import oracle.jdbc.OracleTypes;
import pe.gob.indecopi.bean.ClsActividadBean;
import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.param.ClsConstantes;
import pe.gob.indecopi.util.ClsErrorResult;
import pe.gob.indecopi.util.ClsResultDAO;
import pe.gob.indecopi.util.ClsUtil;

@Repository
@Transactional
public class ClsLstGeneralRepository extends ClsErrorResult implements Serializable, ClsLstGeneralRepositoryI  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1675781400459131847L;
	
	private  Logger logger = Logger.getLogger(ClsLstGeneralRepository.class);
	private SimpleJdbcCall simpleJdbcCall;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//DataSouser incio multiple
	  @Autowired
	  private DataSource dataSource;
	  
	  @PostConstruct
	  private void init()
	  {
	    this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	  }
	//DataSouser fin multiple
	
	@Autowired
	private ClsResultDAO objResultDAO;
	
	@Override
	public ClsResultDAO doLstGeneral() {
		logger.info("doLstGeneral()");
		System.out.println("doLstGeneral()");
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_CTPI)
									.withCatalogName(ClsConstantes.PKG_BUSCADOR_CTPI)
									.withProcedureName(ClsConstantes.SP_LST_GENERAL)
									.declareParameters(
									new  SqlOutParameter("POUT_CUR_ACTIVIDAD", OracleTypes.CURSOR ,
									new RowMapper<ClsActividadBean>() {

										@Override
										public ClsActividadBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsActividadBean objRespuesta=new ClsActividadBean();
											objRespuesta.setNuIdActividad(rs.getInt("NU_ID_ACTIVIDAD"));
											objRespuesta.setVcActividad(rs.getString("VC_NOMBRE"));
											
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute();
			
			//response
			objResultDAO.put("POUT_CUR_ACTIVIDAD", out.get("POUT_CUR_ACTIVIDAD"));
			objResultDAO.put("POUT_NU_ERROR", out.get("POUT_NU_ERROR"));
			objResultDAO.put("POUT_VC_ERROR", out.get("POUT_VC_ERROR"));
											    		
			
		}catch(Exception e) {
			System.out.println(e);
			logger.info(e);
			e.printStackTrace();
		}
		
		return objResultDAO;
	}
	
	@Override
	public ClsResultDAO doLstRecurso(ClsRecursoBean objRecurso) {
		logger.info("doLstRecurso()");
		System.out.println("doLstRecurso()");
		try {
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_CTPI)
									.withCatalogName(ClsConstantes.PKG_BUSCADOR_CTPI)
									.withProcedureName(ClsConstantes.SP_LST_NOMBRE_CIENTIFICO)
									.declareParameters(	
									new  SqlOutParameter("POUT_CUR_RECURSO", OracleTypes.CURSOR ,
									new RowMapper<ClsRecursoBean>() {

										@Override
										public ClsRecursoBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRecursoBean objRespuesta=new ClsRecursoBean();
											objRespuesta.setNuIdRecurso(rs.getInt("NU_ID_RECURSOBIO"));
											objRespuesta.setVcNombreCientifico(rs.getString("VC_NOMBRE_CIENTIFICO"));
											//System.out.println("rs.getString(\"VC_NOMBRE_CIENTIFICO\")"+rs.getString("VC_NOMBRE_CIENTIFICO"));
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			//System.out.println("objRecurso.getVcNombreCientifico(): "+objRecurso.getVcNombreCientifico());
			//param
			SqlParameterSource inParamMap = new MapSqlParameterSource()
											    .addValue("PIN_VC_PALABRA", objRecurso.getVcNombreCientifico());
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_RECURSO", out.get("POUT_CUR_RECURSO"));
			objResultDAO.put("POUT_NU_ERROR", out.get("POUT_NU_ERROR"));
			objResultDAO.put("POUT_VC_ERROR", out.get("POUT_VC_ERROR"));
											    		
			
		}catch(Exception e) {
			System.out.println(e);
			logger.info(e);
			e.printStackTrace();
		}
		
		return objResultDAO;
	}
	
	
	
}
