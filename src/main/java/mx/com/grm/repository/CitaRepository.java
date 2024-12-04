package mx.com.grm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.grm.model.entity.CitaEntity;


@Repository
public interface CitaRepository extends JpaRepository<CitaEntity, Long> {

}
