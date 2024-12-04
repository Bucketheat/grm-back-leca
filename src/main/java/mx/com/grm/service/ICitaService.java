package mx.com.grm.service;

import mx.com.grm.model.BaseResponse;
import mx.com.grm.model.CitaDTO;

public interface ICitaService {

	BaseResponse crearCita (CitaDTO model);
	
	BaseResponse editarCita(CitaDTO model);
	
	BaseResponse consultarCita(Long id);
	
	BaseResponse consultarCitas();
	
	BaseResponse eliminarCita(CitaDTO id);
}
