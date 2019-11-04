package com.jorgealcinoneto.technicalchallenge.api.services;

import org.springframework.stereotype.Service;

import com.jorgealcinoneto.technicalchallenge.api.entities.Office;


@Service
public interface OfficeService {

	public Office persist(Office office);
	
}
