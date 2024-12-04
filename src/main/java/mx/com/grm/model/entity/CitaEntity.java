package mx.com.grm.model.entity;



import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/***
 * @author Luis Calderon
 * @version 1.0.0
 * @since 03/12/2024
 */


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="citas")
public class CitaEntity {

	
	@Id 
	@OrderBy("idCita ASC")
	@Column(name ="idCita", updatable = false, nullable = false)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	//@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_ID_CITA", allocationSize = 11)
	private Long idCita;
	
	@Column(name ="paciente",nullable = false)
	private String paciente;
	
	@Column(name ="tipoCita",nullable = false)
	private String tipoCita;
	
	@Column(name ="medico",nullable = false)
	private String medico;
	
	@Column(name ="fecha",nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fecha;
	
	@Column(name = "status",nullable = false)
	private Long statusCita;
	
}
