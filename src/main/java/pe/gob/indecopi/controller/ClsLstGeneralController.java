package pe.gob.indecopi.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.gob.indecopi.bean.ClsRecursoBean;
import pe.gob.indecopi.service.ClsLstGeneralServiceI;
@CrossOrigin(origins ="*", allowedHeaders = "*", maxAge = 3600)


@Controller
@RequestMapping({"/lstgeneral"})
public class ClsLstGeneralController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3012043086188667786L;
	
	@Autowired
	private ClsLstGeneralServiceI objConn;
	
	@RequestMapping(method = RequestMethod.POST, path = "/lsttodos", produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstGeneral() {
		return ResponseEntity.ok().body(objConn.doLstGeneral()) ;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/lstrecurso", consumes ="application/json" ,produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstRecurso(@RequestBody ClsRecursoBean objRecurso) {
		return ResponseEntity.ok().body(objConn.doLstRecurso(objRecurso)) ;
	}

}
