package com.example.hospitalserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospitalserver.entities.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

}
