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

import pe.gob.indecopi.bean.ClsFilterDetRegistroBean;
import pe.gob.indecopi.bean.ClsFiltroConocimientosBean;
import pe.gob.indecopi.bean.ClsFiltroPatentesBean;
import pe.gob.indecopi.bean.ClsFiltroTodosAvanzadoBean;
import pe.gob.indecopi.bean.ClsFiltroTodosColeccionesBean;
import pe.gob.indecopi.service.ClsBusquedasServiceI;
@CrossOrigin(origins ="*", allowedHeaders = "*", maxAge = 3600)


@Controller
@RequestMapping({"/busqueda"})
public class ClsBusquedasController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3012043086188667786L;
	
	@Autowired
	private ClsBusquedasServiceI objConn;
	

	@RequestMapping(method = RequestMethod.POST, path = "/lsttodos", consumes ="application/json" ,produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstRecurso(@RequestBody ClsFiltroTodosColeccionesBean objFiltro) {
		return ResponseEntity.ok().body(objConn.doLstTodosColeccion(objFiltro)) ;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/lstdetalle", consumes ="application/json" ,produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstRecurso(@RequestBody ClsFilterDetRegistroBean objFiltro) {
		return ResponseEntity.ok().body(objConn.doDetalle(objFiltro)) ;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/lstavanzado", consumes ="application/json" ,produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstTodosAvanzado(@RequestBody ClsFiltroTodosAvanzadoBean objFiltro) {
		return ResponseEntity.ok().body(objConn.doLstTodosAvanzado(objFiltro));
	}
		
	@RequestMapping(method = RequestMethod.POST, path = "/lstpatentes", consumes ="application/json" ,produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstPatentes(@RequestBody ClsFiltroPatentesBean objFiltro) {
		return ResponseEntity.ok().body(objConn.doLstPatentes(objFiltro)) ;
	}
			
	@RequestMapping(method = RequestMethod.POST, path = "/lstconocimientos", consumes ="application/json" ,produces = "application/json")
	public @ResponseBody ResponseEntity<?> doLstConocimientos(@RequestBody ClsFiltroConocimientosBean objFiltro) {
				return ResponseEntity.ok().body(objConn.doLstConocimientos(objFiltro)) ;
	}

}
