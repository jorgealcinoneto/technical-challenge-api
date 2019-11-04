package com.jorgealcinoneto.technicalchallenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;


public interface OfficeRepository extends JpaRepository<Office, Long> {
	

}
