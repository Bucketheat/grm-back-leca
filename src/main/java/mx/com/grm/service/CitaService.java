package mx.com.grm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mx.com.grm.model.BaseResponse;
import mx.com.grm.model.CitaDTO;
import mx.com.grm.model.entity.CitaEntity;
import mx.com.grm.repository.CitaRepository;


@Service
public class CitaService implements ICitaService {
	
	@Autowired
	private CitaRepository citaRepository;

	@Override
	public BaseResponse crearCita(CitaDTO model) {
		BaseResponse bsr = new BaseResponse();
		
		Optional<CitaEntity> citaTemp = citaRepository.findById(model.getIdCita());
		
		if(citaTemp.isPresent()) {
			bsr.setMensaje("Ya se encuentra registrada una cita con este numero");
			bsr.setStatus(HttpStatus.BAD_REQUEST);
			return bsr;
		}
		
		CitaEntity citaResponse = citaRepository.save(mappear(model));
		if(citaResponse !=null) {
			bsr.setAccess(true);
			bsr.setData(citaResponse);
			bsr.setMensaje("Registro con éxito");
			bsr.setStatus(HttpStatus.OK);
		}else {
			bsr.setMensaje("Se produjo un error al registrar");
			bsr.setStatus(HttpStatus.BAD_REQUEST);
		}
		
		return bsr;
	}

	@Override
	public BaseResponse editarCita(CitaDTO model) {
		BaseResponse bsr = new BaseResponse();
		
		Optional<CitaEntity> citaEntity = citaRepository.findById(model.getIdCita());
		
		if(citaEntity.isPresent()) {
			bsr.setAccess(true);
			bsr.setData(citaRepository.save(mappear(model)));
			bsr.setMensaje("Actualizacion con éxito");
			bsr.setStatus(HttpStatus.OK);
		}else {
			bsr.setMensaje("No existe la cita a modificar");
			bsr.setStatus(HttpStatus.BAD_REQUEST);
		} 
		
		return bsr;
	}

	@Override
	public BaseResponse consultarCita(Long id) {
		BaseResponse bsr = new BaseResponse();
		
		Optional<CitaEntity> citaEntity  = citaRepository.findById(id);
		
		if(citaEntity.isPresent()) {
			bsr.setAccess(true);
			bsr.setData(citaEntity);
			bsr.setMensaje("Consulta con éxito");
			bsr.setStatus(HttpStatus.OK);
		}else {
			bsr.setMensaje("No existe la cita");
			bsr.setStatus(HttpStatus.BAD_REQUEST);
		}
		return bsr;
	}

	@Override
	public BaseResponse consultarCitas() {
		BaseResponse bsr = new BaseResponse();
		
		List<CitaEntity> citaEntity  = citaRepository.findAll();
		
		if(!citaEntity.isEmpty()) {
			bsr.setAccess(true);
			bsr.setData(citaEntity);
			bsr.setMensaje("Consulta exitosa");
			bsr.setStatus(HttpStatus.OK);
		}else {

			bsr.setMensaje("No hay información");
			bsr.setStatus(HttpStatus.OK);
		}

		return bsr;
	}

	@Override
	public BaseResponse eliminarCita(CitaDTO model) {

		BaseResponse bsr = new BaseResponse();
		// TODO Auto-generated method stub
		CitaEntity citaResponse = citaRepository.save(mappear(model));
		if(citaResponse !=null) {
			bsr.setAccess(true);
			bsr.setData(citaResponse);
			bsr.setMensaje("Eliminación con éxito");
			bsr.setStatus(HttpStatus.OK);
		}else {
			bsr.setMensaje("Se produjo un error al eliminar");
			bsr.setStatus(HttpStatus.BAD_REQUEST);
		}
		return bsr;
	}
	
	
	private CitaEntity mappear (CitaDTO model) {
		CitaEntity citaEntityNew = new CitaEntity();
		
		citaEntityNew.setIdCita(model.getIdCita());
		citaEntityNew.setPaciente(model.getPaciente());
		citaEntityNew.setMedico(model.getMedico());
		citaEntityNew.setTipoCita(model.getTipoCita());
		citaEntityNew.setFecha(model.getFecha());
		citaEntityNew.setStatusCita(model.getStatusCita());
		return citaEntityNew;
	}
	
	

}
