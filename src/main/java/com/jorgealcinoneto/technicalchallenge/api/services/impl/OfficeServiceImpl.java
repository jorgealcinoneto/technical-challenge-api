package com.jorgealcinoneto.technicalchallenge.api.services.impl;

import java.util.List;

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
	public Office update(Office office) {
		return null;
	}

	@Override
	public List<Office> findAll() {
		return null;
	}

}
