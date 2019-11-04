package com.jorgealcinoneto.technicalchallenge.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;

@Transactional(readOnly = true)
public interface OfficeRepository extends JpaRepository<Office, Long> {
	

}
