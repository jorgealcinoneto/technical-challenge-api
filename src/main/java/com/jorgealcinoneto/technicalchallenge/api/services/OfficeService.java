package com.jorgealcinoneto.technicalchallenge.api.services;

import java.util.Optional;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;



public interface OfficeService {

	/**
	 * Persist a new office.
	 * 
	 * @param office
	 * @return Office
	 */
	public Office persist(Office office);
	
	public Optional<Office> findById(Long id);
}
