package com.laboratorio.pruebas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.laboratorio.pruebas.dto.RegistrosExcel;
import com.laboratorio.pruebas.entity.RegistrosExcelBean;
import com.laboratorio.pruebas.service.IExcelService;


@RestController
@CrossOrigin( origins ="*" )
@RequestMapping({"/excel"})
public class ExcelController {
	
	@Autowired
	private IExcelService excelService;
	
	@PostMapping( value = "/cargarAlumnos")
	public @ResponseBody List<RegistrosExcel> cargarAluumnos( @RequestParam ("fileInput") MultipartFile file) {
		return excelService.respuesta(file);
	}
	
	@PostMapping( value = "/listar/{nombre}/{fecha}")
	public @ResponseBody RegistrosExcelBean listar(@PathVariable String nombre,@PathVariable String fecha ) {
		return excelService.findByNombreAndDate(nombre,fecha);
	}
	
	@GetMapping(value = "/listar/{nombre}")
	public RegistrosExcelBean listaPorNombre(@PathVariable String nombre) {
		return excelService.findByNombre(nombre);
	}
}
