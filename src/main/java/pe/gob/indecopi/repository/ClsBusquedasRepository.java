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
import pe.gob.indecopi.bean.ClsArchivoBean;
import pe.gob.indecopi.bean.ClsBibliografiaBean;
import pe.gob.indecopi.bean.ClsDatoPatenteBean;
import pe.gob.indecopi.bean.ClsDescripcionBean;
import pe.gob.indecopi.bean.ClsFilterDetRegistroBean;
import pe.gob.indecopi.bean.ClsFiltroConocimientosBean;
import pe.gob.indecopi.bean.ClsFiltroPatentesBean;
import pe.gob.indecopi.bean.ClsFiltroTodosAvanzadoBean;
import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.bean.ClsOperadorBean;
import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.bean.ClsTodasColeccionesBean;
import pe.gob.indecopi.bean.ClsValorBean;
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
	
	@Override
	public ClsResultDAO doLstDetConocimiento(ClsFilterDetRegistroBean objFiltro) {
		logger.info("doLstDetConocimiento()");
		System.out.println("doLstDetConocimiento()");
		try {
			
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_CTPI)
									.withCatalogName(ClsConstantes.PKG_BUSCADOR_CTPI)
									.withProcedureName(ClsConstantes.SP_LST_DET_CONOCIMIENTO)
									.declareParameters(
									new  SqlOutParameter("POUT_CUR_RECURSO", OracleTypes.CURSOR ,
									new RowMapper<ClsRecursoBean>() {
										@Override
										public ClsRecursoBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsRecursoBean objRespuesta=new ClsRecursoBean();
											objRespuesta.setVcNombreComun(rs.getString("VC_NOMBRES_COMUNES"));
											objRespuesta.setVcNombreCientifico(rs.getString("VC_NOMBRE_CIENTIFICO"));
											objRespuesta.setVcNombreFamilia(rs.getString("VC_NOMBRE_FAMILIA"));
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_CUR_DESCRIPCION", OracleTypes.CURSOR ,
											new RowMapper<ClsDescripcionBean>() {
												@Override
												public ClsDescripcionBean mapRow(ResultSet rs, int rowNum)
														throws SQLException {
													ClsDescripcionBean objRespuesta=new ClsDescripcionBean();
													objRespuesta.setVcNombresEspanol(rs.getString("VC_NOM_ESPANOL"));
													objRespuesta.setVcNombresIngles(rs.getString("VC_NOM_INGLES"));
													return objRespuesta;
												}
											}),
									new  SqlOutParameter("POUT_CUR_ACTIVIDADES", OracleTypes.CURSOR ,
											new RowMapper<ClsActividadBean>() {
												@Override
												public ClsActividadBean mapRow(ResultSet rs, int rowNum)
														throws SQLException {
													ClsActividadBean objRespuesta=new ClsActividadBean();
													objRespuesta.setNuIdActividad(rs.getInt("NU_ID_ACTIVIDAD"));
													objRespuesta.setVcActividad(rs.getString("VC_ACTIVIDAD"));
													return objRespuesta;
												}
											}),
									new  SqlOutParameter("POUT_CUR_BIBLIOGRAFIA", OracleTypes.CURSOR ,
											new RowMapper<ClsBibliografiaBean>() {
												@Override
												public ClsBibliografiaBean mapRow(ResultSet rs, int rowNum)
														throws SQLException {
													ClsBibliografiaBean objRespuesta=new ClsBibliografiaBean();
													objRespuesta.setNuIdTipoFuente(rs.getInt("NU_TIPO_FUENTE"));
													objRespuesta.setVcAutor(rs.getString("VC_AUTOR"));
													objRespuesta.setVcNombreFuente(rs.getString("VC_NOMBRE_FUENTE"));
													objRespuesta.setVcEditorial(rs.getString("VC_EDITORIAL"));
													objRespuesta.setVcFechaPublicacion(rs.getString("VC_FECHA_PUB"));
													objRespuesta.setVcLugarPublicacion(rs.getString("VC_LUGAR_PUB"));
													objRespuesta.setVcPaginaCitada(rs.getString("VC_PAGINA_CITADA"));
													return objRespuesta;
												}
											}),
									new  SqlOutParameter("POUT_CUR_ARCHIVOS", OracleTypes.CURSOR ,
											new RowMapper<ClsArchivoBean>() {
												@Override
												public ClsArchivoBean mapRow(ResultSet rs, int rowNum)
														throws SQLException {
													ClsArchivoBean objRespuesta=new ClsArchivoBean();
													objRespuesta.setNuIdTipoDocumento(rs.getInt("NU_ID_TIPO_DOCUMENTO"));
													objRespuesta.setVcUrl(rs.getString("VC_URL"));
													objRespuesta.setVcNombreOrigial(rs.getString("VC_NOMBRE_ORIGINAL"));
													objRespuesta.setNuLong(rs.getInt("NU_LONGITUD"));
													return objRespuesta;
												}
											}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			
			 Map<String, Object> inParamMap = new HashMap();
			 inParamMap.put("PIN_NU_ID_REGISTRO", objFiltro.getNuIdRegistro());
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_RECURSO", out.get("POUT_CUR_RECURSO"));
			objResultDAO.put("POUT_CUR_DESCRIPCION", out.get("POUT_CUR_DESCRIPCION"));
			objResultDAO.put("POUT_CUR_ACTIVIDADES", out.get("POUT_CUR_ACTIVIDADES"));
			objResultDAO.put("POUT_CUR_BIBLIOGRAFIA", out.get("POUT_CUR_BIBLIOGRAFIA"));
			objResultDAO.put("POUT_CUR_ARCHIVOS", out.get("POUT_CUR_ARCHIVOS"));
			
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
	public ClsResultDAO doLstDetPatente(ClsFilterDetRegistroBean objFiltro) {
		logger.info("doLstDetPatente()");
		System.out.println("doLstDetPatente()");
		try {
			
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_CTPI)
									.withCatalogName(ClsConstantes.PKG_BUSCADOR_CTPI)
									.withProcedureName(ClsConstantes.SP_LST_DET_PATENTE)
									.declareParameters(
									new  SqlOutParameter("POUT_CUR_DATO_PATENTE", OracleTypes.CURSOR ,
									new RowMapper<ClsDatoPatenteBean>() {
										@Override
										public ClsDatoPatenteBean mapRow(ResultSet rs, int rowNum)
												throws SQLException {
											ClsDatoPatenteBean objRespuesta=new ClsDatoPatenteBean();
											objRespuesta.setNuIdPatente(rs.getInt("NU_ID_PATENTE"));
											objRespuesta.setVcPubNumber(rs.getString("VC_PUB_NUMBER"));
											objRespuesta.setVcPubDate(rs.getString("VC_PUB_DATE"));
											objRespuesta.setVcNombreCientifico(rs.getString("VC_NOMBRE_CIENTIFICO"));
											objRespuesta.setVcTituloOriginal(rs.getString("VC_TITLE_ORIGINAL"));
											objRespuesta.setVcTituloIngles(rs.getString("VC_TITLE_ENGLISH"));
											objRespuesta.setVcAbstracEspanol(rs.getString("VC_TITLE_ENGLISH"));
											objRespuesta.setVcAbstracIngles(rs.getString("VC_ABSTRACT_ENGLISH"));
											objRespuesta.setVcIndependentClaims(rs.getString("VC_ABSTRACT_ENGLISH"));
											objRespuesta.setVcIpc4(rs.getString("VC_IPC4"));
											objRespuesta.setVcVentajaTecnica(rs.getString("VC_VENTAJA_TECNICA"));
											objRespuesta.setVcAssigneeAplicant(rs.getString("VC_ASSIGNEE_APLICANT"));
											objRespuesta.setVcPubCountryCode(rs.getString("VC_PUB_COUNTRY_CODE"));
											objRespuesta.setVcPubYear(rs.getString("VC_PUB_YEAR"));
											objRespuesta.setVcAppDate(rs.getString("VC_PUB_YEAR"));
											return objRespuesta;
										}
									}),
									new  SqlOutParameter("POUT_CUR_ACTIVIDAD", OracleTypes.CURSOR ,
											new RowMapper<ClsActividadBean>() {
												@Override
												public ClsActividadBean mapRow(ResultSet rs, int rowNum)
														throws SQLException {
													ClsActividadBean objRespuesta=new ClsActividadBean();
													objRespuesta.setNuIdActividad(rs.getInt("NU_ID_ACTIVIDAD"));
													objRespuesta.setVcActividad(rs.getString("VC_ACTIVIDAD"));
													return objRespuesta;
												}
											}),
									new  SqlOutParameter("POUT_NU_ERROR", OracleTypes.NUMBER ,"NUMBER"),
									new  SqlOutParameter("POUT_VC_ERROR", OracleTypes.VARCHAR ,"VARCHAR2")
									);
			

			 Map<String, Object> inParamMap = new HashMap();
			 inParamMap.put("PIN_NU_ID_REGISTRO", objFiltro.getNuIdRegistro());
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_DATO_PATENTE", out.get("POUT_CUR_DATO_PATENTE"));
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
	public ClsResultDAO doLstTodasAvanzado(ClsFiltroTodosAvanzadoBean objFiltro) {
		logger.info("doLstTodasAvanzado()");
		System.out.println("doLstTodasAvanzado()");
		try {
			
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_CTPI)
									.withCatalogName(ClsConstantes.PKG_BUSCADOR_CTPI)
									.withProcedureName(ClsConstantes.SP_LST_TODOS_AVANZADO)
									.declareParameters(
									new SqlParameter("PIN_ARR_NU_ID_ACTIVIDAD",			 OracleTypes.ARRAY,  "NUM_ARRAY"),
									new SqlParameter("PIN_ARR_VC_VALORES",			 OracleTypes.ARRAY,  "STR_ARRAY"), 
									new SqlParameter("PIN_ARR_VC_OPERADOR",			 OracleTypes.ARRAY,  "STR_ARRAY"), 
									new  SqlOutParameter("POUT_CUR_TODOS_AVAN", OracleTypes.CURSOR ,
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
			
			nuTamnio=objFiltro.getLstOperador().size();
			String[] vcOperador= new String[nuTamnio];
			for(int i=0; i<nuTamnio; i++) {
				ClsOperadorBean obj=objFiltro.getLstOperador().get(i);
				vcOperador[i]=obj.getVcOperador();
			}
			
			nuTamnio=objFiltro.getLstValor().size();
			String[] vcValor= new String[nuTamnio];
			for(int i=0; i<nuTamnio; i++) {
				ClsValorBean obj=objFiltro.getLstValor().get(i);
				vcValor[i]=obj.getVcValor();
			}
			
			System.out.println("objFiltro.getVcNombreCientifico(): "+objFiltro.getVcNombreCientifico());
	
			 Map<String, Object> inParamMap = new HashMap();
			 inParamMap.put("PIN_VC_NOM_CIENTIFICO", objFiltro.getVcNombreCientifico());
			 inParamMap.put("PIN_ARR_NU_ID_ACTIVIDAD"	, new SqlArrayValue<Integer>(nuIdActividad, "NUM_ARRAY"));
			 inParamMap.put("PIN_ARR_VC_VALORES"	, new SqlArrayValue<String>(vcValor, "STR_ARRAY"));
			 inParamMap.put("PIN_ARR_VC_OPERADOR"	, new SqlArrayValue<String>(vcOperador, "STR_ARRAY"));
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_TODOS_AVAN", out.get("POUT_CUR_TODOS_AVAN"));
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
	public ClsResultDAO doLstPatentes(ClsFiltroPatentesBean objFiltro) {
		logger.info("doLstPatentes()");
		System.out.println("doLstPatentes()");
		try {
			
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_CTPI)
									.withCatalogName(ClsConstantes.PKG_BUSCADOR_CTPI)
									.withProcedureName(ClsConstantes.SP_LST_PATENTES)
									.declareParameters(
									new SqlParameter("PIN_ARR_NU_ID_ACTIVIDAD",			 OracleTypes.ARRAY,  "NUM_ARRAY"), 	
									new  SqlOutParameter("POUT_CUR_PATENTE", OracleTypes.CURSOR ,
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
			 inParamMap.put("PIN_VC_RESUMEN", objFiltro.getVcResumen());
			 inParamMap.put("PIN_VC_TITULO_PATENTE", objFiltro.getVcTituloPatente());
			 inParamMap.put("PIN_VC_NUMERO_PUBLICACION", objFiltro.getVcNumeroPublicacion());
			 inParamMap.put("PIN_VC_REIVINDICACION", objFiltro.getVcReinvindicacion());
			 inParamMap.put("PIN_VC_CIP", objFiltro.getVcCip());
			 
			 inParamMap.put("PIN_ARR_NU_ID_ACTIVIDAD"	, new SqlArrayValue<Integer>(nuIdActividad, "NUM_ARRAY"));
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_PATENTE", out.get("POUT_CUR_PATENTE"));
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
	public ClsResultDAO doLstConocimientos(ClsFiltroConocimientosBean objFiltro) {
		logger.info("doLstConocimientos()");
		System.out.println("doLstConocimientos()");
		try {
			
			//procedure
			this.simpleJdbcCall=new SimpleJdbcCall(jdbcTemplate)
									.withSchemaName(ClsConstantes.SCHEMA_CTPI)
									.withCatalogName(ClsConstantes.PKG_BUSCADOR_CTPI)
									.withProcedureName(ClsConstantes.SP_LST_CONOCIMIENTO)
									.declareParameters(
									new SqlParameter("PIN_ARR_NU_ID_ACTIVIDAD",			 OracleTypes.ARRAY,  "NUM_ARRAY"), 	
									new  SqlOutParameter("POUT_CUR_CONOCIMIENTO", OracleTypes.CURSOR ,
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
			 inParamMap.put("PIN_NU_TIPO_CONOCIMIENTO", objFiltro.getNuIdTipoConocimiento());
			 inParamMap.put("PIN_VC_DESCRIPCION", objFiltro.getVcDescripcion());
			 inParamMap.put("PIN_VC_NOMBRE_COMUN", objFiltro.getVcNombreComun());
			 inParamMap.put("PIN_NU_TIPO_BIBLIOGRAFIA", objFiltro.getNuIdTipoBibliografia());
			 inParamMap.put("PIN_NU_PUEBLO", objFiltro.getNuIdPueblo());
			 
			 inParamMap.put("PIN_ARR_NU_ID_ACTIVIDAD"	, new SqlArrayValue<Integer>(nuIdActividad, "NUM_ARRAY"));
			//execute
			Map<String, Object> out = this.simpleJdbcCall.execute(inParamMap);
			
			//response
			objResultDAO.put("POUT_CUR_CONOCIMIENTO", out.get("POUT_CUR_CONOCIMIENTO"));
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
