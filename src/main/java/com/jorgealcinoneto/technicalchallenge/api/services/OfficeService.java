package com.jorgealcinoneto.technicalchallenge.api.services;

import java.util.List;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;



public interface OfficeService {

	public Office update(Office office);
	
	public List<Office> findAll();
	
}
