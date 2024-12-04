package mx.com.grm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.grm.model.BaseResponse;
import mx.com.grm.model.CitaDTO;
import mx.com.grm.service.CitaService; 

/**
 * 
 * @author Luis Calderon
 */


@RestController 
@CrossOrigin
@RequestMapping("/apiCitas")
public class CitaController {
	
	@Autowired 
	private CitaService citaService;
	
	
	@PostMapping(path = "/crearCita", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> crearCitas(@RequestBody CitaDTO model){
		BaseResponse bsr = new BaseResponse(); 
		bsr = citaService.crearCita(model);
		
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	@PutMapping(path = "/editarCita", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> editar(@RequestBody CitaDTO model){
		BaseResponse bsr = new BaseResponse();
		
		bsr = citaService.editarCita(model);
		
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	@GetMapping(path = "/consultarCita/{model}", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> consultarCita(@PathVariable Long model){
		BaseResponse bsr = new BaseResponse();
		
		bsr = citaService.consultarCita(model);
		
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	@GetMapping(path = "/consultarCitas", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> consultarCitas(){
		BaseResponse bsr = new BaseResponse();
		
		bsr = citaService.consultarCitas();		
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	
	
	@DeleteMapping(path = "/eliminarCita", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResponse> eliminarCita(@RequestBody CitaDTO model){
		BaseResponse bsr = new BaseResponse();
		
		bsr = citaService.eliminarCita(model);
		
		return new ResponseEntity<>(bsr,bsr.getStatus());
	}
	
	

}
