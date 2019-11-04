package com.jorgealcinoneto.technicalchallenge.api.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;
import com.jorgealcinoneto.technicalchallenge.api.repositories.OfficeRepository;
import com.jorgealcinoneto.technicalchallenge.api.services.OfficeService;

@Service
public class OfficeServiceImpl implements OfficeService{
	
	private static final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);
	
	@Autowired
	private OfficeRepository officeRepository;

	@Override
	public Office persist(Office office) {
		
		log.info("Persisting Office: {}", office);
		return this.officeRepository.save(office);
	}


}
