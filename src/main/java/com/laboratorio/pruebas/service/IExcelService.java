package com.laboratorio.pruebas.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.laboratorio.pruebas.dto.RegistrosExcel;
import com.laboratorio.pruebas.entity.RegistrosExcelBean;


public interface IExcelService {
	
	
	public List<RegistrosExcel> respuesta(MultipartFile file);
	
	public RegistrosExcelBean findByNombreAndDate(String nombre, String fecha);
	
	public RegistrosExcelBean findByNombre(String nombre);

}
