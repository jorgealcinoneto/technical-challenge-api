package com.jorgealcinoneto.technicalchallenge.api.services;

import org.springframework.stereotype.Service;

import com.jorgealcinoneto.technicalchallenge.api.entities.Profile;


@Service
public interface ProfileService {


	public Profile persist(Profile profile);
	
	
}
