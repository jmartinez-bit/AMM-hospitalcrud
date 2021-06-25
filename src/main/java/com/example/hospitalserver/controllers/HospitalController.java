package com.example.hospitalserver.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
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

import com.example.hospitalserver.entities.Hospital;
import com.example.hospitalserver.services.HospitalService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("/Get")
	public ResponseEntity<List<Hospital>> listHospital() {
	
		return new ResponseEntity<List<Hospital>>(hospitalService.list(), HttpStatus.OK);
	
	}
	
	@PostMapping("/Create")
	public ResponseEntity<?> saveHospital(@RequestBody Hospital hospital) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			hospitalService.save(hospital);
			
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al guardar en la bd");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "Hospital registrado satisfactoriamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/Update")
	public ResponseEntity<?> updateHospital(@RequestBody Hospital hospital) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			hospitalService.save(hospital);
			
		} catch(DataAccessException e) {
			
			response.put("mensaje", "Error al actualizar en la bd");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "Hospital actualizado satisfactoriamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteHospital(@PathVariable("id") Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		if(!hospitalService.exists(id)) {			
			response.put("mensaje", "Error al eliminar de la BD");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		hospitalService.delete(id);
		
		response.put("mensaje", "Registro eliminado satisfactoriamente");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
