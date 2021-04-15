package pe.gob.indecopi.repository;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.support.oracle.SqlArrayValue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import oracle.jdbc.OracleTypes;
import pe.gob.indecopi.bean.ClsActividadBean;
import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.bean.ClsTodasColeccionesBean;
import pe.gob.indecopi.param.ClsConstantes;
import pe.gob.indecopi.util.ClsErrorResult;
import pe.gob.indecopi.util.ClsResultDAO;
import pe.gob.indecopi.util.ClsUtil;

@Repository
@Transactional
public class ClsBusquedasRepository  implements Serializable, ClsBusquedasRepositoryI  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1675781400459131847L;
	
	private  Logger logger = Logger.getLogger(ClsBusquedasRepository.class);
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
	public ClsResultDAO doLstTodasColeeciones(ClsFiltroTodosColeccionesBean objFiltro) {
		logger.info("doLstTodasColeeciones()");
		System.out.println("doLstTodasColeeciones()");
		try {
			
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_CTPI)
									.withCatalogName(ClsConstantes.PKG_BUSCADOR_CTPI)
									.withProcedureName(ClsConstantes.SP_LST_TODOS_COLECCIONES)
									.declareParameters(
									new SqlParameter("PIN_ARR_NU_ID_ACTIVIDAD",			 OracleTypes.ARRAY,  "NUM_ARRAY"), 	
									new  SqlOutParameter("POUT_CUR_TODOS_COL", OracleTypes.CURSOR ,
									new RowMapper<ClsTodasColeccionesBean>() {
										@Override
										public ClsTodasColeccionesBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsTodasColeccionesBean objRespuesta=new ClsTodasColeccionesBean();
											objRespuesta.setNuIdRegistro(rs.getInt("NU_REGISTRO"));
											objRespuesta.setNuIdTipoRegistro(rs.getInt("NU_TIPO_REGISTRO"));
											objRespuesta.setVcFuente(rs.getString("VC_FUENTE"));
											objRespuesta.setVcRecurso(rs.getString("VC_RECURSO"));
											objRespuesta.setVcActividad(rs.getString("VC_ACTIVIDAD"));
											objRespuesta.setVcColumna3(rs.getString("VC_COLUM3"));
											objRespuesta.setVcNumero(rs.getString("VC_NUMERO"));
											objRespuesta.setVcFecha(rs.getString("VC_FECHA"));
											objRespuesta.setVcResumen(rs.getString("VC_RESUMEN"));
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			
			int nuTamnio=objFiltro.getLstActividad().size();
			Integer[] nuIdActividad= new Integer[nuTamnio];
			for(int i=0; i<nuTamnio; i++) {
				ClsActividadBean objActividad=objFiltro.getLstActividad().get(i);
				nuIdActividad[i]=objActividad.getNuIdActividad();
			}
			
			System.out.println("objFiltro.getVcNombreCientifico(): "+objFiltro.getVcNombreCientifico());
	
			 Map<String, Object> inParamMap = new HashMap();
			 inParamMap.put("PIN_VC_NOM_CIENTIFICO", objFiltro.getVcNombreCientifico());
			 inParamMap.put("PIN_ARR_NU_ID_ACTIVIDAD"	, new SqlArrayValue<Integer>(nuIdActividad, "NUM_ARRAY"));
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_TODOS_COL", out.get("POUT_CUR_TODOS_COL"));
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
