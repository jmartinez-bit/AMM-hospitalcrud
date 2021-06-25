package com.example.hospitalserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hospitalserver.entities.Hospital;
import com.example.hospitalserver.repository.HospitalRepository;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Transactional(readOnly = true)
	public List<Hospital> list() {
		return hospitalRepository.findAll();
	}
	
	@Transactional
	public Hospital save(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
	
	@Transactional
	public void delete(Long id) {
		hospitalRepository.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Hospital findOne(Long id) {
		return hospitalRepository.findById(id).get();
	}
	
	@Transactional(readOnly = true)
	public boolean exists(Long id) {
		return hospitalRepository.existsById(id);
	}
	
}
