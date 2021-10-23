package com.laboratorio.pruebas.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.laboratorio.pruebas.entity.RegistrosExcelBean;


public interface ExcelRepository extends CrudRepository<RegistrosExcelBean, Long> {
	
	@Query(value = "SELECT * FROM registros_excel where nombre = ?1 AND fecha_inicio = ?2",nativeQuery = true)
	public RegistrosExcelBean findByNombreAndDate(String nombre,Date fecha);

}
